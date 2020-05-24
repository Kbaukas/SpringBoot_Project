package com.example.springstore.dao;

import com.example.springstore.model.ProductInStore;
import com.example.springstore.model.ProductStoreID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsInStoreDao extends JpaRepository<ProductInStore,ProductStoreID> {
}
