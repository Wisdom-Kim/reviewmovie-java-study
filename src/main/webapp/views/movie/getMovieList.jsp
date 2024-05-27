<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Movie Search</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/liststyle.css">
</head>
<body>
    <%@ include file="/views/layout/header.jsp" %>

    <div class="container">
        <form action="${pageContext.request.contextPath}/movies.do" method="get">
            <input type="text" name="searchTitle" placeholder="Enter movie title" />
            <input type="submit" value="Search" />
        </form>

        <div class="movie-list">
            <c:if test="${not empty requestScope.movieList}">
                <c:forEach items="${requestScope.movieList}" var="movie" step="3">
                    <div class="row">
                        <c:forEach items="${requestScope.movieList}" var="item" begin="${status.index}" end="${status.index + 2}" varStatus="status">
                            <div class="movie-item">
                                <a href="${pageContext.request.contextPath}/review?movieId=${item.movieId}">
                                    <img src="${item.moviePoster}" alt="${item.movieTitle}" class="movie-poster">
                                    <div class="movie-title">${item.movieTitle}</div>
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                </c:forEach>
            </c:if>

            <c:if test="${empty requestScope.movieList}">
                <p>검색어를 입력해주세요</p>
            </c:if>
        </div>
    </div>

    <%@ include file="/views/layout/footer.jsp" %>
</body>
</html>