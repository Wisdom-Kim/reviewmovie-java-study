package controller;

import domain.Movie;
import dto.MovieDTO;
import dto.RatingDTO;
import service.MovieService;
import service.ReviewService;
import service.LikesService;
import dto.ReviewDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/review")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final ReviewService reviewService = ReviewService.getInstance();
	private final LikesService likesService = LikesService.getInstance();
	private MovieService movieService = MovieService.getInstance();

	@Override
	//?movieId=
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/views/erros/error.jsp";
		int movieId = 0;
		MovieDTO movieDTO = null;
		try {
			movieId = Integer.parseInt(request.getParameter("movieId"));
			movieDTO = movieService.getMovie(movieId);
			//평점을 구해서 set
			double movieRating = movieService.getAverageRating(movieDTO);
			movieDTO.setAverageRating(movieRating);

			request.setAttribute("movie", movieDTO);
			//Entity 대신 DTO를 넣어준다

		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "유효하지 않은 영화 ID입니다");
			request.getRequestDispatcher(url).forward(request, response); //에러 페이지 이동
			return;
		}
		try {
			List<ReviewDTO> reviewList= reviewService.getReviewsByMovieId(movieId);

			request.setAttribute("reviewList", reviewList);
			//영화와 리뷰리스트까지 불러오면 jsp로 이동한다

			url ="/views/reviews/reviewList.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher(url).forward(request, response); //에러 페이지 이동
			throw new ServletException("리뷰를 불러오는 데에 오류가 났습니다", e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//리뷰 작성 시
		//날라오는 것 : ratingScore , reviewContent ,movieId
		String url = "/views/erros/error.jsp";

		int movieId = 0;
		int ratingScore =0;
		String content = "";

		try {
			content = request.getParameter("content");
			movieId = Integer.parseInt(request.getParameter("movieId"));
			ratingScore = Integer.parseInt(request.getParameter("ratingScore"));

			//레이팅을 먼저 만들고 리뷰에 넣어줄 것
			RatingDTO ratingDTO = RatingDTO.builder()
					.ratingScore(ratingScore)
					.build();

			ReviewDTO reviewDTO = ReviewDTO.builder()
					.reviewContent(content)
					.movieId(movieId)
					.ratingScore(ratingScore)
					.build();
					//TODO: userID도 세션을 통해 가져올 것

			reviewService.insertReview(reviewDTO,ratingDTO);
//			request.setAttribute("movie", movie);
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "유효하지 않은 영화 ID입니다");
			request.getRequestDispatcher(url).forward(request, response); //에러 페이지 이동
			return;
		}
		try {
			List<ReviewDTO> reviewList= reviewService.getReviewsByMovieId(movieId);

			request.setAttribute("reviewList", reviewList);
			//영화와 리뷰리스트까지 불러오면 jsp로 이동한다

			url ="/views/reviews/reviewList.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher(url).forward(request, response); //에러 페이지 이동
			throw new ServletException("리뷰를 불러오는 데에 오류가 났습니다", e);
		}


	}
}