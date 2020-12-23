<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="user_header.jsp"></jsp:include>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="attendance.model.EmployeeBean"%>

<%@page import="java.time.LocalDateTime"%>
<%
	LocalDateTime now = LocalDateTime.now();
	TimeZone tz = TimeZone.getTimeZone("Asia/Tokyo");
	SimpleDateFormat sdf = new SimpleDateFormat("MMMMM dd, yyyy HH:mm:ss");
%>

<%
	String employee_code = (String) session.getAttribute("employee_code");
	String start_time = (String) session.getAttribute("start_time");
	String end_time = (String) session.getAttribute("end_time");

	if (employee_code == null) {
		response.sendRedirect("index.jsp");
	} else {
		/* response.sendRedirect("time_card.jsp"); */
%>
<body>

	<h3>勤務時間入力</h3>

	<div class="main_area">
		<div>
			<p class="t_show">本日も一日一緒に頑張りましょう！</p>
		</div>
		<div>
			<h3><%=now.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"))%></h3>
		</div>
		<div>
			<h3><%=now.format(DateTimeFormatter.ofPattern("HH:mm:ss"))%></h3>
		</div>

		<form action="AttendanceTimeCard" method="post"
			class="attendance_form">
			<input type="hidden" name="attendance" value="退勤処理">
			<button type="submit" class="btn btn-success btn-lg"
				id="disableend_timeButton" disabled="disabled"
				class="attendance_timecard2" data-toggle="tooltip" title="お疲れ様でした">退勤</button>
		</form>

		<form action="AttendanceTimeCard" method="post"
			class="attendance_form">
		<div class="row">
			<div class="col-md-6 field-label-responsive">
				<button type="submit" class="btn btn-primary btn-lg"
					data-toggle="tooltip" title="おはようございます">出勤</button>
					<input type="hidden" name="attendance" value="出勤処理">
			</div>
		</div>
		</form>


	</div>
</body>
<%
	}
%>

<jsp:include page="footer.jsp"></jsp:include>
