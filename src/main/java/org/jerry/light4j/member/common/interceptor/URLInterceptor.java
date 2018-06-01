package org.jerry.light4j.member.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jerry.light4j.member.common.utils.RequestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 应用拦截器
 * @author admin
 *
 */
@Controller
public class URLInterceptor implements HandlerInterceptor{

	/**
	 * 请求拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		System.out.println(request.getRequestURI());
		System.out.println(RequestUtils.getIpAddr(request));
		System.out.println(session.getId());
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	/**
	 * 响应拦截(未渲染试图之前)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * 响应拦截(视图渲染之后)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	
}
