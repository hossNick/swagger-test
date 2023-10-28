package com.swagger.product.controller;

import com.swagger.product.service.ProductService;
import com.swagger.product.service.dto.ProductGetDto;
import com.swagger.product.service.dto.ProductPostDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/product")
@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public int createProduct(@RequestBody ProductPostDto dto) {
        return productService.createProduct(dto);
    }

    @PutMapping("/{id}")
    public ProductGetDto updateProduct(@PathVariable("id") int id, @RequestBody ProductPostDto dto) {
        return productService.updateProduct(id, dto);
    }

    @GetMapping
    public List<ProductGetDto> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductGetDto getById(@PathVariable("id") int id) {
        return productService.getProductDtoById(id);
    }
}
