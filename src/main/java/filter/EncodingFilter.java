//package filter;
//
//import javax.servlet.http.HttpFilter; // 이거 지우고 푸쉬 안하면 바보임 //히히 바보다 바보
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebInitParam;
//
//@WebFilter(urlPatterns = {"*.do"},
//			initParams = {@WebInitParam(name = "charset", value = "UTF-8")})
//public class EncodingFilter extends HttpFilter implements Filter {
//
//	String charset;
//
//	public void init(FilterConfig fConfig) throws ServletException {
//		charset = fConfig.getInitParameter("charset");
//	}
//
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		request.setCharacterEncoding(charset);
//		response.setCharacterEncoding(charset);
//		chain.doFilter(request, response);
//
//	}
//
//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//
//	}
//
//
//}
