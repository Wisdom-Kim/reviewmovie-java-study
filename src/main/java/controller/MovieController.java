package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Movie;
import service.Service;

@WebServlet("/movies")
public class MovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchTitle = request.getParameter("searchTitle");
	    Service movieService = new Service();

	    List<Movie> movieList;
	    if (searchTitle != null && !searchTitle.isEmpty()) {
	        movieList = movieService.searchMoviesByTitle(searchTitle);
	    } else {
	        movieList = movieService.getNothing();
	    }

	    request.setAttribute("movieList", movieList);
	    request.getRequestDispatcher("/views/getMovieList.jsp").forward(request, response);
	    }
}

