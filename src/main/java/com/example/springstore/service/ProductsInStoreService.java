package com.example.springstore.service;

import com.example.springstore.dao.ProductsInStoreDao;
import com.example.springstore.model.ProductInStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductsInStoreService {
    @Autowired
    ProductsInStoreDao productsInStoreDao;
    public Map<String, List<ProductInStore>> getProductsBySores() {
       return  productsInStoreDao.findAll().stream().collect(Collectors.groupingBy(((ProductInStore productInStore) -> productInStore.getStore().getName())));
    }
}
