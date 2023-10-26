package com.systemnegro.controller;

import com.systemnegro.model.Course;
import com.systemnegro.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
