package com.martijn.timvandersteenBackend.dao;

import com.martijn.timvandersteenBackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {

}