package com.test.springBoot.application.resource;

import com.test.springBoot.application.model.Brand;
import com.test.springBoot.application.model.Tag;
import com.test.springBoot.application.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @PostMapping
    public List<Tag> addTag(@RequestBody String name) {
        tagService.saveTag(name);

        return tagService.findAll();
    }

    @GetMapping
    public List<Tag> getAllTag() {
        return tagService.findAll();
    }

    @PostMapping("/editTag")
    public Tag edit(@RequestBody Short id, String name) {

        tagService.editTag(id, name);


        return tagService.findById(id);
    }

    @PostMapping("/deleteTag")
    public List<Tag> deleteTag(@RequestBody Short tagId) {
        tagService.deleteTag(tagId);

        return tagService.findAll();
    }

    @GetMapping("/findByName/{name}")
    public Tag findByName(@PathVariable String name) {
        return tagService.findByName(name);
    }

}
