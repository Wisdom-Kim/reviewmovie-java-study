<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 리뷰 서비스</title>
<link rel="stylesheet" href="/static/css/layout.css" />
</head>
<body>
<%@ include file="/views/layout/header.jsp" %>

<div id="main_container">
	<h1>무슨 영화 볼까?</h1>
	<div>
		<form action="/movies.do" method="GET">
	       	<input type="search" name="searchTitle" maxlength="100" placeholder="영화 제목을 입력해보세요.">
			<input type="submit" id="btnSearch" value="">
		</form>
	</div>
	<div>
		<input type="button" id="btnList" value="평점 좋은 영화 보러가기" onclick="location.href='/movies/rating.do'">
	</div>
</div>

<%@ include file="/views/layout/footer.jsp" %>
</body>
</html>