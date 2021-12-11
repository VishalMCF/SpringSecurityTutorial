package com.springsecurity.springcloud.productservice.repository;

import com.springsecurity.springcloud.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepo extends JpaRepository<Product,Long> {
}
