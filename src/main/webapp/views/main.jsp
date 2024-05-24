<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 리뷰 서비스</title>
<style type="text/css">
/* 전체 컨테이너 스타일 */
	#container {
		max-width: 800px;
		margin: 0 auto;
		padding: 20px;
		text-align: center;
		font-family: 'Google Sans', Arial, sans-serif;
	}

	/* 제목 스타일 */
	h1 {
		font-size: 80px;
	 	font-weight: bold;
		color: black;
		margin-bottom: 30px;
	}

/* 폼 스타일 */
form {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 20px;
}

	input[type="search"] {
		padding: 10px;
		border: 1px solid #ddd;
		border-radius: 4px 0 0 4px;
		font-size: 16px;
		width: 500px;
	}

input[type="submit"] {
  padding: 10px 20px;
  background-color: #FEB941;
  color: #fff;
  border: none;
  border-radius: 0 4px 4px 0;
  font-size: 16px;
  font-weight: bold;
  cursor: pointer;
}

/* 버튼 스타일 */
	input[type="button"] {
	  padding: 10px 20px;
	  background-color: #f1f1f1;
	  color: #333;
	  border: none;
	  border-radius: 4px;
	  font-size: 16px;
	  cursor: pointer;
	  transition: background-color 0.3s ease;
	}

	input[type="button"]:hover {
		background-color: #e0e0e0;
	}
</style>
</head>
<body>
<%@ include file="/views/layout/header.jsp" %>

<div id="container">
	<h1>무슨 영화 볼까?</h1>
	<div>
		<form action="/getMoviesByTitle.do" method="GET">
	       	<input type="search" name="q" maxlength="100" placeholder="영화 제목을 입력해보세요.">
			<input type="submit" value="검색">
		</form>
	</div>
	<div>
		<input type="button" value="평점 좋은 영화 보러가기" onclick="location.href='/getHighRatedMovies.do'">
	</div>
</div>

<%@ include file="/views/layout/footer.jsp" %>
</body>
</html>