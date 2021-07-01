package com.test.springBoot.application.dao;

import com.test.springBoot.application.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    Brand findByName(String name);
}
