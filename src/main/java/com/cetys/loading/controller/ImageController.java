package com.cetys.loading.controller;

import com.cetys.loading.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @GetMapping("/presigned-url")
    public String getPresignedUrl() {
        String bucketName = "your-bucket-name";
        String keyName = "your-object-key";
        return imageService.createPresignedGetUrl(bucketName, keyName);
    }
}
