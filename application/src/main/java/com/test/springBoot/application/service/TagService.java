package com.test.springBoot.application.service;

import com.test.springBoot.application.dao.TagsRepository;
import com.test.springBoot.application.model.Device;
import com.test.springBoot.application.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TagService {
    @Autowired
    private TagsRepository tagsRepository;

    public Tag findById(Short tagId) {
        Optional<Tag> tag = tagsRepository.findById(tagId);
        return tag.orElse(new Tag());
    }
    public List<Tag> findAll() {
        return tagsRepository.findAll();
    }

    public boolean saveTag(String name) {
        Tag tag1 = tagsRepository.findByName(name);

        if (tag1 != null) {
            return false;
        }

        Tag tag = new Tag();
        tag.setName(name);
        tagsRepository.save(tag);
        return true;
    }
    public Tag findByName(String name) {
        return tagsRepository.findByName(name);
    }
    public void editTag(Short tagId,String name) {
        Tag tag = findById(tagId);
        tag.setName(name);
        tagsRepository.save(tag);
    }

    public void deleteTag(Short tagId) {
        tagsRepository.deleteById(tagId);
    }


    public void deleteDeviceTag(Short tagId, Long deviceId) {
        Tag tag = findById(tagId);
        Set<Device> tagDevice = tag.getDeviceTag();

        tagDevice.removeIf(s -> s.getId().equals(deviceId));
    }
}
