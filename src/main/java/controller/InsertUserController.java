package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserDTO;
import service.UserService;

@WebServlet("/insertUser.do")
public class InsertUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService userService = UserService.getInstance();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errorUrl = "/views/errors/error.jsp";
		
		String accountId = request.getParameter("accountId");
		String passwd = request.getParameter("passwd");
		String username = request.getParameter("username");
		String birthday = request.getParameter("birthday");
		boolean type = false;	// 일반 회원(관리자X)
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		UserDTO newUser = null;
		boolean insertResult = false;
		
		if(accountId == null || accountId == "" || passwd == null || passwd == ""
				|| username == null || username == "" || birthday == null || birthday == "") {

			response.sendRedirect(errorUrl);
		} else {
			try {	
				Date birthday_to_date = df.parse(birthday);

				newUser = UserDTO.builder()
		                 			.userAccountId(accountId)
		                 			.userPassword(passwd)
		                 			.userName(username)
		                 			.userBirthday(birthday_to_date)
		                 			.userType(type)
		                 			.build();
				
				insertResult = userService.insertUser(newUser);
				
				if(insertResult) {
					response.sendRedirect("/main.do");
					
				} else {
					request.setAttribute("error", "회원가입 실패: 서버 오류");
					request.getRequestDispatcher(errorUrl).forward(request, response);
				}
			} catch (ParseException e) {
				request.setAttribute("error", "회원가입 실패: 생일을 바르게 입력하세요.");
				request.getRequestDispatcher(errorUrl).forward(request, response);
			}
		}
		
	}

}
