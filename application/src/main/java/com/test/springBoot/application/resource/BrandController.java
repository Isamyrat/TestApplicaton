package com.test.springBoot.application.resource;

import com.test.springBoot.application.model.Brand;
import com.test.springBoot.application.model.Tag;
import com.test.springBoot.application.service.BrandService;
import com.test.springBoot.application.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping
    public List<Brand> addBrand(@RequestBody String name) {
        brandService.saveBrand(name);

        return brandService.findAll();
    }

    @GetMapping
    public List<Brand> getAllBrand() {
        return brandService.findAll();
    }
    @GetMapping("/findByName/{name}")
    public Brand findByName(@PathVariable String name) {
        return brandService.findByName(name);
    }
    @PostMapping("/editBrand")
    public Brand edit(@RequestBody Integer id, String name) {

        brandService.editBrand(id, name);


        return brandService.findById(id);
    }
    @PostMapping("/deleteBrand")
    public List<Brand> deleteBrand(@RequestBody Integer id) {
        brandService.deleteBrand(id);

        return brandService.findAll();
    }
}
