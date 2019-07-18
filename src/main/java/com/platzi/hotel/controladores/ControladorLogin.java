package com.platzi.hotel.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("app")
public class ControladorLogin {

	@GetMapping(value = {"/login", "/"})
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		String mensajeError = "Usuario no autorizado";
		modelAndView.addObject("errorMsg", mensajeError);
		modelAndView.setViewName("login");
		
		return modelAndView;
	}
	
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
				
		return modelAndView;
	}
	
}
