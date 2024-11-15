package sg.edu.nus.iss.vttp5a_ssf_day02l.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_ssf_day02l.model.Item;

@Repository
public class ItemRepo {
    
    private List<Item> itemList;

    public List<Item> getItems() {
        itemList = new ArrayList<>();

        Item item1 = new Item("Apple M4 mini",5);
        itemList.add(item1);
        Item item2 = new Item("iphone 16 max pro",15);
        itemList.add(item2);
        Item item3 = new Item("Prada wallet",25);
        itemList.add(item3);
        Item item4 = new Item("Hermes Tot Bag",10);
        itemList.add(item4);
        
        return itemList;
    }
}
