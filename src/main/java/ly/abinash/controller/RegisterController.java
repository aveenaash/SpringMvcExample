package ly.abinash.controller;

import java.text.ParseException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ly.abinash.dtos.RegisterDto;

@Controller
public class RegisterController {

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView mav = new ModelAndView("register");

		RegisterDto registerDto = new RegisterDto();
		mav.addObject("registerObject", registerDto);
		return mav;
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ModelAndView regisetrProcess(RegisterDto registerDto) throws ParseException {
		System.out.println(registerDto.toString());
		ModelAndView mav = new ModelAndView("register-processed");
		mav.addObject("registerObject", registerDto);
		return mav;
	}

}