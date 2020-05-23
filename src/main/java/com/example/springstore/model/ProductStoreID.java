package com.example.springstore.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductStoreID implements Serializable {
    Product product;
    Store store;


}
