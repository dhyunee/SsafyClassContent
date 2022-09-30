<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="users.CodeDto, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//import ㅠㅣㄹ요
List<CodeDto>codelist=(List<CodeDto>)request.getAttribute("codeList");
%>

<%--codelist 반복 

for( codeDto: codeList){

--%>
<input type="radio" value<%=codeDto.getCode() %>><%=codeDto.getCodeName() %>
</body>
</html>