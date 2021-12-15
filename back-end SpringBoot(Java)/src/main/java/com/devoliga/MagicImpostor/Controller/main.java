package com.devoliga.MagicImpostor.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class main {

	 @GetMapping("/hello")
     public String hello()
     {
         return "helloView";
     }
}
