<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>사원 상세 조회</title>
</head>
<body>
<h1>사원 상세 정보</h1>

<div>
    <a href="${pageContext.request.contextPath}/employees">목록으로</a>
    <a href="${pageContext.request.contextPath}/">메인으로</a>
</div>

<hr>

<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>사번</th>
        <td>${employee.EMP_ID}</td>
    </tr>
    <tr>
        <th>사원명</th>
        <td>${employee.EMP_NAME}</td>
    </tr>
    <tr>
        <th>생년월일</th>
        <td>${employee.EMP_DOB}</td>
    </tr>
    <tr>
        <th>이메일</th>
        <td>${employee.EMAIL}</td>
    </tr>
    <tr>
        <th>전화번호</th>
        <td>${employee.PHONE}</td>
    </tr>
    <tr>
        <th>부서코드</th>
        <td>${employee.DEPT_CODE}</td>
    </tr>
    <tr>
        <th>부서명</th>
        <td>${employee.DEPT_TITLE}</td>
    </tr>
    <tr>
        <th>직급코드</th>
        <td>${employee.JOB_CODE}</td>
    </tr>
    <tr>
        <th>직급명</th>
        <td>${employee.JOB_NAME}</td>
    </tr>
    <tr>
        <th>급여등급</th>
        <td>${employee.SALE_LEVEL}</td>
    </tr>
    <tr>
        <th>급여</th>
        <td>${employee.SALARY}</td>
    </tr>
    <tr>
        <th>보너스</th>
        <td>${employee.BONUS}</td>
    </tr>
    <tr>
        <th>매니저 사번</th>
        <td>${employee.MANAGER_ID}</td>
    </tr>
    <tr>
        <th>입사일</th>
        <td>${employee.HIRE_DATE}</td>
    </tr>
    <tr>
        <th>퇴사일</th>
        <td>${employee.ENT_DATE}</td>
    </tr>
    <tr>
        <th>재직상태</th>
        <td>${employee.ENT_YN eq 'Y' ? '퇴사' : '재직'}</td>
    </tr>
</table>
</body>
</html>
