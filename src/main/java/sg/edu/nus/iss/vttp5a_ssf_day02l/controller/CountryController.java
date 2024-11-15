package sg.edu.nus.iss.vttp5a_ssf_day02l.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.edu.nus.iss.vttp5a_ssf_day02l.model.Country;
import sg.edu.nus.iss.vttp5a_ssf_day02l.service.CountryService;

@Controller
@RequestMapping("/countries")
public class CountryController {
    
    @Autowired
    CountryService countryService;

    @ResponseBody // like creating an API
    @GetMapping("")
    public List<Country> getCountries() {
        return countryService.getCountries();
    }

    @ResponseBody // like creating an API
    @GetMapping("/filter")
    public List<Country> getCountries(@RequestParam(name = "population") String population) {

        List<Country> countryList = countryService.getCountries();
        List<Country> filteredList = countryList.stream()
                                                .filter(a->a.getPopulation() >= Integer.parseInt(population))
                                                .collect(Collectors.toList());

        return filteredList;

    }
}
