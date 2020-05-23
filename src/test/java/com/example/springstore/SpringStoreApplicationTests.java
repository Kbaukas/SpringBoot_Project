package com.example.springstore;

import com.example.springstore.dao.StoreDao;
import com.example.springstore.model.Store;
import com.example.springstore.service.StoreService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringStoreApplicationTests {
    @Resource
    StoreService storeService;
    @Resource
    StoreDao storeDao;

    @Test
    void contextLoads() {
    }

    @Test
    void getStore() {
        Store store = storeService.getStoreByID(1).orElse(null);
        System.out.println(store.getName());
        System.out.println(storeDao.count());
        store.getProductInStores().forEach(productInStore -> System.out.println(productInStore.getPrice()));
//	@Test
//	void addStore(){
//		Store store=new Store();
//		store.setName("Troliai-Mumiai");
//		store.setAddress("Giriu g. 12. Bababa");
//		storeService.addStore(store);
    }

    @Test
    void updateStore() {
//        Store store = new Store();
//        store.setId(8);
//        store.setName("Ozkuciai");
//        storeService.updateStore(store);
    }
}
