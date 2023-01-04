<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path1" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>회원목록</title>
</head>
<body>
<H1> 회원목록</H1>

<ul>
	<c:forEach items="${userList}" var="user" varStatus="status">
	<li>
		<span>${status.count }</span>
		<span><a href="userGet?id=${user.id }">${user.id }</a></span>
		<span>${user.pw }</span>
		<span>${user.name }</span>
	</li>
	</c:forEach>
	
</ul>

</body>
</html>