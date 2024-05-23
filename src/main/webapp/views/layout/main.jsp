<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 리뷰 서비스</title>
<style type="text/css">
	body {
		min-height: "100vh";
		display: grid;
		justify-items: center;
		align-content: center;
		background-color: orange;
	}
	input[type="search"] {
		width: 500px;
		height: 50px;
	}
</style>
</head>
<body>
<%-- <%@ include file="../layout/header.jsp" %> --%>

<div id="container">
	<div>
		<form action="/getMoviesByTitle.do" method="GET">
	       	<input type="search" name="q" maxlength="100" placeholder="영화 제목을 입력하세요.">
			<input type="submit" value="검색">
		</form>
	</div>
	<div>
		<input type="button" value="평점 좋은 영화 보러가기" onclick="location.href='/getMovies***.do'">
	</div>
</div>

</body>
</html>