package ly.abinash.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ly.abinash.dtos.RegisterDto;
import ly.abinash.services.RegisterService;

@Controller
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView mav = new ModelAndView("register");
		RegisterDto registerDto = new RegisterDto();
		mav.addObject("registerObject", registerDto);
		return mav;
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ModelAndView regisetrProcess(RegisterDto registerDto) throws Exception {
		System.out.println(registerDto.toString());
		registerService.registerUser(registerDto);
		ModelAndView mav = new ModelAndView("register-processed");
		mav.addObject("registerObject", registerDto);
		return mav;
	}

}