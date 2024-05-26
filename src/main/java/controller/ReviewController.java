package controller;

import service.ReviewService;
import service.LikesService;
import dto.ReviewDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/getReviewPage.do")
public class ReviewController extends HttpServlet {

	private ReviewService reviewService = new ReviewService();
	private LikesService likesService = new LikesService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reviewIdStr = request.getParameter("reviewId");
		if (reviewIdStr == null || reviewIdStr.isEmpty()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Review ID is required");
			return;
		}

		int reviewId;
		try {
			reviewId = Integer.parseInt(reviewIdStr);
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Review ID");
			return;
		}

		try {
			ReviewDTO review = reviewService.getReview(reviewId);
			long likesCount = likesService.countLikesByReviewId(reviewId);

			request.setAttribute("review", review);
			request.setAttribute("likesCount", likesCount);

			request.getRequestDispatcher("/reviewPage.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException("Error retrieving review", e);
		}
	}
}
