package com.adminpanel.adminpanel.services;

import com.adminpanel.adminpanel.models.ProductModel;

import java.util.HashMap;
import java.util.List;

public interface ProductService {

    public List<ProductModel> getAllProducts();
    public ProductModel getProductById(long id);
    public ProductModel updateProduct(long id,ProductModel productModel);
    public ProductModel addProduct(ProductModel productModel);
    public HashMap<String ,Boolean> deleteProduct(long id);
    public ProductModel updateProductQuantity(long id,ProductModel productModel);

}
