package com.example.springstore.api;

import com.example.springstore.model.Store;
import com.example.springstore.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("api/store/")
//        (value = "api/v1/store/id",method = RequestMethod.GET)
@RestController
public class StoreController {
    private final StoreService storeService;
@Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }
    @GetMapping(path = "{id}")
    public String findStoreById(@PathVariable Integer id){
    String zinute="nera parduotuves";

        Store store=storeService.getStoreByID(id).orElse(null);
        if(store==null) return zinute;
        return store.getName();
    }
@GetMapping
    public List<String> getStoresNames() {
        return storeService.getALL().stream().map(store -> store.getName()).collect(Collectors.toList());
    }
    @DeleteMapping
    public void deleteStore( @PathVariable Integer id){
    storeService.deleteStore(id);
    }

}
