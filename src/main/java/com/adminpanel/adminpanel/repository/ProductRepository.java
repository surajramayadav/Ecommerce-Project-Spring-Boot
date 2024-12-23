package com.adminpanel.adminpanel.repository;

import com.adminpanel.adminpanel.models.ProductModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel,Long> {


    @Transactional
    @Modifying
    @Query(value = "update product ref set ref.product_name=?1,ref.product_quantity=?2, ref.product_price=?3 where ref.product_id=?4 ", nativeQuery = true)
    public int updateProduct(String product_name, long product_quantity, long product_price, long product_id);

    @Transactional
    @Modifying
    @Query(value = "update product ref set ref.product_quantity=?1 where ref.product_id=?2 ", nativeQuery = true)
    public int updateProductQuantity(long product_quantity, long product_id);
}
