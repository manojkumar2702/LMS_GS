package com.gigasea.lms.service;

import com.gigasea.lms.model.Student;

import java.util.List;

public interface StudentService {
    void saveStudent(Student student);
    List<Student> findStudnets();
    Student getStudentId(Long id);
    void deleteSutdent(Long id);
    void deleteAllStudents();
    void addCourseToStudent(Long studentId, Long courseId);
}
