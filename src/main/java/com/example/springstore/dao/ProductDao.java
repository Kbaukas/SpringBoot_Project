package com.example.springstore.dao;

import com.example.springstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    @Override
    @Query("select p from  Product p left join fetch p.productInStores")
    List<Product> findAll();

//    Randame produktus kurie nera parduotuvese
    @Query("select p from Product p left join ProductInStore ps ON ps.product.id=p.id where ps is null ")
    List<Product> findProductsIfInStore();
}
