package com.wanted.crud.service;

import com.wanted.crud.dao.EmployeeDAO;
import com.wanted.crud.global.JDBCTemplate;

import java.sql.Connection;

public class EmployeeService {

    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    public int deleteEmployee(String empId) {
        Connection con = JDBCTemplate.getConnection();

        int result = employeeDAO.deleteEmployee(con, empId);

        JDBCTemplate.close(con);

        return result;
    }
    }

