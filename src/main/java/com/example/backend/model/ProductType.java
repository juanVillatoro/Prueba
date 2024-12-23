package com.example.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product_types")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "freight_percentage", nullable = false)
    private Double freightPercentage;

    @Column(name = "import_fee_percentage", nullable = false)
    private Double importFeePercentage;

    @Column(name = "insurance_percentage", nullable = false)
    private Double insurancePercentage;

    @Column(name = "tax_percentage", nullable = false)
    private Double taxPercentage;

}
