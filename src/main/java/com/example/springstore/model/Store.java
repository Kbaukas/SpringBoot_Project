package com.example.springstore.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "stores")
@NamedEntityGraph(name = "Store.productInStores", attributeNodes = @NamedAttributeNode("productInStores"))
public class Store implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    private List<ProductInStore> productInStores;

    public Store() {
    }

    public Store(@JsonProperty("name") String name, @JsonProperty("address") String address) {
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ProductInStore> getProductInStores() {
        return productInStores;
    }

    public void setProductInStores(List<ProductInStore> productInStores) {
        this.productInStores = productInStores;
    }
}
