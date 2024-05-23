<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
	<div align="center">
		<h2>죄송합니다. 문제가 발생하였습니다.</h2>
	</div>
	
	<br><hr><br>
	
	<div align="center">
		<h3>${requestScope.error}</h3>
	</div>
	 
	<br>
	
	<div align=center>
		<span style="font-size:9pt;">&lt;<a href="">메인으로</a>&gt;</span>
	</div>
</body>
</html>