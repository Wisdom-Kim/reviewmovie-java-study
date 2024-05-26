<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Movie Detail Page</title>
    <style>
        .movie-info {
            text-align: center;
            margin-bottom: 20px;
        }
        .review-form {
            margin-bottom: 20px;
        }
        .review {
            border-bottom: 1px solid #ccc;
            padding: 10px 0;
        }
    </style>
</head>
<body>
<div class="movie-info">
    <img src="${movie.moviePoster}" alt="Movie Poster" style="width:200px;height:300px;">
    <h1>${movie.movieTitle}</h1>
    <p>Director: ${movie.movieDirector}</p>
    <p>Release Date: ${movie.movieReleaseDate}</p>
</div>
<div class="review-form">
    <h2>Submit a Review</h2>
    <form action="/getReviewPage.do" method="post">
        <input type="hidden" name="movieId" value="${movie.movieId}">
        <input type="hidden" name="userId" value="1"><!-- Change to actual userId -->
        <label for="ratingScore">Rating:</label>
        <input type="number" id="ratingScore" name="ratingScore" min="1" max="5" required>
        <br><br>
        <label for="reviewContent">Review:</label>
        <textarea id="reviewContent" name="reviewContent" rows="4" cols="50" required></textarea>
        <br><br>
        <button type="submit">Submit</button>
    </form>
</div>
<div class="reviews">
    <h2>Reviews</h2>
    <c:forEach var="review" items="${reviews}">
        <div class="review">
            <p><strong>Rating:</strong> ${review.ratingScore}</p>
            <p>${review.reviewContent}</p>
            <p><small>Reviewed by User ${review.userName} on ${review.reviewDate}</small></p>
        </div>
    </c:forEach>
</div>
</body>
</html>
