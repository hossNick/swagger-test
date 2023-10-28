package com.swagger.product.service;

import com.swagger.exceptions.BadRequestException;
import com.swagger.product.entity.Brand;
import com.swagger.product.service.dto.BrandGetDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrandService {

    private final Map<Integer, Brand> brands = new HashMap<>();

    public int createBrand(String name) {
        Brand brand = new Brand();
        brand.setName(name);
        brands.put(brand.getId(), brand);
        return brand.getId();
    }

    public BrandGetDto updateBrand(int brandId, String name) {
        Brand brand = getBrandById(brandId);
        brand.setName(name);
        brands.put(brandId, brand);
        return new BrandGetDto(brands.get(brandId));
    }

    public List<BrandGetDto> getAll() {
        List<BrandGetDto> brandGetDtos = new ArrayList<>();
        for (Integer i : brands.keySet()) {
            brandGetDtos.add(getBrandDto(i));
        }
        return brandGetDtos;
    }

    public BrandGetDto getBrandDto(int id) {
        return new BrandGetDto(getBrandById(id));
    }

    public Brand getBrandById(int id) {
        Brand brand = brands.get(id);
        if (brand == null) {
            throw new BadRequestException("no brand for " + id);
        }
        return brand;
    }

}
