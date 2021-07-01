package com.test.springBoot.application.service;

import com.test.springBoot.application.dao.BrandRepository;
import com.test.springBoot.application.dao.TagsRepository;
import com.test.springBoot.application.model.Brand;
import com.test.springBoot.application.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public Brand findById(Integer brandId) {
        Optional<Brand> brand = brandRepository.findById(brandId);
        return brand.orElse(new Brand());
    }
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    public boolean saveBrand(String name) {
        Brand brand = brandRepository.findByName(name);

        if (brand != null) {
            return false;
        }

        Brand brand1 = new Brand();
        brand1.setName(name);
        brandRepository.save(brand1);
        return true;
    }
    public Brand findByName(String name) {
        return brandRepository.findByName(name);
    }

    public void editBrand(Integer brandId,String name) {
        Brand brand = findById(brandId);
        brand.setName(name);
        brandRepository.save(brand);
    }

    public void deleteBrand(Integer brandId) {

        brandRepository.deleteById(brandId);
    }
}
