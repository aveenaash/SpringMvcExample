package ly.abinash.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ly.abinash.dtos.LoginDto;

@Controller
public class LoginController {

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login() {
		LoginDto dto = new LoginDto();
		ModelAndView view = new ModelAndView("login");
		view.addObject("loginObject", dto);
		return view;
	}

	@RequestMapping(value = "login-execute", method = RequestMethod.POST)
	public ModelAndView loginProcess(LoginDto dto) {
		String username = dto.getUsername();
		String password = dto.getPassword();
		System.out.println("Username : " + username + ", Password : " + password);
		ModelAndView mv = new ModelAndView();
		if (username.equals(password)) {
			mv.setViewName("welcome");
			mv.addObject("user", dto);
		} else {
			mv.setViewName("login");
			mv.addObject("loginObject", dto);
			mv.addObject("message", "Your username password doesnt match");
		}
		return mv;
	}

}
