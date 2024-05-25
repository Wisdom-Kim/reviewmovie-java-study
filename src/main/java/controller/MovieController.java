package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Movie;
import service.MovieService;

@WebServlet("/movies.do")
public class MovieController extends HttpServlet {
<<<<<<< Updated upstream
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/views/errors/error.jsp";
		
		String searchTitle = request.getParameter("searchTitle");
	    MovieService movieService = new MovieService();

	    try {
		    List<Movie> movieList;
		    if (searchTitle != null && !searchTitle.isEmpty()) {
		        movieList = movieService.searchMoviesByTitle(searchTitle);
		    } else {
		        movieList = movieService.getNothing();
		    }
	
		    request.setAttribute("movieList", movieList);
		    request.getRequestDispatcher("/views/getMovieList.jsp").forward(request, response);
		    
		} catch (Exception e) {
			request.setAttribute("error", "Fail to search!");
			request.getRequestDispatcher(url).forward(request, response);
		}
	    
	}
}
=======
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/views/errors/error.jsp";
        String searchTitle = request.getParameter("searchTitle");
        MovieService movieService = null;

        try {
            List<Movie> movieList;
            movieService = new MovieService();
>>>>>>> Stashed changes

            if (searchTitle != null && !searchTitle.isEmpty()) {
                movieList = movieService.searchMoviesByTitle(searchTitle);
            } else {
                request.setAttribute("error", "영화 제목을 입력해주세요.");
                request.getRequestDispatcher("/views/getMovieList.jsp").forward(request, response);
                return;
            }

            request.setAttribute("movieList", movieList);
            request.getRequestDispatcher("/views/getMovieList.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Fail to search!");
            request.getRequestDispatcher(url).forward(request, response);
        } finally {
            if (movieService != null) {
                movieService.close();
            }
        }
    }
}