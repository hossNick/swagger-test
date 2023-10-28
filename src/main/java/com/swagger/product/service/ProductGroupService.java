package com.swagger.product.service;

import com.swagger.exceptions.BadRequestException;
import com.swagger.product.entity.ProductGroup;
import com.swagger.product.service.dto.ProductGroupGetDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductGroupService {

    private final Map<Integer, ProductGroup> productGroupMap = new HashMap<>();

    public int createProductGroup(String name) {
        ProductGroup productGroup = new ProductGroup();
        productGroup.setName(name);
        productGroupMap.put(productGroup.getId(), productGroup);
        return productGroup.getId();
    }

    public ProductGroupGetDto updateProductGroup(int id, String name) {
        ProductGroup productGroup = getProductGroup(id);
        productGroup.setName(name);
        productGroupMap.put(id, productGroup);
        return new ProductGroupGetDto(productGroupMap.get(id));
    }

    public List<ProductGroupGetDto> getALl() {
        List<ProductGroupGetDto> productGroupGetDtoList = new ArrayList<>();
        for (Integer i : productGroupMap.keySet()) {
            productGroupGetDtoList.add(getProductGroupDto(i));
        }
        return productGroupGetDtoList;
    }

    public ProductGroupGetDto getProductGroupDto(int id) {
        return new ProductGroupGetDto(getProductGroup(id));
    }

    public ProductGroup getProductGroup(int id) {
        ProductGroup productGroup = productGroupMap.get(id);
        if (productGroup == null) {
            throw new BadRequestException("no productGroup for " + id);
        }
        return productGroup;
    }
}
