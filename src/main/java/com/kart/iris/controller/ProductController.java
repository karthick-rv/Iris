package com.kart.iris.controller;


import com.kart.iris.model.Product;
import com.kart.iris.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductController {

    ProductService service;

    @Autowired
    public ProductController(ProductService service){
        this.service = service;
    }


    @RequestMapping("/greet")
    public String greet(){
        return "Welcome Karthick";
    }


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }


    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct( @PathVariable int id){

        Product product = service.getProductById(id);

        if(product!=null){
            return new ResponseEntity<>(product, HttpStatus.OK) ;
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
