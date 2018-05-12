package org.jerry.light4j.member.common.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面重定向--默认跳转swagger页面
 * @author jerry
 *
 */
@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping(value = "/swagger")
	public String getSwagger() {
		return "redirect:swagger-ui.html";
	}
	
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
}
