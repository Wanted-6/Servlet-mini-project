<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wanted.crud.dto.EmployeeDTO" %>
<%
    List<EmployeeDTO> employeeList = (List<EmployeeDTO>) request.getAttribute("employeeList");
%>
<html>
<head>
    <title>사원 목록 조회</title>
</head>
<body>
<h1>사원 목록</h1>

<div>
    <a href="<%= request.getContextPath() %>/">메인으로</a>
</div>

<hr>

<table border ="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>사번</th>
        <th>사원명</th>
        <th>이메일</th>
        <th>전화번호</th>
        <th>부서명</th>
        <th>직급명</th>
        <th>급여</th>
        <th>재직상태</th>
        <th>상세조회</th>
    </tr>

    <%
        if (employeeList == null || employeeList.isEmpty()) {
    %>
    <tr>
        <td colspan="9">조회된 사원이 없습니다.</td>
    </tr>
    <%
    } else {
        for (EmployeeDTO employee : employeeList) {
    %>
    <tr>
        <td><%= employee.getEMP_ID() %></td>
        <td><%= employee.getEMP_NAME() %></td>
        <td><%= employee.getEMAIL() %></td>
        <td><%= employee.getPHONE() %></td>
        <td><%= employee.getDEPT_TITLE() %></td>
        <td><%= employee.getJOB_NAME() %></td>
        <td><%= employee.getSALARY() %></td>
        <td><%= "Y".equals(employee.getENT_YN()) ? "퇴사" : "재직" %></td>
        <td>
            <a href="<%= request.getContextPath() %>/employees/detail?empId=<%= employee.getEMP_ID() %>">
                상세조회
            </a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
