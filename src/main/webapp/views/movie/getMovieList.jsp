<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Movie Search</title>
    <link rel="stylesheet" href="/static/css/layout.css" />
    <style>
        .movie-item {
            display: inline-block;
            margin-right: 20px;
            margin-bottom: 20px;
            text-align: center;
        }

        .movie-poster {
            width: 200px;
            height: 300px;
            object-fit: cover;
        }

        .movie-title {
            margin-top: 10px;
            font-weight: bold;
        }

        .search-container {
            display: flex;
            justify-content: center;
            margin-bottom: 20px;
        }

        .search-container form {
            display: flex;
            align-items: center;
        }

        .search-container input[type="text"] {
            width: 500px;
  	    height: 40px;
  	    padding: 10px 20px;
  	    border: none;
	    border-radius: 25px 0 0 25px;
  	    outline: none;
  	    font-size: 18px;
  	    color: #333;
        }

        .search-container input[type="submit"] {
            height: 60px;
  	    padding: 10px 30px;
  	    background-color: #1B1A55;
  	    color: #fff;
  	    border: none;
  	    border-radius: 0 25px 25px 0;
  	    cursor: pointer;
  	    font-size: 18px;
      	    background-image: url('../../resources/img/search.png');
  	    background-size: 24px;
  	    background-repeat: no-repeat;
  	    background-position: center;
        }
        .movie-list {
 	    display: flex;
  	    justify-content: center;
  	    flex-wrap: wrap;
	}

	.row {
  	    display: flex;
  	    justify-content: center;
  	    flex-wrap: wrap; 
	}
    </style>
</head>
<body>
    <%@ include file="/views/layout/header.jsp" %>
    <div class="container">
        <div class="search-container">
            <form action="${pageContext.request.contextPath}/movies.do" method="get">
                <input type="text" name="searchTitle" placeholder="검색어를 입력하세요" value="${param.searchTitle}" />
                <input type="submit" value="" />
            </form>
        </div>
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
