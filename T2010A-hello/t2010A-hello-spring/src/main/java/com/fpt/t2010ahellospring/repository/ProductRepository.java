package com.fpt.t2010ahellospring.repository;

import com.fpt.t2010ahellospring.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
}