package com.wanted.crud.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.wanted.crud.service.EmployeeService;


import java.io.IOException;

@WebServlet("/employees/delete")
public class EmployeeDeleteServlet extends HttpServlet {
    private final EmployeeService employeeService = new EmployeeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empId = req.getParameter("empId");
        System.out.println("삭제 요청 empId = " + empId);

        int result = employeeService.deleteEmployee(empId);

        if (result > 0) {
            System.out.println("삭제 성공");
            resp.sendRedirect(req.getContextPath() + "/employees");
        } else {
            System.out.println("삭제 실패");
            req.setAttribute("message", "삭제 실패");
            req.getRequestDispatcher("/view/common/errorpage.jsp").forward(req, resp);
        }
    }
}