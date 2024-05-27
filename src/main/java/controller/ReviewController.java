package controller;

import domain.Movie;
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

@WebServlet("/getReviewPage.do")
public class ReviewController extends HttpServlet {

	private ReviewService reviewService = new ReviewService();
	private LikesService likesService = new LikesService();
	private MovieService movieService = new MovieService();

	@Override
	//?movieId=
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/views/erros/error.jsp";
		int movieId = 0;
		Movie movie = null;
		try {
			movieId = Integer.parseInt(request.getParameter("movieId"));
			movie = movieService.getMovie(movieId).toEntity();
			request.setAttribute("movie", movie);
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
	}
}
