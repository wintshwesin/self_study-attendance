<%-- 役員登録画面
@author : WintShweSin
@version: 1.0
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="admin_header.jsp"></jsp:include>
<body>
	<div class="title">
		<h3>役員登録</h3>
	</div>

	<div class="main_form">
		<c:forEach var="error" items="${requestScope.errors}">
			<div class="alert alert-danger center" role="alert">
				<ul>
					<li>${error}</li>
				</ul>
			</div>
		</c:forEach>
		<form action="EmployeeRegister" method="post">
			<div class="alert alert-success center" role="alert">
				<p>${noti}</p>
			</div>

			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="employee_code">Employee Code:</label>
				</div>
				<div class="col-md-9">
					<div class="form-group">
						<input type="text" class="form-control" id="employee_code"
							placeholder="従業員番号" name="employee_code" maxlength="7" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="employee_name">Employee Name:</label>
				</div>
				<div class="col-md-9">
					<div class="form-group">
						<input type="text" class="form-control" id="employee_name"
							placeholder="従業員氏名" name="employee_name" maxlength="30" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="department_code">Department Code:</label>
				</div>
				<div class="col-md-9">
					<div class="combobox-container">
						<select class="combobox input-large form-control"
							name="department_code">
							<option value="D_001">D001</option>
							<option value="D_002">D002</option>
							<option value="D_003">D003</option>
							<option value="D_004">D004</option>
							<option value="D_005">D005</option>
						</select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="position_code">Position Code:</label>
				</div>
				<div class="col-md-9">
					<div class="combobox-container">
						<select class="combobox input-large form-control"
							name="position_code">
							<option value="P_001">P001</option>
							<option value="P_002">P002</option>
							<option value="P_003">P003</option>
							<option value="P_004">P004</option>
							<option value="P_005">P005</option>
						</select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="salary_grade">Salary Grade:</label>
				</div>
				<div class="col-md-9">
					<div class="combobox-container">
						<select class="combobox input-large form-control"
							name="salary_grade_id">
							<option value="S_001">S001</option>
							<option value="S_002">S002</option>
							<option value="S_003">S003</option>
							<option value="S_004">S004</option>
							<option value="S_005">S005</option>
						</select>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="gender">Gender:</label>
				</div>
				<div class="col-md-9">
					<div class="combobox-container">
						<select class="combobox input-large form-control" name="gender">
							<option value="M">Male</option>
							<option value="F">Female</option>
						</select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="telephone">Telephone:</label>
				</div>
				<div class="col-md-9">
					<div class="form-group">
						<input type="text" class="form-control" id="telephone"
							placeholder="電話番号" name="telephone" maxlength="30" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="address">Address:</label>
				</div>
				<div class="col-md-9">
					<div class="form-group">
						<textarea class="from-control" rows="3" cols="70" id="address"
							placeholder="住所" name="address" maxlength="200" required></textarea>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="email">Email:</label>
				</div>
				<div class="col-md-9">
					<div class="form-group">
						<input type="text" class="form-control" id="email"
							placeholder="メール" name="email" maxlength="30" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="password">Password:</label>
				</div>
				<div class="col-md-9">
					<div class="form-group">
						<input type="password" class="form-control" id="password"
							placeholder="パスワード" name="password" maxlength="30" required>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="permission">管理者権限付与:</label>
				</div>
				<div class="col-md-9">
					<div class="combobox-container">
						<select class="combobox input-large form-control"
							name="permission">
							<option value="Yes">Yes</option>
							<option value="No">No</option>
						</select>
					</div>
				</div>
			</div>

			<button type="submit" class="btn btn-primary">Register</button>
			<input type="reset" class="btn btn-warning" />
		</form>
	</div>

</body>