package com.devoliga.MagicImpostor.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.devoliga.MagicImpostor.model.Cla;
import com.devoliga.MagicImpostor.service.ClaService;

@Controller
public class ClaController {

    @Autowired
    private ClaService servico;

    @GetMapping("/cla")
    public ModelAndView getCursos() {
        ModelAndView mv = new ModelAndView("claTemplate");
        mv.addObject("cla", servico.getCla());

        return mv;
    }

    @PostMapping("/salvarCla")
    public String salvar(@ModelAttribute Cla cla) {
        servico.salvar(cla);

        return "redirect:/cla";
    }
    
    @GetMapping("/detalhesCurso/{id}")
    public ModelAndView getCursoDetalhes(@PathVariable(name = "id") Integer id) {
       
        Cla cla = servico.getClaById(id);
        ModelAndView mv = new ModelAndView("detalhesCla");
        mv.addObject("cla", cla);

        return mv;
    }

   
}