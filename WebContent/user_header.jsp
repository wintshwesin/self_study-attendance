<%-- Header画面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="common/css/style.css">
<%@page import="java.util.TimeZone"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="attendance.model.EmployeeBean"%>
<header>
	<%
		TimeZone tz = TimeZone.getTimeZone("Asia/Tokyo");
		SimpleDateFormat sformat = new SimpleDateFormat("MMMMM dd, yyyy HH:mm:ss");
	%>
	<%
	String employee_code = (String) session.getAttribute("employee_code");
	if(employee_code == null) {
		response.sendRedirect("index.jsp");
	} else {
%>

	<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: teal">
		<div>
			<a href="#" class="navbar-brand">
				Attendance Management System</a>
		</div>
		<form action="ShowEmployee" method="post">
			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li class="nav-link">
					<!-- <button type="submit" class="btn btn-link">個人情報</button> -->
					<input type="hidden" value="<%=session.getAttribute("employee_code") %>"/>
				</li>
				<li class="nav-item">
					<button type="button" class="btn btn-link"
						onclick="location.href='index.jsp';">ログアウト</button>
				</li>
			</ul>
		</form>
	</nav>
</header>
<%
}
%>