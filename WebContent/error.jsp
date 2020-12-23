<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<jsp:include page="header.jsp"></jsp:include>
<body>
	<div>
		<h1>Error</h1>
		<h2><%=exception.getMessage() %><br/> </h2>
	</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>