package com.swagger.product.controller;

import com.swagger.product.service.ProductGroupService;
import com.swagger.product.service.dto.ProductGroupGetDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "product group controller",description = "create and update ")
@RequestMapping("/api/v1/product-group")
@RestController
public class ProductGroupController {

    private final ProductGroupService productGroupService;

    public ProductGroupController(ProductGroupService productGroupService) {
        this.productGroupService = productGroupService;
    }

    @Operation(summary = "create product-group", description = "create product group by name")
    @ApiResponse(responseCode = "200",description = "create product group")
    @PostMapping
    public int createProductGroup(@RequestParam("name") String name){
        return productGroupService.createProductGroup(name);
    }

    @Operation(summary = "update product-group")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "find by id productGroup and update name"),
            @ApiResponse(responseCode = "404",description = "when id not found so throw exception with ==> {no productGroup for id}")
    })
    @PutMapping("/{id}")
    public ProductGroupGetDto updateProductGroup(@PathVariable("id") int id,@RequestParam String name){
        return productGroupService.updateProductGroup(id,name);
    }

    @GetMapping
    public List<ProductGroupGetDto> getAllProductGroup(){
        return productGroupService.getALl();
    }
}
