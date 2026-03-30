package com.wanted.crud.controller;

import com.wanted.crud.dto.EmployeeDTO;
import com.wanted.crud.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employees/detail")
public class EmployeeDetailServlet extends HttpServlet {

    private final EmployeeService employeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Object loginUser = req.getSession().getAttribute("loginUser");

        if (loginUser == null) {
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }

        String empIdParam = req.getParameter("empId");

        if (empIdParam == null || empIdParam.isBlank()) {
            req.setAttribute("message", "잘못된 사번 요청입니다.");
            req.getRequestDispatcher("/view/common/errorpage.jsp").forward(req, resp);
            return;
        }

        Long empId;

        try {
            empId = Long.parseLong(empIdParam);
        } catch (NumberFormatException e) {
            req.setAttribute("message", "사번 형식이 올바르지 않습니다.");
            req.getRequestDispatcher("/view/common/errorpage.jsp").forward(req, resp);
            return;
        }

        EmployeeDTO employee = employeeService.selectEmployeeById(empId);

        if (employee == null) {
            req.setAttribute("message", "존재하지 않는 사원입니다.");
            req.getRequestDispatcher("/view/common/errorpage.jsp").forward(req, resp);
            return;
        }

        req.setAttribute("employee", employee);
        req.getRequestDispatcher("/view/employee/detail.jsp").forward(req, resp);
    }
}
