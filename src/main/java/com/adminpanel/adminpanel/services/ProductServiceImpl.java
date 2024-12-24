package com.adminpanel.adminpanel.services;

import com.adminpanel.adminpanel.models.ProductModel;
import com.adminpanel.adminpanel.models.UserModel;
import com.adminpanel.adminpanel.repository.ProductRepository;
import com.adminpanel.adminpanel.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;


    ApiResponse apiResponse=new ApiResponse();

    @Override
    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductModel getProductById(long id) {
        return productRepository.findById(id).get();
    }


    @Override
    public ProductModel updateProduct(long id, ProductModel productModel) {
      productRepository.updateProduct(productModel.getProduct_name(),productModel.getProduct_quantity(),productModel.getProduct_price(),id);
        return productRepository.findById(id).get();
    }

    @Override
    public ProductModel addProduct(ProductModel productModel) {
        System.out.println(productModel);
        return productRepository.save(productModel);
    }

    @Override
    public HashMap<String, Boolean> deleteProduct(long id) {
         productRepository.deleteById(id);
        Optional<ProductModel> product=productRepository.findById(id);
        if(product.isEmpty()){
            return apiResponse.addKeyValue(true);
        }
        return apiResponse.addKeyValue(false);
    }

    @Override
    public ProductModel updateProductQuantity(long id, ProductModel productModel) {
        productRepository.updateProductQuantity(productModel.getProduct_quantity(),id);
        return productRepository.findById(id).get();
    }


}
