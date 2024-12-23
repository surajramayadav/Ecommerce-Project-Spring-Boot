package com.adminpanel.adminpanel.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;
    @Column(name = "product_name",nullable = false)
    private String product_name;
    @Column(name = "product_quantity",nullable = false)
    private long product_quantity;
    @Column(name = "product_price",nullable = false)
    private long product_price;


    public ProductModel(){}

    public ProductModel(String product_name, long product_quantity, long product_price){
        this.product_name = product_name;
        this.product_quantity = product_quantity;
        this.product_price = product_price;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public long getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(long product_quantity) {
        this.product_quantity = product_quantity;
    }

    public long getProduct_price() {
        return product_price;
    }

    public void setProduct_price(long product_price) {
        this.product_price = product_price;
    }

    @Override
    public  String toString(){
        return  "Product [product_id="+product_id+",product_name="+product_name+",product_quantity="+product_quantity+",product_price="+product_price+"]";
    }
}
