package com.example.springstore.service;

import com.example.springstore.dao.StoreDao;
import com.example.springstore.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StoreService {
    private final StoreDao storeDao;

    @Autowired
    public StoreService(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    public Optional<Store> getStoreByID(Integer id) {
        return storeDao.findById(id);
    }

    //    public Store getStore(Integer id) {
//        if (id != null) {
//            Optional<Store> store = storeDao.findById(id);
//            if (store != null) {
//                return store.get();
//            } else return null;
//
//        } else return null;
//    }
    public List<Store> getALL() {
        return storeDao.findAll();
    }

    public void addStore(Store store) {
        Store newStore = new Store();
        newStore.setName(store.getName());
        newStore.setAddress(store.getAddress());
        storeDao.save(newStore);
    }

    public void addStore(String name, String address) {
        Store newStore = new Store();
        newStore.setName(name);
        newStore.setAddress(address);
        storeDao.save(newStore);
    }

    public void deleteStore(Integer storeID) {
        if (storeID != null) {
            storeDao.deleteById(storeID);
        } else
            System.out.println("wrong ID");
    }

    public void updateStore(Store store) {
        Optional<Store> findStore = storeDao.findById(store.getId());
        if (findStore.isEmpty()) {
            System.out.println("********* nera tokios parduotuves **********");
        } else
            storeDao.save(store);
    }
    public List<Store> getallStoresWithProducts() {
        List<Store> stores=  storeDao.findAll().stream()
                .sorted(Comparator.comparing((Store store) -> store.getProductInStores().size())
                        .reversed()).collect(Collectors.toList());
        return stores;
    }

}
