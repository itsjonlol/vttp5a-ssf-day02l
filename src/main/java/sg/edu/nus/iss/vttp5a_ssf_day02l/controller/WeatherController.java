package sg.edu.nus.iss.vttp5a_ssf_day02l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.vttp5a_ssf_day02l.model.Country;
import sg.edu.nus.iss.vttp5a_ssf_day02l.service.CountryService;

@Controller
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    CountryService countryService;

    @GetMapping("") // /weather?countries=Israel /weather?country=Israel&metrics=kilometers
    public String weather(@RequestParam(required = true,name = "country",defaultValue="Singapore") String city,
    @RequestParam(name = "metrics",defaultValue="centimeters") String metrics,Model model){
        model.addAttribute("city",city);
        model.addAttribute("metrics",metrics);
        return "weather_page";
        //if you dont set a default value for country, there will be an error because required = true
        //if dont set name, it will default to the parameter name

    }
    @GetMapping(path = {"/city/{country}/metrics/{metrics}","/{country}/{metrics}"}) //path variable no default value /weather/city/Taiwan/metrics/kilometers
    public String weather2(@PathVariable(required = true,name = "country") String city,
    @PathVariable(name = "metrics") String metrics,Model model){
        model.addAttribute("city",city);
        model.addAttribute("metrics",metrics);
        return "weather_page";
        
    }
    @GetMapping("/pagea")
    public String pageA(Model model) {
        String[] units = {"milimeters, centimeters","kilometers"};
        

        List<Country> countries = countryService.getCountries();

        model.addAttribute("countries",countries);
        model.addAttribute("metrics",units);

        return "pageA";
    }

    @GetMapping("/forma") 
    public String showForm() {
        return "forma";
    }
    @PostMapping("/forma")
    public String handlePageA(@RequestBody MultiValueMap<String,String> form) {
        //Map<String,String> formData = new HashMap<>();
        
        for (String str : form.keySet()) {
            //formData.put(str,form.getFirst(str));
            System.out.println(str + ">>>" + form.getFirst(str));
        }

        

        return "forma";
        
    }

    
    //if no param name, will take the city
}