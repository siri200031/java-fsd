package com.example.demo;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeRepo repo;
	
	Logger log=Logger.getAnonymousLogger();
	
	@RequestMapping("/")
	public ModelAndView loadpage(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login.jsp");
		log.info("login page loaded ");
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView loginaction(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		String user=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		log.info("login request with username and password recieved ");
		Employee ee=repo.findByuserpwd(user, pwd);
		if(ee!=null) {
			mv.setViewName("display.jsp");
			log.info("logged in successfully and went to the page display.jsp");
			mv.addObject("emp",ee);
		}
		else {
			mv.setViewName("fail.jsp");
			log.info("login failed ");
		}
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/registermslogin")
	public String registermslogin(HttpServletRequest request,HttpServletResponse response) {
		log.info("request loaded ");
		String user=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		//restapi
		RestTemplate rest=new RestTemplate();
		 String url="http://localhost:8085/register-user/"+user+"/"+pwd+"/"+email;
		 log.info(url);
		 rest.getForObject(url,String.class);
		 
		return "registration is succesfull";
		
	}
	
}
