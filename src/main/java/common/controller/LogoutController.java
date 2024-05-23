package common.controller; 

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout.do")
public class LogoutController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/views/errors/error.jsp";
		
		HttpSession session = request.getSession(false);
		
		if(session == null) {
			url = "login.jsp";
			response.sendRedirect(url);
			return;
		}
		
		session.invalidate();
		session = null;
		url = "main.do";
		response.sendRedirect(url);
		return;
	}
}









