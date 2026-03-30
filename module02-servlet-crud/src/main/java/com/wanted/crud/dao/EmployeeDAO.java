package com.wanted.crud.dao;

import com.wanted.crud.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Date;

public class EmployeeDAO {
    private final Connection connection;

    public int deleteEmployee(Connection con, String empId) {

        PreparedStatement pstmt = null;
        int result = 0;

        String query = "DELETE FROM employee WHERE EMP_ID = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empId);
    public EmployeeDAO(Connection connection) {this.connection = connection;}

    public int insertEmployee(Connection conn, EmployeeDTO employee) {
        String sql = """
                INSERT INTO EMPLOYEE
                (
                    EMP_NAME,
                    EMP_NO,
                    EMAIL,
                    PHONE,
                    DEPT_CODE,
                    JOB_CODE,
                    SAL_LEVEL,
                    SALARY,
                    BONUS,
                    MANAGER_ID,
                    HIRE_DATE,
                    ENT_DATE,
                    ENT_YN
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, employee.getEMP_NAME());
            pstmt.setString(2, employee.getEMP_NO());
            pstmt.setString(3, employee.getEMAIL());
            pstmt.setString(4, employee.getPHONE());
            pstmt.setString(5, employee.getDEPT_CODE());
            pstmt.setString(6, employee.getJOB_CODE());
            pstmt.setString(7, employee.getSALE_LEVEL());

            if (employee.getSALARY() != null) {
                pstmt.setLong(8, employee.getSALARY());
            } else {
                pstmt.setNull(8, java.sql.Types.BIGINT);
            }

            if (employee.getBONUS() != null) {
                pstmt.setDouble(9, employee.getBONUS());
            } else {
                pstmt.setNull(9, java.sql.Types.DOUBLE);
            }

            if (employee.getMANAGER_ID() != null) {
                pstmt.setLong(10, employee.getMANAGER_ID());
            } else {
                pstmt.setNull(10, java.sql.Types.BIGINT);
            }

            if (employee.getHIRE_DATE() != null) {
                pstmt.setTimestamp(11, Timestamp.valueOf(employee.getHIRE_DATE()));
            } else {
                pstmt.setNull(11, java.sql.Types.TIMESTAMP);
            }

            if (employee.getENT_DATE() != null) {
                pstmt.setDate(12, Date.valueOf(employee.getENT_DATE()));
            } else {
                pstmt.setNull(12, java.sql.Types.DATE);
            }

            if (employee.getENT_YN() != null) {
                pstmt.setBoolean(13, employee.getENT_YN());
            } else {
                pstmt.setNull(13, java.sql.Types.BOOLEAN);
            }

            return pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        } catch (SQLException e) {
            throw new RuntimeException("사원 등록 DAO 처리 중 오류 발생", e);
        }
    }

    public boolean existsByEmpNo(Connection conn, String empNo) {
        String sql = """
                SELECT COUNT(*)
                FROM EMPLOYEE
                WHERE EMP_NO = ?
                """;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empNo);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("사번 중복 확인 중 오류 발생", e);
        }

        return false;
    }
}


