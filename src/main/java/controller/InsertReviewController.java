package controller;

import domain.Movie;
import domain.Rating;
import domain.Review;
import domain.User;
import dto.MovieDTO;
import dto.RatingDTO;
import dto.ReviewDTO;
import service.MovieService;
import service.RatingService;
import service.ReviewService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/review.do")
public class InsertReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final ReviewService reviewService = ReviewService.getInstance();
	private final MovieService movieService = MovieService.getInstance();
	private final UserService userService = UserService.getInstance();
	private final RatingService ratingService = RatingService.getInstance();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/views/errors/error.jsp";

		int movieId = 0;
		int ratingScore = 0;
		String content = "";
		int userId = 0;

		try {
			content = request.getParameter("content");
//리뷰먼저 만들고 레이팅을 넣어줘야한다
			movieId = Integer.parseInt(request.getParameter("movieId"));
			ratingScore = Integer.parseInt(request.getParameter("ratingScore"));
			userId = Integer.parseInt(request.getParameter("userId"));

			User user = userService.getUserById(movieId);
			Movie movie = movieService.getMovie(movieId).toEntity();
			Rating rating = RatingDTO.builder().ratingScore(ratingScore).build().toEntity();

			ReviewDTO reviewDTO = ReviewDTO.builder()
					.reviewContent(content)
					.movieId(movieId)
					.build();
			Review review = reviewDTO.toEntity();

			review.setMovie(movie);
			review.setUser(user);
			reviewService.insertReview(ReviewDTO.fromEntity(review));

//
//			// 리뷰 리스트를 다시 가져와서 설정
//			List<ReviewDTO> reviewList = reviewService.getReviewsByMovieId(movieId);
//			request.setAttribute("reviewList", reviewList);
			request.setAttribute("movieId", movieId);

			url = "/review?movieId="+movieId;
			request.getRequestDispatcher(url).forward(request, response);

		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
}
