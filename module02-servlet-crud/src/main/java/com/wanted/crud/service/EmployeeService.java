package com.wanted.crud.service;

import com.wanted.crud.dao.BJHDAO;
import com.wanted.crud.dao.PMSDAO;
import com.wanted.crud.dto.EmployeeDTO;
import com.wanted.crud.global.JDBCTemplate;

import java.sql.Connection;

public class EmployeeService {

    private final PMSDAO employeeDAO = new PMSDAO();
    private final BJHDAO bjhDAO = new BJHDAO();

    public int registerEmployee(EmployeeDTO employee) {
        Connection connection = JDBCTemplate.getConnection();

        try {
            validate(employee);

            if (bjhDAO.existsByEmpNo(connection, employee.getEMP_NO())) {
                throw new IllegalArgumentException("이미 존재하는 사번입니다.");
            }

            int result = bjhDAO.insertEmployee(connection, employee);

            if (result <= 0) {
                throw new RuntimeException("사원 등록에 실패했습니다.");
            }

            return result;

        } finally {
            JDBCTemplate.close(connection);
        }
    }

    public int deleteEmployee(String empId) {
        Connection connection = JDBCTemplate.getConnection();

        try {
            return employeeDAO.deleteEmployee(connection, empId);
        } finally {
            JDBCTemplate.close(connection);
        }
    }

    private void validate(EmployeeDTO employee) {
        if (employee.getEMP_NO() == null || employee.getEMP_NO().isBlank()) {
            throw new IllegalArgumentException("사번은 필수입니다.");
        }

        if (employee.getEMP_NAME() == null || employee.getEMP_NAME().isBlank()) {
            throw new IllegalArgumentException("사원명은 필수입니다.");
        }

        if (employee.getJOB_CODE() == null || employee.getJOB_CODE().isBlank()) {
            throw new IllegalArgumentException("직급코드는 필수입니다.");
        }
    }
}