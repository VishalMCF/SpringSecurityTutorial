package com.springsecurity.springcloud.couponsservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter @Setter @NoArgsConstructor
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idsequence")
    @SequenceGenerator(name = "idsequence", sequenceName = "idsequence",
            allocationSize = 1,initialValue=1000)
    private Long id;

    private String code;
    private BigDecimal discount;
    private String exp_date;

}
