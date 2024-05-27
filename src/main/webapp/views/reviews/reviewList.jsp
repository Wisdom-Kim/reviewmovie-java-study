<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="generator" content="Hugo 0.104.2">
    <link rel="stylesheet" href="/static/css/star.css"/>
    <link rel="canonical" href="https://getbootstrap.kr/docs/5.2/examples/sign-in/">
    <link href="https://getbootstrap.kr/docs/5.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <style>

        body{
            margin: auto 0;
            display:flex;
            flex-direction: column;
            text-align: center;
            height: 100vh;
        }
        .movie-poster img{
            width: 200px;
            height:300px;
            background-color:black;
        }
        .topWrapper{
            flex-direction: column;
        }
        .feed{
            text-align: left !important;
        }
        .feed_input{
            border: none;
            box-sizing: border-box;
            width: 100%;
            overflow: hidden;
            font-size: 20px;
        }
        .icon{
            height: 30px;
            width: 30px;
        }
        .form-control{
            height:20vh !important;
        }
    </style>
    <link href="https://getbootstrap.kr/docs/5.2/examples/sign-in/signin.css" rel="stylesheet">
</head>
<body>
<div class="movie-info d-flex py-3">
    <div class="movie-poster px-4">
        <img src="${requestScope.movie.moviePoster}" alt="Movie Poster">
    </div>
    <div class="movie-detail" style="text-align: left;">
        <h1>${requestScope.movie.movieTitle} </h1>
        <div class="py-5"></div>
        <h4>평점: ${requestScope.movie.averageRating}</h4>
        <h4>감독: ${requestScope.movie.movieDirector}</h4>
        <h4>상영 연도: ${requestScope.movie.movieReleaseDate}</h4>
    </div>
</div>
<div class="wrapper py-4" style="width:70vw;">
    <div class="topWrapper">
        <h3 class="form-label py-3">이 영화, 어떠셨나요?</h3>
        <h4>별점을 선택해주세요.</h4>
            <form id="myform" action="/review.do" method="POST" onsubmit="return checkData()">

                <fieldset>
                    <input type="radio" name="ratingScore" value="5" id="rate1"><label
                        for="rate1">★</label>
                    <input type="radio" name="ratingScore" value="4" id="rate2"><label
                        for="rate2">★</label>
                    <input type="radio" name="ratingScore" value="3" id="rate3"><label
                        for="rate3">★</label>
                    <input type="radio" name="ratingScore" value="2" id="rate4"><label
                        for="rate4">★</label>
                    <input type="radio" name="ratingScore" value="1" id="rate5"><label
                        for="rate5">★</label>
                </fieldset>

                <input type="hidden" value="${requestScope.movie.movieId}" name="movieId">
                <input type="hidden" value="${sessionScope.userId}" name="userId">
                <textarea name="content" cols="50" class="form-control" rows="1" placeholder="이 영화에 대한 한줄평을 남겨주세요!"></textarea>
                <button type="submit" class="btn btn-primary my-4">리뷰 등록</button>
            </form>
        </span>
    </div>
    <c:if test="${not empty requestScope.reviewList}">
        <div class="review-list d-flex">
            <c:forEach items="${requestScope.reviewList}" var="review">
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <p class="card-title">${review.reviewContent}</p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
    <c:if test="${empty requestScope.reviewList}">
        <div>
            영화에 등록된 리뷰가 없어요!
        </div>
    </c:if>
</div>
</div>
</body>

<script type="text/javascript">
    async function like(){
        let heart = document.getElementById("like") //좋아요 상태
        const url = "/like?reviewId="+reviewId;

        await fetch(url)
            .then(response => response.json()) // 응답을 JSON으로 파싱
            .then(data => {
                console.log(data);
                if(data.result.isLike){
                    heart.src="../../resources/img/heart.png"
                }else{
                    heart.src="../../resources/img/red_heart.png"
                }
            });
    }

    function checkData() {
        let insertForm = document.getElementById('myForm');

        // 선택된 라디오 버튼을 찾음
        let ratingScore = document.querySelector('input[name="ratingScore"]:checked');
        if (!ratingScore) {
            alert("별점을 선택해주세요.");
            return false;
        }

        // 리뷰 내용을 확인
        if (insertForm.reviewContent.value.trim() === "") {
            alert("리뷰 내용을 입력해주세요.");
            return false;
        }

        // 폼 제출 허용
        return true;
    }
</script>

</html>
