package sg.edu.nus.iss.vttp5a_ssf_day02l.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.vttp5a_ssf_day02l.model.Item;
import sg.edu.nus.iss.vttp5a_ssf_day02l.service.ItemService;

@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("")
    public String cartItems(Model model) {
        List<Item> cartList = itemService.getItems();
        model.addAttribute("cartList",cartList);

        return "cartlist_page";

        
    }
    
    @GetMapping("/filter") // /filter?itemsQuantity=10
    public String cartItems(@RequestParam(name="itemQuantity") String quantity, Model model) {
        List<Item> cartList = itemService.getItems();
        
        List<Item> filterList = cartList.stream().filter(a ->a.getQuantity() >= Integer.parseInt(quantity)).collect(Collectors.toList());
        model.addAttribute("cartList",filterList);

        return "cartlist_page";
    

        
    }
    
}
