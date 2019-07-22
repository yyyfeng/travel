<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% pageContext.setAttribute("date", new Date()); %>
	<c:set var="now" value="${date }"/>
	<p><fmt:formatDate type="date" value="${now }"/></p>
	<input type="text"  id="dateTime" value="<fmt:formatDate type="date" value="${now }"/>"  date-time="2016-4-7,2016-4-8,2016-4-17,2016-4-18" readonly>
</body>
</html>