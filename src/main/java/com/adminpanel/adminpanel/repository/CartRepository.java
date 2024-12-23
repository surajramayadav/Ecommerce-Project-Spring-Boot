package com.adminpanel.adminpanel.repository;

import com.adminpanel.adminpanel.models.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartModel,Long> {

}
