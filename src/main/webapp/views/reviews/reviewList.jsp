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
        <img src=${requestScope.movie.moviePoster}, alt="Movie Poster">
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
        <span class="py-2 d-flex rating" style="justify-content: center;">
                <!-- 별점 등록 부분 -->
                <c:forEach var="i" begin="1" end="5">
                    <div class="form-check d-flex mx-3">

                        <input class="form-check-input" type="radio" name="ratingScore" id="flexRadioDefault${i}" value="${i}">
                        <label class="form-check-label" for="flexRadioDefault${i}">
                            ${i} 점
                        </label>
                    </div>
                </c:forEach>
            </span>
        <span>
                <!-- 리뷰 등록 부분 -->
                <form id="myForm" action="/review" method="post">
                    <input value="${requestScope.movie.movieId}" name="movieId" style="display: none"></input>
<%--                    영화 id를 함께 보내기 위한 hidden처리--%>
                    <textarea name="reviewContent" cols="50" class="form-control" rows="3" placeholder="이 영화에 대한 리뷰를 남겨주세요!"></textarea>
                    <button type="submit" class="btn btn-primary my-4">리뷰 등록</button>
                </form>
            </span>
    </div>
<%--    <c:if test="${not empty requestScope.reviewList}">--%>
<%--        <div class="review-list d-flex">--%>
<%--            <c:forEach items="${requestScope.reviewList}" var="review">--%>
<%--                <div class="card" style="width: 18rem;">--%>
<%--                    <div class="card-body">--%>
<%--                        <p class="card-title">${review.reviewContent}</p>--%>
<%--                        <div class="btn">--%>
<%--                                &lt;%&ndash; TODO: 좋아요 버튼 누르면 하트 변경 &ndash;%&gt;--%>
<%--                            <label style="cursor: pointer" onclick="like()">--%>
<%--                                <img class="icon" id="like" src="../../resources/img/red_heart.png" alt="heart" />--%>
<%--                                <span>${fn:length(review.likesList)}</span>--%>
<%--                            </label>--%>
<%--                            <span>128</span>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </c:forEach>--%>
<%--        </div>--%>
<%--    </c:if>--%>
<%--    <c:if test="${empty requestScope.reviewList}">--%>
        <div>
            영화에 등록된 리뷰가 없어요!
        </div>
<%--    </c:if>--%>
    <!-- 여기에 다른 카드들도 추가 -->
</div>
</div>
</body>


<script type="text/javascript">

    async function like(){

        let heart = document.getElementById("like") //좋아요 상태
        // let reviewId = reviewId;
        const url = "/like?reviewId?="+reviewId;

        await fetch(url)
            .then(response => response.json()) // 응답을 JSON으로 파싱
            .then(data => {
                //좋아요 취소 시 JSON에 {isLike:false}
                //좋아요 시 JSON에 {isLike:true}
                console.log(data);
                if(data.result.isLike){
                    heart.src="../../resources/img/heart.png"
                }else{
                    heart.src="../../resources/img/read_heart.png"
                }

            });
    }
</script>



</html>
