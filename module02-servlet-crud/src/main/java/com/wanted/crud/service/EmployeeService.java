package com.wanted.crud.service;

import com.wanted.crud.dao.EmployeeDAO;

public class EmployeeService {

    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    public int deleteEmployee(String empId) {
        return employeeDAO.deleteEmployee(empId);
    }
}
