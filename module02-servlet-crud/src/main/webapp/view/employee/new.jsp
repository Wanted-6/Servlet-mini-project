<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>사원 등록</title>
  <style>
    * {
      box-sizing: border-box;
    }

    body {
      margin: 0;
      padding: 40px;
      font-family: "Malgun Gothic", Arial, sans-serif;
      background-color: #f5f6f8;
      color: #222;
    }

    .container {
      width: 720px;
      margin: 0 auto;
      background: #fff;
      border-radius: 14px;
      padding: 32px;
      box-shadow: 0 4px 16px rgba(0, 0, 0, 0.08);
    }

    h1 {
      margin: 0 0 24px;
      font-size: 32px;
      font-weight: bold;
    }

    .form-group {
      margin-bottom: 18px;
    }

    label {
      display: block;
      margin-bottom: 8px;
      font-size: 15px;
      font-weight: bold;
    }

    .required {
      color: #d93025;
    }

    input, select {
      width: 100%;
      padding: 12px 14px;
      font-size: 15px;
      border: 1px solid #d0d7de;
      border-radius: 8px;
      outline: none;
    }

    input:focus, select:focus {
      border-color: #2d6cdf;
    }

    .hint {
      margin-top: 6px;
      font-size: 13px;
      color: #666;
    }

    .button-group {
      display: flex;
      gap: 12px;
      margin-top: 28px;
    }

    .btn {
      padding: 12px 20px;
      border: none;
      border-radius: 8px;
      font-size: 15px;
      cursor: pointer;
      text-decoration: none;
    }

    .btn-submit {
      background-color: #2d6cdf;
      color: white;
    }

    .btn-cancel {
      background-color: #e5e7eb;
      color: #222;
    }

    .error-message {
      margin-bottom: 20px;
      padding: 12px 14px;
      border-radius: 8px;
      background-color: #fff1f1;
      color: #c62828;
      font-size: 14px;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>사원 등록</h1>

  <% if (request.getAttribute("errorMessage") != null) { %>
  <div class="error-message">
    <%= request.getAttribute("errorMessage") %>
  </div>
  <% } %>

  <form action="${pageContext.request.contextPath}/employees/new" method="post">
    <div class="form-group">
      <label for="EMP_NO">사번 <span class="required">*</span></label>
      <input type="text" id="EMP_NO" name="EMP_NO" required>
      <div class="hint">필수 입력</div>
    </div>

    <div class="form-group">
      <label for="EMP_NAME">사원명 <span class="required">*</span></label>
      <input type="text" id="EMP_NAME" name="EMP_NAME" required>
      <div class="hint">필수 입력</div>
    </div>

    <div class="form-group">
      <label for="EMAIL">이메일</label>
      <input type="email" id="EMAIL" name="EMAIL" placeholder="example@email.com">
    </div>

    <div class="form-group">
      <label for="PHONE">전화번호</label>
      <input type="text" id="PHONE" name="PHONE" placeholder="010-1234-5678">
    </div>

    <div class="form-group">
      <label for="DEPT_CODE">부서코드</label>
      <input type="text" id="DEPT_CODE" name="DEPT_CODE">
    </div>

    <div class="form-group">
      <label for="JOB_CODE">직급코드 <span class="required">*</span></label>
      <input type="text" id="JOB_CODE" name="JOB_CODE" required>
      <div class="hint">필수 입력</div>
    </div>

    <div class="form-group">
      <label for="SALARY">급여</label>
      <input type="number" id="SALARY" name="SALARY" min="0" step="1">
      <div class="hint">숫자만 입력</div>
    </div>

    <div class="form-group">
      <label for="HIRE_DATE">입사일</label>
      <input type="date" id="HIRE_DATE" name="HIRE_DATE">
      <div class="hint">날짜 형식 입력</div>
    </div>

    <div class="form-group">
      <label for="ENT_YN">퇴직여부</label>
      <select id="ENT_YN" name="ENT_YN">
        <option value="false">재직</option>
        <option value="true">퇴직</option>
      </select>
    </div>

    <div class="button-group">
      <button type="submit" class="btn btn-submit">등록</button>
      <a href="${pageContext.request.contextPath}/employees" class="btn btn-cancel">취소</a>
    </div>
  </form>
</div>
</body>
</html>