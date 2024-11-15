package sg.edu.nus.iss.vttp5a_ssf_day02l.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_ssf_day02l.model.Country;

@Repository
public class CountryRepo {
    List<Country> countryList;
    
    public List<Country> getCountries() {
        if (countryList == null) {
            countryList = new ArrayList<>();
        }
        

        Country cty = new Country("SG","Singapore",6000000);
        countryList.add(cty);
        cty = new Country("MY","Malaysia",8000000);
        countryList.add(cty);
        cty = new Country("IL","Israel",10000000);
        countryList.add(cty);
        cty = new Country("CN","China",10000000);
        countryList.add(cty);
        cty = new Country("EU","Europe",9000000);
        countryList.add(cty);
        cty = new Country("HK","Hong Kong",7000000);
        countryList.add(cty);


        return countryList;

    }

    public Boolean createCountry(Country cty) {
        if (countryList ==null) {
            countryList = new ArrayList<>();
    
        }
        countryList.add(cty);
        return true;

    }
}
