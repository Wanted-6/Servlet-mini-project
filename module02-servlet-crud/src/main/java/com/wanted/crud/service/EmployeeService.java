package com.wanted.crud.service;

import com.wanted.crud.dao.EmployeeSelectDAO;
import com.wanted.crud.dto.EmployeeDTO;
import com.wanted.crud.global.JDBCTemplate;

import java.sql.Connection;
import java.util.List;

public class EmployeeService {

    private final EmployeeSelectDAO employeeDAO = new EmployeeSelectDAO();

    public List<EmployeeDTO> selectAllEmployees() {
        Connection con = JDBCTemplate.getConnection();

        try {
            return employeeDAO.selectAllEmployees(con);
        } finally {
            JDBCTemplate.close(con);
        }
    }

    public EmployeeDTO selectEmployeeById(Long empId) {
        Connection con = JDBCTemplate.getConnection();

        try {
            return employeeDAO.selectEmployeeById(con, empId);
        } finally {
            JDBCTemplate.close(con);
        }
    }
}