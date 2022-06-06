package com.example.validation.service;

import com.example.validation.exception.NoDataFoundException;
import com.example.validation.exception.ProductNotFoundException;
import com.example.validation.model.Product;
import com.example.validation.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        List<Product> products = repository.findAll();
        if (products.isEmpty()) throw new NoDataFoundException();
        return products;
    }

    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Product create(Product product) {
        return repository.save(product);
    }
}
