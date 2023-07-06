package br.com.ficdev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @Controller
    public class StaticPageController {

        @GetMapping("/pagina1")
        public String getPagina1() {
            return "jogador.html";
        }

        @GetMapping("/pagina2")
        public String getPagina2() {
            return "jogador.html";
        }
    }

}
