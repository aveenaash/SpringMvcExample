package ly.abinash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ly.abinash.dtos.LoginDto;
import ly.abinash.services.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;

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
		boolean isLoginSuccessful = loginService.login(dto);
		if (isLoginSuccessful) {
			mv.setViewName("welcome");
			mv.addObject("user", dto);
		} else {
			mv.setViewName("login");
			mv.addObject("loginObject", dto);
			mv.addObject("message", "Login Unsuccess");
		}
		return mv;
	}

}
