<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie Detail</title>
<link href="/static/css/layout.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%@ include file="/views/layout/header.jsp" %>

<div id="container">
	 <h2>영화 검색 결과</h2>

    <c:if test="${not empty movieList}">
        <div class="movie-list">
            <c:forEach var="movie" items="${movieList}">
                <div class="movie-item">
                    <img src="${movie.poster}" alt="${movie.title}" class="movie-poster">
                    <h3>${movie.title}</h3>
                </div>
            </c:forEach>
        </div>
    </c:if>

    <c:if test="${empty movieList}">
        <p>검색 결과가 없습니다.</p>
    </c:if>

	<form action="${pageContext.request.contextPath}/getMovie.do" method="get">
        <input type="text" name="searchTitle" placeholder="영화 제목 입력" />
        <input type="submit" value="검색" />
    </form>
    
<%@ include file="/views/layout/footer.jsp" %>

</div>
</body>
</html>