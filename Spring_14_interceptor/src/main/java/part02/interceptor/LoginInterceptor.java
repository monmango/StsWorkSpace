package part02.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	public LoginInterceptor() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("login prohandle");
		String uri = request.getRequestURI();
		
		uri = uri.substring(uri.lastIndexOf("/")+1);
		System.out.println("uri :  "+uri);
		
		HttpSession session = request.getSession();
		//로그인 상태가 아니면
		if(session.getAttribute("chk")==null) {
			response.sendRedirect("login.do?returnUrl="+uri);
			return false;
		}else {
			return true;
		}
		
		
	}
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Login postHandle...");
	}
	
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("Login afterCompletion...");
	}
	
	
	
	

}
