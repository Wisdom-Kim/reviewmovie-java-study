<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Movies by Rating</title>
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
            width: 200px;
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
        .movie-item p {
            font-size: 16px;
            margin-top: 5px;
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
    <h1>Movies by Rating</h1>
    <div class="movie-list">
        <c:forEach items="${requestScope.moviesByRating}" var="movie" step="3">
            <div class="row">
                <c:forEach items="${requestScope.moviesByRating}" var="item" begin="${status.index}" end="${status.index + 2}" varStatus="status">
                    <div class="movie-item">
                        <a href="${pageContext.request.contextPath}/detailPage.do?movieId=${item.movieId}">
                            <img src="${item.moviePoster}" alt="${item.movieTitle}" class="movie-poster">
                            <h3>${item.movieTitle}</h3>
                        </a>
                        <p>Average Rating: ${item.averageRating}</p>
                    </div>
                </c:forEach>
            </div>
        </c:forEach>
    </div>
</body>
</html>
