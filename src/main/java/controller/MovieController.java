package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MovieDTO;
import service.MovieService;

@WebServlet({"/movie.do", "/movies/rating.do"})
public class MovieController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private MovieService movieService;

    @Override
    public void init() {
        movieService = new MovieService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        if (requestURI.equals("/movie")) {
            handleMovieSearch(request, response);
        } else if (requestURI.equals("/movies/rating")) {
        	searchMoviesByRating(request, response);
        }
    }

    private void handleMovieSearch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchTitle = request.getParameter("searchTitle");
        List<MovieDTO> movieList;

        try {
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
            request.setAttribute("error", "영화 검색 중 오류가 발생했습니다.");
            request.getRequestDispatcher("/views/errors/error.jsp").forward(request, response);
        }
    }

    private void searchMoviesByRating(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<MovieDTO> moviesByRating = movieService.getMoviesByRatingDesc();
        request.setAttribute("moviesByRating", moviesByRating);
        request.getRequestDispatcher("/views/moviesByRating.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        movieService.close();
    }
}