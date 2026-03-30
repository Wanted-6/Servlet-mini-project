package com.wanted.crud.dao;

import com.wanted.crud.dto.EmployeeDTO;
import com.wanted.crud.global.JDBCTemplate;

import java.sql.*;

public class BJHDAO {

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

        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, employee.getEMP_NAME());
            pstmt.setString(2, employee.getEMP_NO());
            pstmt.setString(3, employee.getEMAIL());
            pstmt.setString(4, employee.getPHONE());
            pstmt.setString(5, employee.getDEPT_CODE());
            pstmt.setString(6, employee.getJOB_CODE());
            pstmt.setString(7, employee.getSALE_LEVEL()); // ⚠️ 필요시 SAL_LEVEL로 수정

            if (employee.getSALARY() != null) {
                pstmt.setLong(8, employee.getSALARY());
            } else {
                pstmt.setNull(8, Types.BIGINT);
            }

            if (employee.getBONUS() != null) {
                pstmt.setDouble(9, employee.getBONUS());
            } else {
                pstmt.setNull(9, Types.DOUBLE);
            }

            if (employee.getMANAGER_ID() != null) {
                pstmt.setLong(10, employee.getMANAGER_ID());
            } else {
                pstmt.setNull(10, Types.BIGINT);
            }

            if (employee.getHIRE_DATE() != null) {
                pstmt.setTimestamp(11, Timestamp.valueOf(employee.getHIRE_DATE()));
            } else {
                pstmt.setNull(11, Types.TIMESTAMP);
            }

            if (employee.getENT_DATE() != null) {
                pstmt.setDate(12, Date.valueOf(employee.getENT_DATE()));
            } else {
                pstmt.setNull(12, Types.DATE);
            }

            if (employee.getENT_YN() != null) {
                pstmt.setBoolean(13, employee.getENT_YN());
            } else {
                pstmt.setNull(13, Types.BOOLEAN);
            }

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("사원 등록 DAO 처리 중 오류 발생", e);
        } finally {
            JDBCTemplate.close(pstmt);
        }
    }

    // ✅ 사번 중복 체크
    public boolean existsByEmpNo(Connection conn, String empNo) {

        String sql = """
                SELECT COUNT(*)
                FROM EMPLOYEE
                WHERE EMP_NO = ?
                """;

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, empNo);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            throw new RuntimeException("사번 중복 확인 중 오류 발생", e);
        } finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
        }

        return false;
    }
}
