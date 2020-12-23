<%-- 一般ユーザるグイン画面
@author : WintShweSin
@version: 1.0
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="common/css/style.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"></jsp:include>
<body>
	<div class="title">
		<h3>一般ユーザログイン</h3>
	</div>
	<div class="main_area">
		<c:forEach var="error" items="${requestScope.error}">
			<div class="alert alert-danger center" role="alert">
				<ul>
					<li>${error}</li>
				</ul>
			</div>
		</c:forEach>

		<form action="<%=request.getContextPath()%>/Login" method="post">
			<div class="form-group">
				<label for="employee_code">Employee Code:</label> <input type="text"
					class="form-control" id="employe_code" placeholder="従業員番号"
					name="employee_code" maxlength = "7" required>
			</div>
			<div class="form-group">
				<label for="uname">Password:</label> <input type="password"
					class="form-control" id="password" placeholder="パスワード"
					name="password" maxlength ="30" required>
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
		<div>
			<p>
				<a href="<%=request.getContextPath()%>/admin_login.jsp"
					class="nav-link">管理者様ログインページはこちら</a>
			</p>
		</div>

	</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>