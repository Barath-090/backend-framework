package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.product;
import com.example.demo.repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    ProductRepo pr;

    public product create(product pp) {
        return pr.save(pp);
    }

    public List<product> getAlldetails() {
        return pr.findAll();
    }

    public product getproductById(int id) {
        return pr.findById(id).orElse(null);
    }

    public boolean updateDetails(int id, product p) {
        if (this.getproductById(id) == null) {
            return false;
        }
        try {
            pr.save(p);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean deleteUser(int id) {
        if (this.getproductById(id) == null) {
            return false;
        }
        pr.deleteById(id);
        return true;
    }
}
