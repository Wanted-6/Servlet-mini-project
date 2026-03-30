package com.wanted.crud.service;

import com.wanted.crud.dao.EmployeeDAO;
import com.wanted.crud.dto.EmployeeDTO;

import java.sql.Connection;

import static com.wanted.crud.global.JDBCTemplate.close;
import static com.wanted.crud.global.JDBCTemplate.getConnection;

public class EmployeeService {
    private final EmployeeDAO employeeDAO;
    private final Connection connection;
    public EmployeeService(Connection connection) {
        this.connection = connection;
        this.employeeDAO = new EmployeeDAO(connection);
    }
    public int registerEmployee(EmployeeDTO employee) {
        try {
            validate(employee);

            if (employeeDAO.existsByEmpNo(connection, employee.getEMP_NO())) {
                throw new IllegalArgumentException("이미 존재하는 사번입니다.");
            }

            int result = employeeDAO.insertEmployee(connection, employee);

            if (result <= 0) {
                throw new RuntimeException("사원 등록에 실패했습니다.");
            }

            return result;

        } finally {
            close(connection);
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
