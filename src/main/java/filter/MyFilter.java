package filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/PersonalHomepage.jsp"},
initParams = {
        @WebInitParam(name="loginPage",value = "Recommend"),
        @WebInitParam(name="loginServlet" ,value = "applicationLoginServlet"),
        @WebInitParam(name="index" , value = "index.jsp")
}
)
public class MyFilter implements Filter {

    private FilterConfig filterConfig;
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig=filterConfig;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String loginPage= filterConfig.getInitParameter("loginPage");
        String loginServlet = filterConfig.getInitParameter("loginServlet");
        HttpSession httpSession=((HttpServletRequest) servletRequest).getSession();
        String requestPath=((HttpServletRequest) servletRequest).getContextPath();
        if(httpSession.getAttribute("SESSION_APPLICANT")!=null  ||requestPath.endsWith(loginPage)||requestPath.endsWith(loginServlet)
        ||requestPath.endsWith("index.jsp")||requestPath.endsWith("Head.jsp")||requestPath.endsWith("Recommend")){
          filterChain.doFilter(servletRequest,servletResponse);
        }else{
            servletRequest.getRequestDispatcher(loginPage).forward(servletRequest,servletResponse);
        }


    }

    public void destroy() {

    }
}
