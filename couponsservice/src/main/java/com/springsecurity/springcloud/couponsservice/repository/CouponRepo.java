package com.springsecurity.springcloud.couponsservice.repository;

import com.springsecurity.springcloud.couponsservice.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepo extends JpaRepository<Coupon,Long> {
    Coupon findByCode(String code);
}
