package com.devoliga.MagicImpostor.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.devoliga.MagicImpostor.model.Personagem;
import com.devoliga.MagicImpostor.service.ClaService;
import com.devoliga.MagicImpostor.service.PersonagemService;

@Controller
public class PersonagemController {

	@Autowired
	private PersonagemService service;
	
	@Autowired
	private ClaService serviceCla;
	
	@GetMapping("/personagens")
	public ModelAndView getPersonagem() {
		
		ModelAndView mv = new ModelAndView("personagem");
		mv.addObject("personagem", new Personagem());
		mv.addObject("personagens", service.getPersonagem());
		mv.addObject("clas", serviceCla.getCla());
		
		return mv;
	}
	
	@PostMapping("/salvar")
	public String salvar(@ModelAttribute Personagem personagem) {
		service.salvar(personagem);
		return "redirect:/personagens";
	}
}
