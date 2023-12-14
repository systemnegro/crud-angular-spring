package com.systemnegro.controller;

import com.systemnegro.model.Course;
import com.systemnegro.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    private final CourseRepository courseRepository;
    @GetMapping
    public List<Course> list() {
        return courseRepository.findAll();
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course create (@RequestBody Course course){
        return courseRepository.save(course);
    }
}

