<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<header>
	<div align="right">
		<c:if test="${empty sessionScope.userId}">
			<span style="font-size:12pt;"><input type="button" value="로그인" onclick="location.href='/login.jsp'"></span>
			<span style="font-size:12pt;"><input type="button" value="회원가입" onclick="location.href='/insertUser.jsp'"></span>
	  	</c:if>
  		<c:if test="${not empty sessionScope.userId}">
  			<span> ${sessionScope.userName} 님 </span>
	  		<span style="font-size:12pt;"><input type="button" value="로그아웃" onclick="location.href='/logout.do'"></span>
		</c:if>
	</div>
</header>
