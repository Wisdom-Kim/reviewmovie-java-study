<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Movies by Rating</title>
</head>
<body>
    <h1>Movies by Rating</h1>
    <table>
        <tr>
            <th>Poster</th>
            <th>Title</th>
            <th>Rating</th>
        </tr>
        <c:forEach items="${moviesByRating}" var="movie">
            <tr>
                <td><img src="${movie.moviePoster}" alt="${movie.movieTitle}"></td>
                <td>${movie.movieTitle}</td>
                <td>${movie.averageRating}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>