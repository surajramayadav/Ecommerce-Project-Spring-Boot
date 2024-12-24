package com.adminpanel.adminpanel.repository;

import com.adminpanel.adminpanel.models.CartModel;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface CartRepository extends JpaRepository<CartModel,Long> {

    @Query(value = "select cart_items.cart_items_id,cart.cart_id,cart.timestamp,cart.user_id,product.product_name,product.product_quantity,product.product_price,cart_items.cart_quantity from cart_items join cart on cart_items.cart_id=cart.cart_id join product on cart_items.product_id=product.product_id",nativeQuery = true)
    List<Map<String, String>> getCart();

    @Query(value = "select cart_items.cart_items_id, cart.cart_id,cart.timestamp,cart.user_id,product.product_name,product.product_quantity,product.product_price,cart_items.cart_quantity from cart join cart_items on cart.cart_id=cart_items.cart_id join product on cart_items.product_id=product.product_id where cart.user_id=?1",nativeQuery = true)
    List<Map<String, String>> getCartByUserId(long user_id);

    @Query(value = "select cart_items.cart_items_id,cart.cart_id,cart.timestamp,cart.user_id,product.product_name,product.product_quantity,product.product_price,cart_items.cart_quantity from cart_items join product on cart_items.product_id=product.product_id join cart on cart_items.cart_id=cart.cart_id where cart.cart_id=?1",nativeQuery = true)
    List<Map<String, String>> getCartByCartId(long cart_id);

    @Transactional
    @Modifying
    @Query(value = "update cart_items set cart_quantity=?1 where cart_items_id=?2",nativeQuery = true)
    int updateCartQuantity(long cart_quantity,long cart_id);


    @Query(value = "select cart_id from cart where user_id=?1",nativeQuery = true)
    List<Tuple> getUserBycart(long user_id);

}
