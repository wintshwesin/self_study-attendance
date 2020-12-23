<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="admin_header.jsp"></jsp:include>
<body>
	<h3>Welcome From Attendacne Management System!</h3>
	<div class="main_form">
		<!-- <form action="EmployeeRegister" method="get"></form> -->
		<div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Employee Code</th>
						<th>Employee Name</th>
						<th>Address</th>
						<th>Telephone</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="emp" items="${listemployees}">
						<tr>
							<td><c:out value="${emp.employee_code}" /></td>
							<td><c:out value="${emp.employee_name}" /></td>
							<td><c:out value="${emp.address}" /></td>
							<td><c:out value="${emp.telephone}" /></td>
							<td><c:out value="${emp.email}" /></td>
							<td><a
								href="<%=request.getContextPath()%>/edit?id=<c:out value='${emp.employee_code}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<form action="EmployeeRegister" method="get">
									<button type="submit" class="btn btn-danger" disabled="disabled">Delete</button>
									<input type="hidden"
										value="<c:out value="${emp.employee_code}" />" name="emp_code" />
									<%-- <a href="/delete?id=<c:out value='${emp.employee_code}' />">Delete</a> --%>
								</form></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>