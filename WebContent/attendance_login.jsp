<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="common/css/style.css">
<body>
	<h1>社員用ログイン画面</h1>
	<div class="main_wrapper">
		<form action="AttendanceLoginChk" method="post">
			<div class="regist_table">
				<table>
					<tr>
						<td>社員番号</td>
						<td>：</td>
						<td><input type="text" name="employeeCode"></td>
					</tr>
					<tr>
						<td>パスワード</td>
						<td>：</td>
						<td><input type="password" name="password"></td>
					</tr>
				</table>
			</div>
			<div class="admin_user_button">
				<input type="submit" class="login_button" value="ログイン">
				<input type="reset" class="clear_button">
			</div>
		</form>

	</div>
</body>