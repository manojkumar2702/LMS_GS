package com.gigasea.lms.service;

import com.gigasea.lms.model.Course;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CourseServiceImpl implements CourseService {

    // Mock database for courses
    private final Map<Long, Course> courses = new HashMap<>();

    // Mock database for course materials
    private final Map<Long, List<String>> courseMaterials = new HashMap<>();

    @Override
    public void saveCourse(Course course) {
        courses.put(course.getId(), course);
    }

    @Override
    public List<Course> findcourses() {
        return new ArrayList<>(courses.values());
    }

    @Override
    public Course getCourseId(Long id) {
        return courses.get(id);
    }

    @Override
    public void deleteCourse(Long id) {
        courses.remove(id);
        courseMaterials.remove(id); // Remove materials associated with the course
    }

    @Override
    public void deleteAllCourses() {
        courses.clear();
        courseMaterials.clear();
    }

    @Override
    public void addMaterialToCourse(Long courseId, String fileName) {
        courseMaterials.computeIfAbsent(courseId, k -> new ArrayList<>()).add(fileName);
    }

    @Override
    public List<String> getMaterialsByCourseId(Long courseId) {
        return courseMaterials.getOrDefault(courseId, new ArrayList<>());
    }
}
