package com.wanted.crud.dao;

import com.wanted.crud.global.JDBCTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {

    public int deleteEmployee(Connection con, String empId) {

        PreparedStatement pstmt = null;
        int result = 0;

        String query = "DELETE FROM employee WHERE EMP_ID = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empId);

            result = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }

        return result;
    }
}
