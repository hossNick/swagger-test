package com.swagger.product.controller;

import com.swagger.product.service.BrandService;
import com.swagger.product.service.dto.BrandGetDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "brandApi",description = "create and update and getAll")
@RequestMapping("/api/v1/brand")
@RestController
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @Operation(summary = "create brand",description = "create brand by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "create successfully")
    })
    @PostMapping
    public int createBrand(@RequestParam("name") String name) {
        return brandService.createBrand(name);
    }

    @Operation(summary = "update brand",description = "update brand by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "create successfully"),
            @ApiResponse(responseCode = "404",description = "if id is wrong")
    })
    @PutMapping("/{id}")
    public BrandGetDto updateBrands(@PathVariable("id") Integer id, @RequestParam("name") String name) {
        return brandService.updateBrand(id, name);
    }

    @GetMapping
    public List<BrandGetDto> brandList() {
        return brandService.getAll();
    }
}
