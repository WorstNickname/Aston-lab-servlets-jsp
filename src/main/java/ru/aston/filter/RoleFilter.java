package ru.aston.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.aston.entity.User;

import java.io.IOException;

import static ru.aston.entity.Role.ADMIN;
import static ru.aston.util.UrlPath.ADMIN_PAGE;
import static ru.aston.util.UrlPath.LOG_IN;

@WebFilter(filterName = "roleFilter", urlPatterns = ADMIN_PAGE)
public class RoleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var user = (User) ((HttpServletRequest) request).getSession().getAttribute("user");
        if (user != null && user.getRole() == ADMIN) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect(LOG_IN);
        }
    }

}
