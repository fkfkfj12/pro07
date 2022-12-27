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
<title>회원목록 상세보기</title>
</head>
<body>
<H1> 회원목록 상세보기</H1>

<ul>
	<li>
		<span>${user.id }</span>
	</li>
	<li>
		<span>${user.pw }</span>
	</li>
	<li>
		<span>${user.name }</span>
	</li>
	
</ul>
</body>
</html>