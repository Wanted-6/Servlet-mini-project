package com.wanted.crud.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.wanted.crud.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employees/delete")
public class EmployeeDeleteServlet extends HttpServlet {
    private final EmployeeService employeeService = new EmployeeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String empId = req.getParameter("empId");

        try {
            int result = employeeService.deleteEmployee(empId);

            if (result > 0) {
                resp.sendRedirect(req.getContextPath() + "/employees");
            } else {
                req.setAttribute("message", "삭제할 사원이 존재하지 않거나 삭제에 실패했습니다.");
                req.getRequestDispatcher("/errorpage.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            req.setAttribute("message", "사원 삭제 중 오류가 발생했습니다.");
            req.setAttribute("exception", e);
            req.getRequestDispatcher("/view/common/errorpage.jsp").forward(req, resp);
            /// ////////////////////////////
        }
    }
}
