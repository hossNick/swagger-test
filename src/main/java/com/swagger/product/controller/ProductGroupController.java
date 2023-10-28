package com.swagger.product.controller;

import com.swagger.product.service.ProductGroupService;
import com.swagger.product.service.dto.ProductGroupGetDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/product-group")
@RestController
public class ProductGroupController {

    private final ProductGroupService productGroupService;

    public ProductGroupController(ProductGroupService productGroupService) {
        this.productGroupService = productGroupService;
    }

    @PostMapping
    public int createProductGroup(@RequestParam("name") String name){
        return productGroupService.createProductGroup(name);
    }

    @PutMapping("/{id}")
    public ProductGroupGetDto updateProductGroup(@PathVariable("id") int id,@RequestParam String name){
        return productGroupService.updateProductGroup(id,name);
    }

    @GetMapping
    public List<ProductGroupGetDto> getAllProductGroup(){
        return productGroupService.getALl();
    }
}
