//package filter;
//
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebInitParam;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@WebFilter(urlPatterns = {"/main.do"})
//public class LoginSessionFilter extends HttpFilter implements Filter {
///*
//	private List<String> excludeURLList;
//
//	public void init(FilterConfig fconfig) {
//		String excludeURLString = fconfig.getInitParameter("excludeURL");
//		excludeURLList = Arrays.asList(excludeURLString.split(","));
//	}
//*/
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		HttpServletRequest httpRequest = (HttpServletRequest) request;
//		HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//		String path = httpRequest.getRequestURI();
//
//		HttpSession session = httpRequest.getSession(false);
//
//		if(session == null || session.getAttribute("userId") == null) {
//			httpResponse.sendRedirect("/views/user/login.jsp");
//			return;
//		}
//
//		chain.doFilter(request, response);
//	}
//
//	@Override
//	public void destroy() {
//
//	}
//
//}
