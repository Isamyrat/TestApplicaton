package com.test.springBoot.application.dao;

import com.test.springBoot.application.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepository extends JpaRepository<Tag, Short> {
        Tag findByName(String name);
}
