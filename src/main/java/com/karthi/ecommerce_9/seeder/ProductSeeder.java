package com.karthi.ecommerce_9.seeder;

import com.karthi.ecommerce_9.model.Product;
import com.karthi.ecommerce_9.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductSeeder implements CommandLineRunner {

    @Autowired
    ProductRepo repo;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(0, "iPhone 14", "Latest Apple smartphone with A15 chip",
                "Apple", new BigDecimal("79999"), "Mobile",
                sdf.parse("01-09-2023"), true, 50));

        products.add(new Product(0, "Galaxy S23", "Flagship Samsung device with Snapdragon processor",
                "Samsung", new BigDecimal("74999"), "Mobile",
                sdf.parse("01-02-2023"), true, 40));

        products.add(new Product(0, "Pixel 8", "Google phone with best camera and AI features",
                "Google", new BigDecimal("68999"), "Mobile",
                sdf.parse("10-10-2023"), true, 35));

        products.add(new Product(0, "OnePlus 11", "High performance phone with fast charging",
                "OnePlus", new BigDecimal("61999"), "Mobile",
                sdf.parse("04-01-2023"), true, 45));

        products.add(new Product(0, "Redmi Note 13", "Budget-friendly phone with solid features",
                "Xiaomi", new BigDecimal("18999"), "Mobile",
                sdf.parse("15-09-2023"), true, 100));

        products.add(new Product(0, "Realme GT Neo", "Gaming-focused smartphone with high refresh rate",
                "Realme", new BigDecimal("25999"), "Mobile",
                sdf.parse("20-07-2023"), true, 60));

        products.add(new Product(0, "Vivo V29", "Stylish phone with strong camera performance",
                "Vivo", new BigDecimal("32999"), "Mobile",
                sdf.parse("10-08-2023"), true, 55));

        products.add(new Product(0, "Oppo Reno 10", "Premium design with excellent portrait camera",
                "Oppo", new BigDecimal("34999"), "Mobile",
                sdf.parse("01-06-2023"), true, 70));

        products.add(new Product(0, "Oppo Reno 10", "Premium design with excellent portrait camera",
                "Oppo", new BigDecimal("34999"), "Mobile",
                sdf.parse("01-06-2023"), true, 70));

        products.add(new Product(0, "Oppo Reno 10", "Premium design with excellent portrait camera",
                "Oppo", new BigDecimal("34999"), "Mobile",
                sdf.parse("01-06-2023"), true, 70));


        if(repo.count() > 0){
            System.out.println("Skipping the seeding process...");
            return;
        }
        repo.saveAll(products);
        System.out.println("No products found");
        System.out.println("So Products Seeded");

    }
}
