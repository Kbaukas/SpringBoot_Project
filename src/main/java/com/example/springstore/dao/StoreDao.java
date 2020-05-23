package com.example.springstore.dao;

import com.example.springstore.model.Store;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StoreDao extends JpaRepository<Store, Integer> {
    @Override
    @EntityGraph(attributePaths = {"productInStores"})
//    @Query("select s from  Store s left join fetch s.productInStores")
    List<Store> findAll();


}

