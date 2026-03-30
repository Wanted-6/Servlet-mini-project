package com.wanted.crud.controller;

import com.wanted.crud.dto.EmployeeDTO;
import com.wanted.crud.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@WebServlet("/employeesregister")
public class EmployeeRegistServlet extends HttpServlet {
    private final EmployeeService employeeService;

    public EmployeeRegistServlet (EmployeeService employeeService) {
        this.employeeService=employeeService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/employee/new.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        try {
            // JSP의 input name 값과 반드시 맞춰야 함
            String empNo = req.getParameter("EMP_NO");
            String empName = req.getParameter("EMP_NAME");
            String email = req.getParameter("EMAIL");
            String phone = req.getParameter("PHONE");
            String deptCode = req.getParameter("DEPT_CODE");
            String jobCode = req.getParameter("JOB_CODE");
            String salaryStr = req.getParameter("SALARY");
            String hireDateStr = req.getParameter("HIRE_DATE");
            String entYnStr = req.getParameter("ENT_YN");

            Long salary = null;
            if (salaryStr != null && !salaryStr.isBlank()) {
                salary = Long.parseLong(salaryStr);
            }

            LocalDateTime hireDate = null;
            if (hireDateStr != null && !hireDateStr.isBlank()) {
                hireDate = LocalDate.parse(hireDateStr).atStartOfDay();
            }

            Boolean entYn = null;
            if (entYnStr != null && !entYnStr.isBlank()) {
                entYn = Boolean.parseBoolean(entYnStr);
            }

            EmployeeDTO employee = new EmployeeDTO();
            employee.setEMP_NO(empNo);
            employee.setEMP_NAME(empName);
            employee.setEMAIL(email);
            employee.setPHONE(phone);
            employee.setDEPT_CODE(deptCode);
            employee.setJOB_CODE(jobCode);
            employee.setSALARY(salary);
            employee.setHIRE_DATE(hireDate);
            employee.setENT_YN(entYn);

            int result = employeeService.registerEmployee(employee);

            if (result > 0) {
                resp.sendRedirect("/index.html");
            } else {
                req.setAttribute("errorMessage", "사원 등록에 실패했습니다.");
                req.getRequestDispatcher("/WEB-INF/views/employee/new.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/employee/new.jsp").forward(req, resp);
        }
    }
}