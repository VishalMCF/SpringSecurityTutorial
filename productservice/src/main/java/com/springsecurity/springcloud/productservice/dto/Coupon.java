package com.springsecurity.springcloud.productservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor
public class Coupon {
    private Long id;

    private String code;
    private BigDecimal discount;
    private String exp_date;
}
