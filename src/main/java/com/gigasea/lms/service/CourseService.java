package com.gigasea.lms.service;

import com.gigasea.lms.model.Course;


import com.gigasea.lms.model.Course;

import java.util.List;

public interface CourseService {
    void saveCourse(Course course);

    List<Course> findcourses();

    Course getCourseId(Long id);

    void deleteCourse(Long id);

    void deleteAllCourses();

    void addMaterialToCourse(Long courseId, String fileName);

    List<String> getMaterialsByCourseId(Long courseId);
}
