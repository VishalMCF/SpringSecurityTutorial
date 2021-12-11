package com.springsecurity.springcloud.couponsservice.controller;


import com.springsecurity.springcloud.couponsservice.model.Coupon;
import com.springsecurity.springcloud.couponsservice.repository.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupon/api")
public class CouponController {

    @Autowired
    CouponRepo couponRepo;

    @GetMapping("/")
    public String CouponWelcome(){
        return "Welcome this is coupon service";
    }

    @PostMapping(value="/coupons")
    public Coupon Couponcreate(@RequestBody Coupon coupon){
        return couponRepo.save(coupon);
    }

    @GetMapping(value = "/coupons/{code}")
    public Coupon getCOupon(@PathVariable("code") String code){
        return couponRepo.findByCode(code);
    }

    @GetMapping(value = "/coupons")
    public List<Coupon> getAllCoupons(){
        return couponRepo.findAll();
    }

}
