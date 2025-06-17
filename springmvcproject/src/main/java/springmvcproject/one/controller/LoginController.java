package springmvcproject.one.controller;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springmvcproject.one.bean.User;
import springmvcproject.one.bean.UserDAO;

@Controller
public class LoginController {
	
	@Autowired
	private UserDAO userDAO; 
	
	@RequestMapping("/login")
	public void prepareUser(Model data) {
		User objUser = new User();
		data.addAttribute("objUser", objUser);
	}
	
	
	
	@RequestMapping("/auth")
	public ModelAndView authenticateUser(@ModelAttribute("objUser") User objUser) {
		User user = userDAO.getUser(); 
		if(objUser.getName().equals(user.getName()) && objUser.getPassword().equals(user.getPassword()))
			return new ModelAndView("welcome", "msg", "authenticated Successfully");
		
		return new ModelAndView("failure", "msg", "failed to authenticate or user is invalid");
	}
}