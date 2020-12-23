<%-- 管理者ログイン画面
@author : WintShweSin
@version: 1.0
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<div class="title">
		<h3>管理者ログイン</h3>
	</div>
	<div class="main_area">
		<c:forEach var="error" items="${requestScope.error}">
			<div class="alert alert-danger center" role="alert">
				<ul>
					<li>${error}</li>
				</ul>
			</div>
		</c:forEach>
		<form action="AdminLogin" method="post">
			<div class="form-group">
				<label for="employee_code">Admin Code:</label> <input type="text"
					class="form-control" id="employee_code" placeholder="管理者番号"
					name="employee_code" maxlength="7" required>
			</div>
			<div class="form-group">
				<label for="uname">Password:</label> <input type="password"
					class="form-control" id="password" placeholder="パスワード"
					name="password" maxlength="30" required>
			</div>
			<input type="hidden" id="permission" name="permission" value="Y">
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
	</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>