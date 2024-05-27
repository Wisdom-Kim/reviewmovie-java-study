<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>영화 리뷰 서비스</title>
<link rel="stylesheet" href="/static/css/layout.css" />
</head>
<body>
<%@ include file="/views/layout/header.jsp" %>

<div id="main_container">
	<h1>무슨 영화 볼까?</h1>
	<div>
		<form action="/movies.do" method="GET">
	       	<input type="search" name="searchTitle" maxlength="100" placeholder="영화 제목을 입력해보세요.">
			<input type="submit" id="btnSearch" value="">
		</form>
	</div>
	<div>
		<input type="button" id="btnList" value="평점 좋은 영화 보러가기" onclick="location.href='/movies/rating.do'">
	</div>
</div>
<div class="wrapper py-4" style="width:70vw;">
	<div class="topWrapper">
		<h3 class="form-label py-3">이 영화, 어떠셨나요?</h3>
		<span class="py-2 d-flex rating" style="justify-content: center;">
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
            <form id="myForm" action="/review" method="post">
                <input type="hidden" value="${requestScope.movie.movieId}" name="movieId">
                <input type="hidden" value="${sessionScope.userId}" name="userId">
                <textarea name="reviewContent" cols="50" class="form-control" rows="1" placeholder="이 영화에 대한 한줄평을 남겨주세요!"></textarea>
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
						<div class="btn">
							<label style="cursor: pointer" onclick="like()">
								<img class="icon" id="like" src="../../resources/img/red_heart.png" alt="heart" />
								<span>${fn:length(review.likesList)}</span>
							</label>
						</div>
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
</script>

</html>
