package com.josephdias92.searchandlisting.repository;

import com.josephdias92.searchandlisting.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    @Query("{id: ?0}")
    Optional<Product> findById(String id);
}
