package sg.edu.nus.iss.vttp5a_ssf_day02l.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home") // to enter the controller
public class HomeController {

    @GetMapping(path = {"","/landing"})
    //@GetMapping("") //empty mapping or can be multiple path
    public String home(Model model) {
        model.addAttribute("currDate", new Date().toString());
        Calendar cal = Calendar.getInstance();
        model.addAttribute("currHour",cal.get(Calendar.HOUR_OF_DAY));
        return "home_page";
    }

    
    
    
}
