package com.example.springstore.service;

import com.example.springstore.dao.ProductDao;
import com.example.springstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
class ProductService{
    @Autowired
    ProductDao productDao;

    public List<Product> getAllProducts(){
     return    productDao.findAll();

    }

}

