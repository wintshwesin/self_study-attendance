<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="attendance.model.EmployeeBean"%>
     <%@page import="attendance.dao.EmployeeDao"%>
<jsp:include page="user_header.jsp"></jsp:include>
<%
	String employee_code = (String) session.getAttribute("employee_code");
	if(employee_code == null) {
		response.sendRedirect("index.jsp");
	} else {
%>
<body>
	<h3>従業員情報</h3>
	<div class="main_form">
		<form action="EmployeeRegister" method="post" >
			<%-- <div class="alert alert-success center" role="alert">
				<p>${noti}</p>
			</div> --%>

  			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="employee_code">Employee Code:</label>
				</div>
				<div class="col-md-9">
					<div class="form-group">
						<p><%=  %></p>
					</div>
				</div>
  			</div>


  			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="employee_name">Employee Name:</label>
				</div>
				<div class="col-md-9">
					<div class="form-group">

					</div>
				</div>
  			</div>
  			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="department_code">Department Code:</label>
				</div>
				<div class="col-md-9">

				</div>
  			</div>
  			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="position_code">Position Code:</label>
				</div>
				<div class="col-md-9">

				</div>
  			</div>

  			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="telephone">Telephone:</label>
				</div>
				<div class="col-md-9">
					<div class="form-group">

					</div>
				</div>
  			</div>
			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="address">Address:</label>
				</div>
				<div class="col-md-9">
					<div class="form-group">

					</div>
				</div>
  			</div>
  			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="email">Email:</label>
				</div>
				<div class="col-md-9">
					<div class="form-group">

					</div>
				</div>
  			</div>

					<button type="button" class="btn btn-warning">Clear</button>

				</form>
			</div>
</body>
<%
}
%>