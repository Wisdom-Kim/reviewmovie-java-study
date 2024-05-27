<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Movies by Rating</title>
    <style type="text/css">
        .movie-list {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            margin-top: 40px;
        }
        .movie-item {
            width: calc(100% / 3 - 40px);
            margin: 0 20px 30px;
            text-align: center;
        }
        .movie-poster {
            width: 200px;
            height: 300px;
            object-fit: cover;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            margin-bottom: 10px;
            cursor: pointer;
        }
        .movie-item h3 {
            font-size: 18px;
            font-weight: bold;
            margin-top: 10px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            cursor: pointer;
        }
        .movie-item p {
            font-size: 16px;
            margin-top: 5px;
        }
        @media (max-width: 768px) {
            .movie-item {
                width: 100%;
            }
        }
    </style>
</head>
<body>
    <%@ include file="/views/layout/header.jsp" %>
    <div class="movie-list">
        <c:forEach items="${requestScope.moviesByRating}" var="movie" varStatus="status">
            <div class="movie-item">
                <a href="/review?movieId=${movie.movieId}">
                    <c:if test="${not empty movie.moviePoster}">
                        <img src="${movie.moviePoster}" alt="${movie.movieTitle}" class="movie-poster">
                    </c:if>
                </a>
                <a href="/review?movieId=${movie.movieId}">
                    <h3>${movie.movieTitle}</h3>
                </a>
                <p>Average Rating: ${movie.averageRating}</p>
            </div>
        </c:forEach>
    </div>
    <%@ include file="/views/layout/footer.jsp" %>
</body>
</html>