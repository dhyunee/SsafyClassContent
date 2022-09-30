<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, dto.UserDto"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<%
		UserDto userdto= (UserDto)request.getAttribute("userdto");
	%>
	<h4>사용자 목록</h4>
	<h4><%=userdto.getUserName() %>등록 완료</h4>

</body>
</html>