package com.wanted.crud.dao;

import com.wanted.crud.global.JDBCTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MinSeoDAO {

    private final Connection connection;

    public MinSeoDAO(Connection connection) {
        this.connection = connection;
    }

    public int deleteEmployee(Connection con, String empId) {

        PreparedStatement pstmt = null;
        int result = 0;

        String query = "DELETE FROM EMPLOYEE WHERE EMP_ID = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empId);

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("사원 삭제 DAO 처리 중 오류 발생", e);
        } finally {
            JDBCTemplate.close(pstmt);
        }

        return result;

    }
}