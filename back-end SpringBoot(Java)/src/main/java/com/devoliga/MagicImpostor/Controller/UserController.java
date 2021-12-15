package com.devoliga.MagicImpostor.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.devoliga.MagicImpostor.model.User;
import com.devoliga.MagicImpostor.service.UserService;

@Controller
@RequestMapping("/app")
public class UserController {

    @Autowired
    private UserService us;
    
    @GetMapping("/login")
    public String login() {
    	return "login";
    }
    
    @PostMapping("/login")
    public ModelAndView loginForm(@ModelAttribute User user) {
    	ModelAndView mv = new ModelAndView();
    	user = us.getUserByLogin(user.getLogin(), user.getSenha());
    	
    	if(user == null) {
    		mv.setViewName("erro");
    	}else {
    		mv.setViewName("userView");
    	}
    	
    	mv.addObject("user", user);
    	return mv;
    }
   

    @GetMapping("/user/{login}/{senha}")
    public ModelAndView getUser(
        @PathVariable("login") String login,
        @PathVariable("senha") String senha
        ) {
    	// a userView é o nome do html do template
        ModelAndView mv = new ModelAndView("userView");

        //pega o valor do end-point e coloca no parametro 
        User user = us.getUserByLogin(login, senha);    
        
        mv.addObject("user", user);

        return mv;
    }

}
