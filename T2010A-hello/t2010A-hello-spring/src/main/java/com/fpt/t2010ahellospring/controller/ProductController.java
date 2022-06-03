package com.fpt.t2010ahellospring.controller;

import com.fpt.t2010ahellospring.entity.Product;
import com.fpt.t2010ahellospring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Product>> getList(){
        return ResponseEntity.ok(productService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Product product,@RequestParam int userId){
        Product product1 = new Product();
        product.setName(product.getName());
        product.setSlug(product.getSlug());
        product.setDescription(product.getDescription());
        product.setDetail(product.getDetail());
        product.setProducer(product.getProducer());
        product.setDeletedAt(product.getDeletedAt());
        product.setUserCreate(userId);
        product.setUserUpdate(product.getUserUpdate());
        product.setUserDelete(product.getUserDelete());
        product.setStatus(product.getStatus());
        return ResponseEntity.ok(productService.save(product));
    }

    @RequestMapping(method = RequestMethod.GET,path = "{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Product> optionalProduct =  productService.findById(id);
        if (!optionalProduct.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalProduct.get());
    }

    @RequestMapping(method = RequestMethod.PUT,path = "{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Product updateProduct,@RequestParam int userId){
        Optional<Product> optionalProduct =  productService.findById(id);
        if (!optionalProduct.isPresent()){
            ResponseEntity.badRequest().build();
        }
        Product product = optionalProduct.get();
        product.setName(updateProduct.getName());
        product.setSlug(updateProduct.getSlug());
        product.setDescription(updateProduct.getDescription());
        product.setDetail(updateProduct.getDetail());
        product.setProducer(updateProduct.getProducer());
        product.setDeletedAt(updateProduct.getDeletedAt());
        product.setUserCreate(updateProduct.getUserCreate());
        product.setUserUpdate(userId);
        product.setUserDelete(updateProduct.getUserDelete());
        product.setUpdatedAt(Date.from(Instant.now()));
        product.setStatus(product.getStatus());
        return ResponseEntity.ok(productService.save(product));
    }

    @RequestMapping(method = RequestMethod.PUT,path = "delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id,@RequestParam int userId){
        Optional<Product> optionalProduct =  productService.findById(id);
        if (!optionalProduct.isPresent()){
            ResponseEntity.badRequest().build();
        }
        Product product = optionalProduct.get();
        if (product.getStatus() == -1){
            ResponseEntity.badRequest().build();
        }
        product.setUserDelete(userId);
        product.setDeletedAt(Date.from(Instant.now()));
        product.setStatus(-1);
        return ResponseEntity.ok(productService.save(product));
    }

}
