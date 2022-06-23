package vegan.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		
		String URI = request.getRequestURI();
		
		if(URI.contains("index") || URI.substring(URI.length() - 16).contains("/SpringMVCVegan/")) {
			return true;
		}
		
		if(URI.contains("goLogin")) {
			return true;
		}
		
		if(URI.contains("login")) {
			return true;
		}
		
		if(URI.contains("showForm")) {
			return true;
		}
		
		if(URI.contains("saveUser")) {
			return true;
		}
		
		if(session.getAttribute("userLoginInfo") != null) {
			return true;
		}

		response.setStatus(302);
		response.setHeader("Location","http://localhost:8080/SpringMVCVegan/user/goLogin");
		
		return false;
	}

}
