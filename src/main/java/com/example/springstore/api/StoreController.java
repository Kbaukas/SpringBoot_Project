package com.example.springstore.api;

import com.example.springstore.model.Store;
import com.example.springstore.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

//@RequestMapping("/store")
//        (value = "api/store/id",method = RequestMethod.GET)
@Controller
public class StoreController {
    private final StoreService storeService;
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }


    @GetMapping(path = "{id}")
    public String findStoreById(@PathVariable Integer id) {
        String zinute = "nera parduotuves";

        Store store = storeService.getStoreByID(id).orElse(null);
        if (store == null) return zinute;
        return store.getName();
    }

    @GetMapping("/parduotuves")
    public List<String> getStoresNames() {
        return storeService.getALL().stream().map(store -> store.getName()).collect(Collectors.toList());
    }

    @DeleteMapping
    public void deleteStore(@PathVariable Integer id) {
        storeService.deleteStore(id);
    }

    @GetMapping({ "/", "/stores" })
    public String getallStores(Model model){
        model.addAttribute("stores",storeService.getallStoresWithProducts());
        return "list";
//    @GetMapping({ "/", "/list" })
//    public String getallStores(Model model){
//        model.addAttribute("name",storeService.getStoreByID(1).get().getName());
//        model.addAttribute("address",storeService.getStoreByID(1).get().getAddress());
//        model.addAttribute("id",storeService.getStoreByID(1).get().getId());
//        return "list";
//                productsInStoreService.getProductsBySores().entrySet().stream()
//                .map(stringListEntry ->"Parduotuve: "+stringListEntry.getKey()+"<br/>"+stringListEntry.getValue()+" ").collect(Collectors.toList());

    }

}
