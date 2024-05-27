package filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/*"}, initParams = {@WebInitParam(name = "excludedUrls", value = "/movie/search, /movie/details")})
public class LoginSessionFilter extends HttpFilter implements Filter {

    private List<String> excludedUrlList;

    public void init(FilterConfig fconfig) {
        String excludedUrlString = fconfig.getInitParameter("excludedUrls");
        excludedUrlList = Arrays.asList(excludedUrlString.split(","));
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);
        
        String path = httpRequest.getRequestURI();

        if (excludedUrlList.contains(path)) {
            chain.doFilter(request, response);
            return;
        }
        
        if (session == null || session.getAttribute("userId") == null) {
            if (path.startsWith("/review/create") || path.startsWith("/rating/create")) {
                httpResponse.sendRedirect("/views/user/login.jsp");
                return;
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}