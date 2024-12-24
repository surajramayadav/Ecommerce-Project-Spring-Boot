package com.adminpanel.adminpanel.repository;

import com.adminpanel.adminpanel.models.CartProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository extends JpaRepository<CartProductModel,Long> {
}
