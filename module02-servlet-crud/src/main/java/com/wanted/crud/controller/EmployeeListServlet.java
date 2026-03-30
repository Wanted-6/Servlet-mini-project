package com.wanted.crud.controller;

import com.wanted.crud.dto.EmployeeDTO;
import com.wanted.crud.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class EmployeeListServlet extends HttpServlet {

    private final EmployeeService employeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Object loginUser = req.getSession().getAttribute("loginUser");

        if (loginUser == null) {
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }

        List<EmployeeDTO> employeeList = employeeService.selectAllEmployees();

        req.setAttribute("employeeList", employeeList);
        req.getRequestDispatcher("/view/employee/list.jsp").forward(req, resp);
    }
}
