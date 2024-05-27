package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserDTO;
import jakarta.persistence.NoResultException;
import service.UserService;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserService userService = UserService.getInstance();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errorUrl = "views/errors/error.jsp";
		
		String accountId = request.getParameter("accountId");
		String passwd = request.getParameter("passwd");
		
		UserDTO user = null;
		HttpSession session = null;
		
		if(accountId == null || accountId == "" || passwd == null || passwd == "") {
			response.sendRedirect(errorUrl);
		} else {
			try {
				user = userService.getUser(accountId, passwd);
				
				if(user != null) {
					session = request.getSession();
					session.setAttribute("userId", user.getUserId());
					session.setAttribute("userName", user.getUserName());
					
					response.sendRedirect("/main.do");
				} else {
					request.setAttribute("error", "로그인 실패: 회원 정보가 없습니다.");
					request.getRequestDispatcher(errorUrl).forward(request, response);
				}
			} catch (NoResultException e) {
				request.setAttribute("error", "로그인 실패: 회원 정보가 없습니다.");
				request.getRequestDispatcher(errorUrl).forward(request, response);
			} catch (NullPointerException e) {
				request.setAttribute("error", "로그인 실패: 회원 정보가 없습니다.");
				request.getRequestDispatcher(errorUrl).forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
