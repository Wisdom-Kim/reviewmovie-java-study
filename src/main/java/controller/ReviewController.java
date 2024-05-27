package controller;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/views/errors/error.jsp";
		int movieId = 0;
		MovieDTO movieDTO = null;
		try {
			movieId = Integer.parseInt(request.getParameter("movieId"));
			movieDTO = movieService.getMovie(movieId);
			double movieRating = movieService.getAverageRating(movieDTO);
			movieDTO.setAverageRating(movieRating);
			request.setAttribute("movie", movieDTO);
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "유효하지 않은 영화 ID입니다");
			request.getRequestDispatcher(url).forward(request, response);
			return;
		}
		try {
			List<ReviewDTO> reviewList = reviewService.getReviewsByMovieId(movieId);
			request.setAttribute("reviewList", reviewList);
			url = "/views/reviews/reviewList.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher(url).forward(request, response);
			throw new ServletException("리뷰를 불러오는 데에 오류가 났습니다", e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/views/errors/error.jsp";

		int movieId = 0;
		int ratingScore = 0;
		String content = "";
		int userId = 0;

		try {
			content = request.getParameter("reviewContent");
			movieId = Integer.parseInt(request.getParameter("movieId"));
			ratingScore = Integer.parseInt(request.getParameter("ratingScore"));
			userId = Integer.parseInt(request.getParameter("userId"));

			System.out.println(" " + ratingScore + " " + userId);

			RatingDTO ratingDTO = RatingDTO.builder()
					.ratingScore(ratingScore)
					.build();

			ReviewDTO reviewDTO = ReviewDTO.builder()
					.reviewContent(content)
					.movieId(movieId)
					.userId(userId)
					.ratingScore(ratingScore)
					.build();

			reviewService.insertReview(reviewDTO, ratingDTO);

			url = "/review?movieId=" + movieId;
			response.sendRedirect(url);
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "유효하지 않은 영화 ID입니다");
		} catch (Exception e) {
			request.setAttribute("errorMessage", e.getMessage());
			e.printStackTrace();
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
}