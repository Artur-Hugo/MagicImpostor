package com.devoliga.MagicImpostor.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.devoliga.MagicImpostor.model.Armas;
import com.devoliga.MagicImpostor.model.Cla;
import com.devoliga.MagicImpostor.service.ArmasService;
import com.devoliga.MagicImpostor.service.ClaService;

@Controller
public class ArmaController {

    @Autowired
    private ArmasService armaService;

    @Autowired
    private ClaService claService;

    @GetMapping("/armas")
    public ModelAndView getProfessores() {
        ModelAndView mv = new ModelAndView("armasTemplate");
        mv.addObject("armas", armaService.getArmas() );

        return mv;
    }

    @PostMapping("/salvarArma")
    public String salvar(@ModelAttribute Armas armas) {
        armaService.salvar(armas);
        return "redirect:/armas";
    }

    @PostMapping("/associarClaArma{codigo}")
    public String associarCurso(@ModelAttribute Cla cla, @RequestParam Integer codigo) {
        

        Armas armas  = armaService.getArmasById(codigo);
        cla = claService.getClaById(cla.getId());
        

        armas.getClas().add(cla);
        armaService.salvar(armas);

        return "redirect:/detalhesArmas/" + codigo;
    }

    @GetMapping("/detalhesArmas/{codigo}")
    public ModelAndView getCursoDetalhes(@PathVariable(name = "codigo") Integer codigo) {

        Armas armas = armaService.getArmasById(codigo);
        ModelAndView mv = new ModelAndView("detalhesArmas");
        mv.addObject("armas", armas);
        List<Cla> clasNaoAssociados = claService.getCla();
        clasNaoAssociados.removeAll(armas.getClas());
        mv.addObject("clas", clasNaoAssociados);

        return mv;
    }

}
