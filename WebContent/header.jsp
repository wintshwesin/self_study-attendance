<%-- Header画面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="../bootstrap-datepicker-1.6.4-dist/css/bootstrap-datepicker.min.css">
	<link rel="stylesheet" href="common/css/style.css">
	<%@page import="java.util.TimeZone"%>
	<%@page import="java.util.Date"%>
	<%@page import="java.text.SimpleDateFormat"%>
	<header>
	<%
	TimeZone tz = TimeZone.getTimeZone("Asia/Tokyo");
	SimpleDateFormat sformat = new SimpleDateFormat("MMMMM dd, yyyy HH:mm:ss");
	%>

	<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: teal">
		<div>
			<a href="#" class="navbar-brand"> Attendance Management System</a>
		</div>
		<ul class="navbar-nav navbar-collapse justify-content-end">
			<li class="nav-link"><%=sformat.format(new Date())%></li>
		</ul>
	</nav>
</header>