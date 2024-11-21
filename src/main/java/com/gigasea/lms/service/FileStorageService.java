package com.gigasea.lms.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {

    private final Path fileStoragePath;

    public FileStorageService(@Value("${file.upload-dir}") String uploadDir) {
        this.fileStoragePath = Paths.get(uploadDir).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStoragePath);
        } catch (IOException e) {
            throw new RuntimeException("Could not create file storage directory.", e);
        }
    }

    public String storeFile(MultipartFile file) {
        try {
            Path targetLocation = this.fileStoragePath.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), targetLocation);
            return file.getOriginalFilename();
        } catch (IOException ex) {
            throw new RuntimeException("Failed to store file. Please try again!", ex);
        }
    }
}
