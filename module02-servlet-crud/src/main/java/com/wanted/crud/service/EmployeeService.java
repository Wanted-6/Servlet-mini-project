package com.wanted.crud.service;

import com.wanted.crud.dao.MinSeoDAO;
import com.wanted.crud.global.JDBCTemplate;

import java.sql.Connection;
import com.wanted.crud.dto.EmployeeDTO;



import static com.wanted.crud.global.JDBCTemplate.close;

public class EmployeeService {
    private final MinSeoDAO minSeoDAO;
    private final Connection connection;

    public EmployeeService(Connection connection) {
        this.connection = connection;
        this.minSeoDAO = new MinSeoDAO(connection);
    }

    public int deleteEmployee(String empId) {
        Connection con = JDBCTemplate.getConnection();

        int result = minSeoDAO.deleteEmployee(con, empId);

        JDBCTemplate.close(con);

        return result;
    }
}

