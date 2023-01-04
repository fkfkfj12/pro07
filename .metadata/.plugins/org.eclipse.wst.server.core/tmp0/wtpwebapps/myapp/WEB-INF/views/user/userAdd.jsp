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
	<title>회원가입</title>
	<!-- 헤드 부분 인클루드 -->
   
</head>
<body>
	<header id="header">
		<!-- 헤더 부분 인클루드 -->
	 	
    </header>
	
	<div class="content" id="con">
	    <div class="row column text-center">
	      <h2 class="h1">회원가입</h2>
	      <hr>
	      <div class="container">
	      	<form name="frm1" id="frm1" action="${path1 }/user/userAdd" method="post" onsubmit="return joinCheck(this)">
			      <table id="table1">
			      	<tbody>
			      		<tr>
			      			<th style="background-color:#dcdcdc">아이디</th>
			      			<td>
			      				<input type="text" name="id" id="id" placeholder="아이디 입력" pattern="^[a-z0-9]{5,12}" maxlength="12" required style="width:700px; float:left;">
			      			</td>
			      		</tr>
			      		<tr>
			      			<th style="background-color:#dcdcdc">비밀번호</th>
			      			<td>
			      				<input type="password" name="pw" id="pw" placeholder="비밀번호 입력" maxlength="12" required>
			      				<!-- pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,12}$"  -->
			      			</td>
			      		</tr>
			      		
			      		<tr>
			      			<th style="background-color:#dcdcdc">이름</th>
			      			<td>
			      				<input type="text" name="name" id="name" placeholder="이름 입력" maxlength="40" required>
			      			</td>
			      		</tr>
			      		<tr>
			      			<td colspan="2">
			      				<input type="submit" class="submit success button" value="회원 가입" >
								<input type="reset" class="reset button" value="취소" >
			      			</td>
			      		</tr>
			      	</tbody>
			      </table>
			   </form>   
			   

		      </div>
	    </div>
	</div>
    <footer id="footer" class="footer-nav row expanded collapse">
    	<!-- 푸터 부분 인클루드 -->
    	
    </footer>
</body>
</html>