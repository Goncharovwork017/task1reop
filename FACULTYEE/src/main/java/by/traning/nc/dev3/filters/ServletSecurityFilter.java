package by.traning.nc.dev3.filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ivan on 12.04.2017.
 */
@WebFilter(urlPatterns = { "/controller" }, servletNames = { "Controller" })
public class ServletSecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        UserType type = (UserType) session.getAttribute("userType");
        if (type == null ) {
            type = UserType.GUEST;
            session.setAttribute("userType", type);
            chain.doFilter(request, response);
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
