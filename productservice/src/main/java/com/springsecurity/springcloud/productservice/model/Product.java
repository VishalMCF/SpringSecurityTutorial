package com.springsecurity.springcloud.productservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter @Setter @NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prsequence")
    @SequenceGenerator(name = "prsequence", sequenceName = "prsequence",
            allocationSize = 1,initialValue=1000)
    private Long id;

    private String description;
    private String name;
    private BigDecimal price;

    @Transient
    private String coupon;

}
