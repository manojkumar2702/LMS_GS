package com.gigasea.lms.controller;

import com.gigasea.lms.model.Course;
import com.gigasea.lms.model.Student;
import com.gigasea.lms.service.CourseService;
import com.gigasea.lms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @GetMapping("/students") //End Point
    public String students(Model model){
        model.addAttribute("students", studentService.findStudnets());
        return "students"; //HTML File
    }
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student")Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/registerStudent") //End point
    public String registerStudent(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "registerStudent";
    }
    @GetMapping("/updateStudent/{id}")
    public String updateStudent(Model model, @PathVariable Long id){
        Student student = studentService.getStudentId(id);
        model.addAttribute("student", student);
        return "updateStudent";
    }
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteSutdent(id);
        return "redirect:/students";
    }
    @GetMapping("/assignCourse")
    public String showAssignCourseForm(Model model){
        List<Course> courses =courseService.findcourses();
        List<Student> students = studentService.findStudnets();
        model.addAttribute("courses", courses);
        model.addAttribute("students", students);
        return "assignCourse";
    }
    @PostMapping("/addCourseToStudent")
    public String addCourseToStudent(@RequestParam Long studentId, @RequestParam Long courseId){
        studentService.addCourseToStudent(studentId,courseId);
        return "redirect:/students";
    }
    @GetMapping("/studentsWithCourses")
    public String studentWithCourses(Model model){
        List<Student> students = studentService.findStudnets();
        model.addAttribute("students", students);
        return "studentsWithCourses";
    }
}
