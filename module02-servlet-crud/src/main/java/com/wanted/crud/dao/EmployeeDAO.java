package com.wanted.crud.dao;

import com.wanted.crud.global.JDBCTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {

    public int deleteEmployee(String empId) {

        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;

        String sql = "DELETE FROM employee WHERE emp_id = ?";

        try {
            con = JDBCTemplate.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, empId);

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("사원 삭제 DAO 오류", e);
        } finally {
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(con);
        }

        return result;
    }
}
