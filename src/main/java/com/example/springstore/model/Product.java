package com.example.springstore.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@NamedEntityGraph(name = "Product.productInStores", attributeNodes = @NamedAttributeNode("productInStores"))
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Integer id;
    private String name;
    @Column(name = "description", length = 65535, columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductInStore> productInStores;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductInStore> getProductInStores() {
        return productInStores;
    }

    public void setProductInStores(List<ProductInStore> productInStores) {
        this.productInStores = productInStores;
    }
}
