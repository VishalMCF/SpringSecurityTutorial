package com.springsecurity.springcloud.productservice.controller;

import com.springsecurity.springcloud.productservice.dto.Coupon;
import com.springsecurity.springcloud.productservice.model.Product;
import com.springsecurity.springcloud.productservice.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product/api")
public class ProductController {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${couponService.url}")
    private String couponServiceUrl;

    @GetMapping("/")
    public String productWelcome(){
        return "Welcome this is Product service";
    }

    @PostMapping(value="/products")
    public Product createProduct(@RequestBody Product product)
    {
        System.out.println(product.getCoupon());
        Coupon coupon  = restTemplate.getForObject(couponServiceUrl+product.getCoupon(), Coupon.class);

        product.setPrice(product.getPrice().subtract(coupon.getDiscount().multiply(product.getPrice().divide(new BigDecimal(100)))));
        return productRepo.save(product);
    }

    @GetMapping("/products/{id}")
    public Optional<Product> getProductById(@PathVariable("id") Long id){
        return productRepo.findById(id);
    }

    @GetMapping(value = "/products")
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

}
