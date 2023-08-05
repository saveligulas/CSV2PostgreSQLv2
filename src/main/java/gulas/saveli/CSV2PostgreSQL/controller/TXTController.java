package gulas.saveli.CSV2PostgreSQL.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/txt")
public class TXTController {
    @GetMapping
    public ModelAndView txtHomeView() {
        return new ModelAndView();
    }
}
