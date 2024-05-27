<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Movie Search</title>
    <style type="text/css">
        .movie-list {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 40px;
        }
        .row {
            display: flex;
            justify-content: center;
            margin-bottom: 30px;
        }
        .movie-item {
            width: calc(100% / 3 - 40px);
            margin: 0 20px;
            text-align: center;
        }
        .movie-poster {
            width: 100%;
            height: 300px;
            object-fit: cover;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            margin-bottom: 10px;
        }
        .movie-item h3 {
            font-size: 18px;
            font-weight: bold;
            margin-top: 10px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }
        .movie-item a {
            text-decoration: none;
            color: #333;
        }
        .movie-item a:hover {
            color: #555;
        }
        @media (max-width: 768px) {
            .row {
                flex-direction: column;
                align-items: center;
            }
            .movie-item {
                width: 100%;
                margin-bottom: 30px;
            }
        }
    </style>
</head>
<body>
    <form action="${pageContext.request.contextPath}/movies.do" method="get">
        <input type="text" name="searchTitle" placeholder="Enter movie title" />
        <input type="submit" value="Search" />
    </form>

    <div class="movie-list">
        <c:if test="${not empty movieList}">
            <c:forEach items="${movieList}" var="movie" step="3">
                <div class="row">
                    <c:forEach items="${movieList}" var="item" begin="${status.index}" end="${status.index + 2}" varStatus="status">
                        <div class="movie-item">
                            <a href="${pageContext.request.contextPath}/detailPage.do?movieId=${item.movieId}">
                                <img src="${item.poster}" alt="${item.title}" class="movie-poster">
                                <h3>${item.title}</h3>
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </c:forEach>
        </c:if>

        <c:if test="${empty movieList}">
            <p>검색어를 입력해주세요</p>
        </c:if>
    </div>
</body>
</html>
