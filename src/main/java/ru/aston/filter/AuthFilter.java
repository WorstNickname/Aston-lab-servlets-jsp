package ru.aston.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.aston.entity.User;

import java.io.IOException;
import java.util.Set;

import static ru.aston.util.UrlPath.*;

@WebFilter(filterName = "authFilter", urlPatterns = "/*")
public class AuthFilter implements Filter {

    private static final Set<String> PUBLIC_PATH = Set.of(LOG_IN, REGISTRATION, HOME_PAGE);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        var uri = ((HttpServletRequest) request).getRequestURI();
        var user = (User) ((HttpServletRequest) request).getSession().getAttribute("user");

        if (isPublicPath(uri) || isUserLoggedIn(user)) {
            filterChain.doFilter(request, response);
        } else {
            var prevPage = ((HttpServletResponse) response).getHeader("referer");
            ((HttpServletResponse) response).sendRedirect(prevPage != null ? prevPage : LOG_IN);
        }
    }

    private boolean isUserLoggedIn(User user) {
        return user != null;
    }

    private boolean isPublicPath(String uri) {
        return PUBLIC_PATH.stream().anyMatch(path -> path.startsWith(uri));
    }

}
