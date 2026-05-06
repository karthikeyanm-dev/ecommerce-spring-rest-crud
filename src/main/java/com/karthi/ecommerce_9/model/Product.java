package com.karthi.ecommerce_9.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;

    public Product(int id, String name, String description, String brand, BigDecimal price, String category, Date releaseDate, boolean available, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.category = category;
        this.releaseDate = releaseDate;
        this.available = available;
        this.stockQuantity = stockQuantity;
    }

    private String category;
    private Date releaseDate;
    private boolean available;
    private int stockQuantity;
    private String imageName;
    private String imageType;

    @Lob
    private byte[] image;


}
