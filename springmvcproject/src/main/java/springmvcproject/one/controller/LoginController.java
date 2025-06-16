package springmvcproject.one.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springmvcproject.one.bean.User;

@Controller
public class LoginController {
	
	
	
	@RequestMapping("/login")
	public String prepareUser(Model data) {
				User objUser = new User();
				
				data.addAttribute("objUser",objUser);
				
				return "login";
	}

	@RequestMapping("/auth")
	public ModelAndView authenticateUser(@ModelAttribute("objUser") User objUser) {
		
		
		if(objUser.getUsername().equals("guru") && objUser.getPassword().equals("1234"))
			return new ModelAndView("welcome","msg","authenticated Succesfully");
		
		return new ModelAndView("failure","msg","faild to authenticate or user is invalid");
	}



}
