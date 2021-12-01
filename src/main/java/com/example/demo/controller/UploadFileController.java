package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Slf4j
@Controller
public class UploadFileController {

    @Value("${file.upload.path}")
    private String path;

    @GetMapping("/uploadPage")
    public String uploadPage() {
        return "upload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String create(@RequestPart MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String filePath = path + fileName;

        File dest = new File(filePath);
        Files.copy(file.getInputStream(), dest.toPath());
        return "Upload file success : " + dest.getAbsolutePath();
    }


    @GetMapping("/multiUploadPage")
    public String multiUploadPage() {
        return "multi_upload";
    }

    @PostMapping("/multiUpload")
    @ResponseBody
    public String create(@RequestPart MultipartFile[] files) throws IOException {
        StringBuffer message = new StringBuffer();

        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            String filePath = path + fileName;

            File dest = new File(filePath);
            Files.copy(file.getInputStream(), dest.toPath());
            message.append("Upload file success : " + dest.getAbsolutePath()).append("<br>");
        }
        return message.toString();
    }

}