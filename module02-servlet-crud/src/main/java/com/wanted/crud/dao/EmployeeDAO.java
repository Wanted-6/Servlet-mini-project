package com.wanted.crud.dao;

import com.wanted.crud.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public List<EmployeeDTO> selectAllEmployees(Connection con) {

        List<EmployeeDTO> employeeList = new ArrayList<>();

        String query = """
                SELECT
                    e.EMP_ID,
                    e.EMP_NAME,
                    e.EMAIL,
                    e.PHONE,
                    e.DEPT_CODE,
                    d.DEPT_TITLE,
                    e.JOB_CODE,
                    j.JOB_NAME,
                    e.SALARY,
                    e.HIRE_DATE,
                    e.ENT_DATE,
                    e.ENT_YN
                FROM EMPLOYEE e
                LEFT JOIN DEPARTMENT d ON e.DEPT_CODE = d.DEPT_ID
                LEFT JOIN JOB j ON e.JOB_CODE = j.JOB_CODE
                ORDER BY e.EMP_ID
                """;

        try (
                PreparedStatement pstmt = con.prepareStatement(query);
                ResultSet rset = pstmt.executeQuery()
        ) {
            while (rset.next()) {
                EmployeeDTO employee = new EmployeeDTO();

                employee.setEMP_ID(rset.getLong("EMP_ID"));
                employee.setEMP_NAME(rset.getString("EMP_NAME"));
                employee.setEMAIL(rset.getString("EMAIL"));
                employee.setPHONE(rset.getString("PHONE"));
                employee.setDEPT_CODE(rset.getString("DEPT_CODE"));
                employee.setDEPT_TITLE(rset.getString("DEPT_TITLE"));
                employee.setJOB_CODE(rset.getString("JOB_CODE"));
                employee.setJOB_NAME(rset.getString("JOB_NAME"));
                employee.setSALARY(rset.getLong("SALARY"));

                Timestamp hireTimestamp = rset.getTimestamp("HIRE_DATE");
                if (hireTimestamp != null) {
                    employee.setHIRE_DATE(hireTimestamp.toLocalDateTime());
                }

                Date entDate = rset.getDate("ENT_DATE");
                if (entDate != null) {
                    employee.setENT_DATE(entDate.toLocalDate());
                }

                employee.setENT_YN(rset.getString("ENT_YN"));

                employeeList.add(employee);
            }

        } catch (Exception e) {
            throw new RuntimeException("사원 목록 조회 중 오류가 발생했습니다.", e);
        }

        return employeeList;
    }

    public EmployeeDTO selectEmployeeById(Connection con, Long empId) {

        EmployeeDTO employee = null;

        String query = """
                SELECT
                    e.EMP_ID,
                    e.EMP_NAME,
                    e.EMP_DOB,
                    e.EMAIL,
                    e.PHONE,
                    e.DEPT_CODE,
                    d.DEPT_TITLE,
                    e.JOB_CODE,
                    j.JOB_NAME,
                    e.SALE_LEVEL,
                    e.SALARY,
                    e.BONUS,
                    e.MANAGER_ID,
                    e.HIRE_DATE,
                    e.ENT_DATE,
                    e.ENT_YN
                FROM EMPLOYEE e
                LEFT JOIN DEPARTMENT d ON e.DEPT_CODE = d.DEPT_ID
                LEFT JOIN JOB j ON e.JOB_CODE = j.JOB_CODE
                WHERE e.EMP_ID = ?
                """;

        try (PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setLong(1, empId);

            try (ResultSet rset = pstmt.executeQuery()) {
                if (rset.next()) {
                    employee = new EmployeeDTO();

                    employee.setEMP_ID(rset.getLong("EMP_ID"));
                    employee.setEMP_NAME(rset.getString("EMP_NAME"));
                    employee.setEMP_DOB(rset.getString("EMP_DOB"));
                    employee.setEMAIL(rset.getString("EMAIL"));
                    employee.setPHONE(rset.getString("PHONE"));
                    employee.setDEPT_CODE(rset.getString("DEPT_CODE"));
                    employee.setDEPT_TITLE(rset.getString("DEPT_TITLE"));
                    employee.setJOB_CODE(rset.getString("JOB_CODE"));
                    employee.setJOB_NAME(rset.getString("JOB_NAME"));
                    employee.setSALE_LEVEL(rset.getString("SALE_LEVEL"));
                    employee.setSALARY(rset.getLong("SALARY"));

                    double bonus = rset.getDouble("BONUS");
                    if (!rset.wasNull()) {
                        employee.setBONUS(bonus);
                    }

                    long managerId = rset.getLong("MANAGER_ID");
                    if (!rset.wasNull()) {
                        employee.setMANAGER_ID(managerId);
                    }

                    Timestamp hireTimestamp = rset.getTimestamp("HIRE_DATE");
                    if (hireTimestamp != null) {
                        employee.setHIRE_DATE(hireTimestamp.toLocalDateTime());
                    }

                    Date entDate = rset.getDate("ENT_DATE");
                    if (entDate != null) {
                        employee.setENT_DATE(entDate.toLocalDate());
                    }

                    employee.setENT_YN(rset.getString("ENT_YN"));
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("사원 상세 조회 중 오류가 발생했습니다.", e);
        }

        return employee;
    }
}