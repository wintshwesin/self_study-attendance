<%-- ログアウト画面
@author : WintShweSin
@version: 1.0
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="common/css/style.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"></jsp:include>
<body>
	<h3>ログアウト</h3>
	<div class="main_area">
		<div class="alert alert-danger center" role="alert">
			<p>ログアウト完了しました!</p><br/>
			<p>本日もお疲れ様でした!</p>
		</div>

		<div class="logout_button">
			<input type="button" class="btn btn-success btn-lg" value="ログイン画面に戻る"
				onclick="location.href='index.jsp';">
		</div>
	</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>