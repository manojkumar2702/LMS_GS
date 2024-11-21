package com.gigasea.lms.controller;

import com.gigasea.lms.service.CourseService;
import com.gigasea.lms.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class FileUploadController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private CourseService courseService; // Service to handle course-related logic

    @PostMapping("/upload/{courseId}")
    public ResponseEntity<String> uploadFile(
            @PathVariable Long courseId,
            @RequestParam("file") MultipartFile file) {

        String fileName = fileStorageService.storeFile(file);

        // Associate the file with the course
        courseService.addMaterialToCourse(courseId, fileName);

        return ResponseEntity.ok("File uploaded successfully: " + fileName);
    }

    @GetMapping("/courses/{courseId}/notes")
    public ResponseEntity<List<String>> getCourseNotes(@PathVariable Long courseId) {
        List<String> notes = courseService.getMaterialsByCourseId(courseId);
        return ResponseEntity.ok(notes);
    }
}
