package com.springboot.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@Slf4j
public class UploadController {
    @GetMapping("/upload.html")
    public String uploadPage() {
        return "upload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("name") String name,
                         @RequestParam("email") String email,
                         @RequestParam("age") Integer age,
                         @RequestParam("job") String job,
                         @RequestPart("header") MultipartFile header,
                         @RequestPart("photos") MultipartFile[] photos) throws Exception {
        log.info("上传的信息：email={}，name={}，age={}, job={}, header={}，photos={}", email, name, age, job, header.getSize(), photos.length);
        if (!header.isEmpty()) {
//保存到文件服务器或者 OSS 服务器//需要先创建好 d:\\temp_upload 目录
            String originalFilename = header.getOriginalFilename();
//方式 1: 指定某个目录存放上传文件
            header.transferTo(new File("d:\\temp_upload\\" + originalFilename));
//方式 2: 动态的创建文件存放文件
//header.transferTo(new File(file.getAbsolutePath() + "/" + originalFilename));
        }
        if (photos.length > 0) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("d:\\temp_upload\\" + originalFilename));
//photo.transferTo(new File(file.getAbsolutePath() + "/" +originalFilename));
                }
            }
        }
        return "上传成功~~";
        }
    }

