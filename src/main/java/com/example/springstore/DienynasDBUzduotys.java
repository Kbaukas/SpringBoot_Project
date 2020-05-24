package com.example.springstore;


import com.example.springstore.dao.ProductDao;
import com.example.springstore.dao.StoreDao;
import com.example.springstore.model.Store;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DienynasDBUzduotys implements CommandLineRunner {
    @Resource
    private final ProductDao productDao;
    @Resource
    private final StoreDao storeDao;

    public DienynasDBUzduotys(ProductDao productDao, StoreDao storeDao) {
        this.productDao = productDao;
        this.storeDao = storeDao;
    }


    @Override
    public void run(String... args) throws Exception {
        //        Set<Store> stores = storeDao.findAll().stream().collect(Collectors.toSet());
        List<Store> stores = storeDao.findAll().stream().sorted(Comparator.comparing(Store::getName)).collect(Collectors.toList());

        //    1 Uzduotis
        System.out.println("*****************************************Pirma uzduotis***********************************" + "\n");
        System.out.println("Yra is viso skirtingu produktu:" + productDao.count());

//         2 Uzduotis
        System.out.println("*****************************************   Antra uzduotis  ***********************************" + "\n");
        stores.forEach(store -> {
            System.out.println(" ******** " + store.getName() + " **********");
            if (store.getProductInStores().isEmpty()) System.out.println("prekiu nera");
            store.getProductInStores()
                    .forEach(productInStore ->
                            System.out.println(productInStore.getProduct()
                                    .getName() + " Kiekis: " + productInStore.getQuantity() +
                                    " Kaina: " + productInStore.getPrice() + " Suma: " + (productInStore.getPrice()
                                    .multiply(BigDecimal.valueOf(productInStore.getQuantity())))));

        });
//        3 Uzduotis
        System.out.println("*****************************************   Trecia uzduotis  ***********************************" + "\n");
        stores.stream().forEach(store -> {
            int visoSuma;
            Integer suma;
            suma = store.getProductInStores().stream().map(productInStore -> productInStore.getQuantity()).reduce((a1, a2) -> a1 + a2).orElse(null);
            if (suma==null) {
                visoSuma = 0;
            } else {
                visoSuma = suma;
            }
            System.out.println("----------------------------------- " + store.getName().toUpperCase() + " ---------------------------------------");
            System.out.println();
            System.out.println(" Adresas: " + store.getAddress() + " Viso prekiu: " + visoSuma + "\n");

        });

//      4 Uzduotis
        System.out.println("*****************************************   Ketvirta uzduotis  ***********************************" + "\n");
        stores.forEach(store -> {
            BigDecimal atspausdinamaSuma = BigDecimal.valueOf(0);
            BigDecimal sandelioSuma = store.getProductInStores().stream()
                    .map(productInStore -> productInStore.getPrice()
                            .multiply(BigDecimal.valueOf(productInStore.getQuantity())))
                    .reduce(BigDecimal::add).orElse(null);
            if (sandelioSuma==null) {
                atspausdinamaSuma = BigDecimal.valueOf(0);
            } else {
                atspausdinamaSuma = sandelioSuma;
            }
            System.out.println("--------------------------------- " + store.getName() + " --------------------------------");
            System.out.println(" Adresas: " + store.getAddress() + ".   Bendra sandelio verte: " + atspausdinamaSuma + "\n");

        });


        System.out.println("*****************************************Penkta uzduotis***********************************" + "\n");
//        5 uzduotis
        stores.stream().filter(store -> store.getProductInStores().size() < 4)
                .forEach(store -> System.out.println(store.getName() + " Prekiu rusiu sk.: " + store.getProductInStores().size()));


//        6 uzduotis
        System.out.println("*****************************************Sesta uzduotis***********************************" + "\n");
//       List<Product> products= productDao.findAll();
//      products.stream().filter(product -> product.getProductInStores().size() == 0)
//                .forEach(product -> System.out.println(product.getName()));
        System.out.println("-----------------------------------------------------------------------------------------");
// ----------------------------------su Query ---------------------------------------------------
        productDao.findProductsIfInStore().forEach(product -> System.out.println(product.getName()));

    }
//


}
