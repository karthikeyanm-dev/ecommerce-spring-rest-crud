package com.karthi.ecommerce_9.service;

import com.karthi.ecommerce_9.model.Product;
import com.karthi.ecommerce_9.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    public List<Product> getProducts() {
        return  repo.findAll();
    }

    public long totalProducts() {
        return repo.count();
    }

    public Optional<Product> getProductById(int id) {
        return repo.findById(id);
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }

    public void saveProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImage(image.getBytes());
        repo.save(product);
    }

}
