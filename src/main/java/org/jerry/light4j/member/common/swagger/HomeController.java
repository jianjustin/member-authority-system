package org.jerry.light4j.member.common.swagger;

import org.jerry.light4j.member.business.member.user.repository.MemberUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 页面重定向--默认跳转swagger页面
 * @author jerry
 *
 */
@Controller
public class HomeController {

	@Autowired
	private MemberUserRepository memberUserRepository;
	
	@RequestMapping(value = "swagger",method=RequestMethod.GET)
	public String getSwagger() {
		return "redirect:swagger-ui.html";
	}
	
	@RequestMapping(value = "",method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "index",method=RequestMethod.GET)
	public String index1() {
		return "index";
	}
	
	@RequestMapping(value = "login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "resourceList",method=RequestMethod.GET)
	public String resourceList() {
		return "member/resourceList";
	}
	
   

	public MemberUserRepository getMemberUserRepository() {
		return memberUserRepository;
	}
	public void setMemberUserRepository(MemberUserRepository memberUserRepository) {
		this.memberUserRepository = memberUserRepository;
	}
	
	
}
