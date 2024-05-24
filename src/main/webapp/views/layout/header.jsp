<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<header>
	<div align="right">
		<c:if test="${empty sessionScope.userId}">
			<span><input type="button" value="로그인" onclick="location.href='/views/user/login.jsp'"></span>
			<span><input type="button" value="회원가입" onclick="location.href='/views/user/insertUser.jsp'"></span>
	  	</c:if>
  		<c:if test="${not empty sessionScope.userId}">
  			<span>${sessionScope.userName} 님</span>
	  		<span><input type="button" value="로그아웃" onclick="location.href='/logout.do'"></span>
		</c:if>
	</div>
</header>
