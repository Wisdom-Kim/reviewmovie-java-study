package controller;  

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main.do")
public class MainController extends HttpServlet {
	//현재는 전부 메인페이지로만 리다이렉트
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		String url ="/views/main.jsp";
		
		if(session != null) {
			url = "/views/main.jsp";
			response.sendRedirect(url);
			return;
		}
		
		response.sendRedirect(url);
	}
}
