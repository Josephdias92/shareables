package com.josephdias92.searchandlisting.controller;

import com.josephdias92.searchandlisting.dto.ProductDto;
import com.josephdias92.searchandlisting.model.Product;
import com.josephdias92.searchandlisting.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    final private ProductRepository productRepository;

    @PostMapping()
    public ResponseEntity<ProductDto> add(ProductDto productDto) {
        Product product = Product.builder()
                .category(productDto.getCategory())
                .description(productDto.getDescription())
                .howOld(productDto.getHowOld())
                .maxDaysToRent(productDto.getMaxDaysToRent())
                .name(productDto.getName())
                .rent(productDto.getRent())
                .build();
        Product p = productRepository.insert(product);

        return ResponseEntity.ok(productDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findProduct(@PathVariable String id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            ProductDto productDto = ProductDto.builder()
                    .category(product.getCategory())
                    .description(product.getDescription())
                    .howOld(product.getHowOld())
                    .maxDaysToRent(product.getMaxDaysToRent())
                    .name(product.getName())
                     .rent(product.getRent())
                    .build();
            return ResponseEntity.ok(productDto);
        } else {
            // Handle product not found case
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> findAll() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> p = products.stream().map(product-> ProductDto.builder()
                .category(product.getCategory())
                .description(product.getDescription())
                .howOld(product.getHowOld())
                .maxDaysToRent(product.getMaxDaysToRent())
                .name(product.getName())
                .rent(product.getRent())
                .build()).collect(Collectors.toList());
        return ResponseEntity.ok(p);

    }


}
