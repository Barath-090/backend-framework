package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
    @Autowired
    ProductService ps;

    @PostMapping("/postt")
    public ResponseEntity<product> add(@RequestBody product p) {
        product newuser = ps.create(p);
        return new ResponseEntity<>(newuser, HttpStatus.CREATED);
    }

    @GetMapping("/gett")
    public ResponseEntity<List<product>> show() {
        List<product> obj = ps.getAlldetails();
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping("/api/product/{productId}")
    public ResponseEntity<product> putMethodName(@PathVariable("productId") int id, @RequestBody product employee) {
        if (ps.updateDetails(id, employee) == true) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/api/product/{productId}")
    public ResponseEntity<Boolean> delete(@PathVariable("productId") int id) {
        if (ps.deleteUser(id) == true) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
