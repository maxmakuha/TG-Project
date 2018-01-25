package ua.kiev.ukma.tg.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import ua.kiev.ukma.tg.model.UserAuth;

@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		
        UserAuth userAuth = (UserAuth) auth.getPrincipal();
        
        switch(userAuth.getRole().getRole()) {
        case "METHODIST":
        	response.sendRedirect("methodist/timetables");
        	break;
        case "TEACHER":
        	response.sendRedirect("teacher/timetables");
        	break;
        case "STUDENT":
        	response.sendRedirect("student/timetables");
        	break;
        }
	}
}