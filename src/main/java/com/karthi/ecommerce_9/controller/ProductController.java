package com.karthi.ecommerce_9.controller;


import com.karthi.ecommerce_9.model.Product;
import com.karthi.ecommerce_9.repo.ProductRepo;
import com.karthi.ecommerce_9.service.ProductService;
import org.hibernate.boot.models.annotations.internal.OneToManyJpaAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {
    @Autowired
    ProductService productService;

//    Reading
    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        List<Product> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProduct(@PathVariable int id) {
        Product product = productService.getProductById(id).orElse(null);
        if(product == null){
            return new ResponseEntity<>("No Products Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

//    Create
    @PostMapping("/product")
    public ResponseEntity<?> saveProduct(@RequestPart Product product, MultipartFile image) {
        System.out.println(product);
        System.out.println(image);
       try{
           productService.saveProduct(product,image);
       }catch (Exception e){
           System.out.println(e.getMessage());
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
       return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    Delete
    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        Product existingProduct = productService.getProductById(id).orElse(null);
        if(existingProduct == null){
            return new ResponseEntity<>("No Products Found",HttpStatus.NOT_FOUND);
        }
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<?> getProductImage(@PathVariable int id) {
        Product product = productService.getProductById(id).orElse(null);
        if(product == null){
            return new ResponseEntity<>("No Products Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product.getImage(), HttpStatus.OK);
    }

//    Update
    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestPart Product product, MultipartFile image) {
        Product existingProduct = productService.getProductById(id).orElse(null);
        if(existingProduct == null){
            return new ResponseEntity<>("No Products Found",HttpStatus.NOT_FOUND);
        }
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setReleaseDate(product.getReleaseDate());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setStockQuantity(product.getStockQuantity());
        existingProduct.setAvailable(product.isAvailable());
        try{
            productService.updateProduct(existingProduct,image);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

    @GetMapping("/products/search")
    public ResponseEntity<?> getProductsByName(@RequestParam String keyword){
        System.out.println(keyword);
        return new ResponseEntity<>(productService.findByKeyword(keyword),HttpStatus.OK);
    }
}
