package springmvcproject.one.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springmvcproject.one.bean.User;
import springmvcproject.one.bean.UserDAO;
import springmvcproject.one.bean.UserDAOImpl;

@Controller
public class LoginController {
	
	
	
	@RequestMapping("/login")
	public void prepareUser(Model data) {
				User objUser = new User();
				
				data.addAttribute("objUser",objUser);
				
				//return "login";
	}

	@RequestMapping("/auth")
	public ModelAndView authenticateUser(@ModelAttribute("objUser") User objUser) {
		UserDAO dao = new UserDAOImpl();
		User user = dao.getUser();
		if(objUser.getName().equals(user.getName()) && objUser.getPassword().equals(user.getPassword()))
			return new ModelAndView("welcome","msg","authenticated Succesfully");
		
		return new ModelAndView("failure","msg","faild to authenticate or user is invalid");
	}



}
