<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<!--엔티티매니저를 서비스계층에 만들어서 넘겨줘서 트랜잭션 작동하기-->
  <link href="https://getbootstrap.kr/docs/5.2/examples/sign-in/signin.css" rel="stylesheet">
</head>
<body>
    <div class="wrapper" style="width:70vw;">
        <div class="topWrapper">
            <h3 class="form-label py-3">이 영화, 어떠셨나요?</h3>
            <span class="py-2" style="flex-direction:row">
            <!-- 리뷰 등록 부분 -->
	            <form id="myForm" action="/insertReview.do" method="post">
	                <textarea  cols="50" class="form-control"column="3" placeholder="이 영화에 대한 리뷰를 남겨주세요!"></textarea>
	                <button type="submit" form="myForm" class="btn btn-primary my-4" name="review_content">리뷰 등록</button>
	            </form>
            </span>
        </div>

        <div class="feed grid text-center justify-content-center d-flex">
            <div class="g-col-6 g-col-md-4 ">
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                      <p class="card-title">영화 개별로임</p>
                      <div class="btn">
                        <label style="cursor: pointer" onclick="like()"><img class="icon" src="../../resources/img/red_heart.png" alt="heart" /> <span>좋아요</span></label>
                        <span>128</span>
                      </div>
                     
                    </div>
                </div>
            </div>
            <div class="g-col-6 g-col-md-4">
                <div class="card " style="width: 18rem;">
                    <div class="card-body">
                      <p class="card-title">영화 개별로임</p>
                      <div class="btn">
                        <label style="cursor: pointer" onclick="like()"><img class="icon" src="../../resources/img/red_heart.png" alt="heart" /> <span>좋아요</span></label>
                        <span>128</span>
                      </div>
                     
                    </div>
                </div>
            </div>
            <div class="g-col-6 g-col-md-4">
                <div class="card " style="width: 18rem;">
                    <div class="card-body">
                      <p class="card-title">영화 개별로임</p>
                      <div class="btn">
                        <label style="cursor: pointer" onclick="like()"><img class="icon" src="../../resources/img/red_heart.png" alt="heart" /> <span>좋아요</span></label>
                        <span>128</span>
                      </div>
                     
                    </div>
                </div>
            </div>
            
          </div>

        <!-- <div class="feed" style="flex-direction:row;">
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                  <h5 class="card-title">Card title</h5>
                  <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                  <a href="#" class="btn btn-primary">Go somewhere</a>
                </div>
            </div>
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                  <h5 class="card-title">Card title</h5>
                  <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                  <a href="#" class="btn btn-primary">Go somewhere</a>
                </div>
            </div>
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                  <h5 class="card-title">Card title</h5>
                  <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                  <a href="#" class="btn btn-primary">Go somewhere</a>
                </div>
            </div>-->
            <!-- TODO: jsp에서 반복문으로 만들기 -->
        </div>
        <!-- TODO: EL태그 붙일것 -->
    </div>

</body>
</html>