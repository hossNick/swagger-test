package com.swagger.product.service;

import com.swagger.exceptions.BadRequestException;
import com.swagger.product.entity.Product;
import com.swagger.product.service.dto.ProductGetDto;
import com.swagger.product.service.dto.ProductPostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final BrandService brandService;
    private final ProductGroupService productGroupService;
    private final Map<Integer, Product> productMap = new HashMap<>();

    public int createProduct(ProductPostDto dto) {
        Product product = new Product();
        product.setBrand(brandService.getBrandById(dto.getBrandId()));
        product.setProductGroup(productGroupService.getProductGroup(dto.getProductGroupId()));
        productMap.put(product.getId(), product);
        return product.getId();
    }

    public ProductGetDto updateProduct(int id, ProductPostDto dto) {
        Product product = getById(id);
        product.setProductGroup(productGroupService.getProductGroup(dto.getProductGroupId()));
        product.setBrand(brandService.getBrandById(dto.getBrandId()));
        productMap.put(id, product);
        return new ProductGetDto(productMap.get(id));
    }

    public List<ProductGetDto> getAll(){
        List<ProductGetDto> all= new ArrayList<>();
        for (Integer i : productMap.keySet()) {
            all.add(getProductDtoById(i));
        }
        return all;
    }

    public ProductGetDto getProductDtoById(int id) {
        return new ProductGetDto(getById(id));
    }

    public Product getById(Integer id) {
        Product product = productMap.get(id);
        if (product == null) {
            throw new BadRequestException("no product for " + id);
        }
        return product;
    }

}
