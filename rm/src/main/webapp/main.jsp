<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 리뷰 서비스</title>
<style type="text/css">
#container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  background-color: #f8f8f8;
  color: #333;
}

h1 {
  margin-bottom: 40px;
  font-size: 36px;
  font-weight: 300;
  letter-spacing: 2px;
}

form {
  display: flex;
  align-items: center;
  padding: 5px;
  border-radius: 30px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

input[type="search"] {
  width: 500px;
  height: 50px;
  padding: 10px 20px;
  border: none;
  border-radius: 25px 0 0 25px;
  outline: none;
  font-size: 18px;
  color: #333;
}

input[type="submit"] {
  height: 50px;
  padding: 10px 30px;
  background-color: #333;
  color: #fff;
  border: none;
  border-radius: 0 25px 25px 0;
  cursor: pointer;
  font-size: 18px;
  background-image: url('https://cdn2.iconfinder.com/data/icons/font-awesome/1792/search-512.png');
  background-size: 24px;
  background-repeat: no-repeat;
  background-position: center;
}

input[type="button"] {
  margin-top: 40px;
  padding: 15px 30px;
  background-color: #333;
  color: #fff;
  border: none;
  border-radius: 30px;
  cursor: pointer;
  font-size: 18px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  transition: background-color 0.3s ease;
}

input[type="button"]:hover {
  background-color: #555;
}
</style>

</head>
<body>
<%@ include file="/views/layout/header.jsp" %>

<div id="container">
	<h1>무슨 영화 볼까?</h1>
	<div>
		<form action="/movies.do" method="GET">
	       	<input type="search" name="q" maxlength="100" placeholder="영화 제목을 입력해보세요.">
			<input type="submit" value="">
		</form>
	</div>
	<div>
		<input type="button" value="평점 좋은 영화 보러가기" onclick="location.href='/movie/rating.do'">
	</div>
</div>

<%@ include file="/views/layout/footer.jsp" %>
</body>
</html>