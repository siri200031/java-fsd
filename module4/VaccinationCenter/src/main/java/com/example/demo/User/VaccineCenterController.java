package com.example.demo.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VaccineCenterController {
	@Autowired
	VaccineCenterDAO dao;

	
	@RequestMapping("/")
	public ModelAndView basepage(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login.jsp");
		return mv;
	}
	
	@RequestMapping("/register")
	public ModelAndView insert(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Admin admin=new Admin();
		admin.setEmail(request.getParameter("email"));
		admin.setName(request.getParameter("username"));
		admin.setPassword(request.getParameter("password"));
		Admin a=dao.insertAdmin(admin);
		if(a!=null) {
			mv.setViewName("login.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mv = new ModelAndView();
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    
	    Admin admin = dao.findByEmail(email);

	    if (admin != null && admin.getPassword().equals(password)) {
	    	HttpSession session = request.getSession();
	        session.setAttribute("email", email);
	        mv.setViewName("home.jsp");
	    } else {
	        mv.setViewName("login.jsp");
	        mv.addObject("error", "Invalid email or password");
	    }

	    return mv;
	}
	
	@RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        HttpSession session = request.getSession();
        session.invalidate();

        return "redirect:/login.jsp";
    }
	
	@RequestMapping("/vaccinationcenter")
	public ModelAndView displaycenter(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		List<Center> list=dao.findAllCenters();
		mv.setViewName("vaccinationcenter.jsp");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/insertcenter")
	public ModelAndView insertCenter(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Center center=new Center();
		center.setCentername(request.getParameter("name"));
		center.setCentercity(request.getParameter("city"));
		dao.insertCenter(center);
		mv.setViewName("redirect:/vaccinationcenter");

		return mv;
	}

	@RequestMapping("/citizens")
	public ModelAndView displayCitizen(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		List<Citizen> list=dao.findAllCitizen();
		mv.setViewName("citizens.jsp");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/addcitizen")
	public ModelAndView addCitizen(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		List<Center> list=dao.findAllCenters();
		mv.setViewName("addcitizen.jsp");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/insertcitizen")
	public ModelAndView insertCitizen(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();

	    
	    String name = request.getParameter("name");
	    String city = request.getParameter("city");
	    String centerName = request.getParameter("center");

	    
	    Center center = dao.findCenterByName(centerName); 

	   
	    Citizen citizen = new Citizen();
	    citizen.setName(name);
	    citizen.setCity(city);
	    citizen.setCenter(center);
	    citizen.setDose(0);
	    citizen.setStatus("Not Vaccinated");

	    dao.insertCitizen(citizen);

	    mv.setViewName("redirect:/citizens");
	    return mv;
	}
	
	@RequestMapping("/viewcenter")
	public ModelAndView viewCenter(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mv = new ModelAndView();
	    int centerId = Integer.parseInt(request.getParameter("id"));

	    Center center = dao.findCenterById(centerId);
	    List<Citizen> citizens = dao.findCitizensByCenter(center);

	    mv.setViewName("viewcenter.jsp");
	    mv.addObject("center", center);
	    mv.addObject("citizens", citizens);

	    return mv;
	}
	
	@RequestMapping("/viewcitizen")
	public ModelAndView viewCitizen(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mv = new ModelAndView();
	    int citizenId = Integer.parseInt(request.getParameter("id"));

	    Citizen citizen = dao.findCitizenById(citizenId);
	    
	    mv.setViewName("viewcitizen.jsp");
	    mv.addObject("citizen", citizen);

	    return mv;
	}
	
	@RequestMapping("/editcenter")
	public ModelAndView editCenter(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv= new ModelAndView();
		int centerId=Integer.parseInt(request.getParameter("id"));
		
		Center center= dao.findCenterById(centerId);
		
		 mv.setViewName("editcenter.jsp");
		 mv.addObject("center", center);

		return mv;
		
	}
	
	@RequestMapping("/updatecenter")
	public ModelAndView updateCenter(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv= new ModelAndView();
		int centerId=Integer.parseInt(request.getParameter("id"));
		String centerName=request.getParameter("cname");
		String centerCity=request.getParameter("ccity");
		Center center= new Center();
		center.setCentercity(centerCity);
		center.setCentername(centerName);
		
		dao.updateCenter(centerId,center);
		mv.setViewName("redirect:/vaccinationcenter");

		return mv;
		
	}
	
	@RequestMapping("/editcitizen")
	public ModelAndView editCitizen(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv= new ModelAndView();
		int citizenId=Integer.parseInt(request.getParameter("id"));
		
		Citizen citizen= dao.findCitizenById(citizenId);
		List<Center> list=dao.findAllCenters();
		
		 mv.setViewName("editcitizen.jsp");
		 mv.addObject("citizen", citizen);
		 mv.addObject("list", list);
		return mv;
		
	}
	
	@RequestMapping("/updatecitizen")
	public ModelAndView updateCitizen(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv= new ModelAndView();
		
		int citizenId=Integer.parseInt(request.getParameter("id"));
		
		String citizenName=request.getParameter("name");
		String centerCity=request.getParameter("city");
		String centerName=request.getParameter("center");
		int citizenDose=Integer.parseInt(request.getParameter("dose"));
		String citizenStatus="";
		if(citizenDose == 1 ) {
			 citizenStatus="One dose Completed";
		}
		else if(citizenDose >1 ) {
			 citizenStatus="Fully Vaccinated";
		}
		else {
			 citizenStatus="Not Vaccinated";
		}
		
		Center center = dao.findCenterByName(centerName); 
		
		Citizen citizen= new Citizen();
		citizen.setName(citizenName);
		citizen.setCity(centerCity);
		citizen.setDose(citizenDose);
		citizen.setStatus(citizenStatus);
		citizen.setCenter(center);
		
		
		dao.updateCitizen(citizenId,citizen);
		mv.setViewName("redirect:/citizens");

		return mv;
		
	}
	
	@RequestMapping("/deletecitizen")
	public ModelAndView deleteCitizen(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mv = new ModelAndView();
	    int citizenId = Integer.parseInt(request.getParameter("id"));

	    dao.deleteCitizenById(citizenId);

	    mv.setViewName("redirect:/citizens");
	    return mv;
	}
	
	@RequestMapping("/deletecenter")
	public ModelAndView deleteCenter(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		Integer centerId = Integer.parseInt(request.getParameter("id"));
	    if (centerId != null) {
	        Center center = dao.findCenterById(centerId);
            
	        if (center != null) {
	            List<Citizen> citizens = dao.getCitizens(center);
	            dao.deleteAll(citizens);
	            dao.delete(center);
	        }
	    }
	    mv.setViewName("redirect:/vaccinationcenter");
	    return mv;
	}
}