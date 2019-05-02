package filter;

import model.User;
import org.apache.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter", value = "/addOrUpdate")
public class AdminFilter implements Filter {

    private static final Logger logger = Logger.getLogger(AdminFilter.class);

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        User user = (User) request.getSession().getAttribute("user");
        if (user != null && user.getRole().ordinal() == 0) {
            chain.doFilter(req, resp);
        } else {
            request.getRequestDispatcher("access_denied.jsp").forward(req, resp);
            logger.info("Access denied");
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }
}
