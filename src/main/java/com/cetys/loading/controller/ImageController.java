package com.cetys.loading.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetys.loading.service.ImageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
@Tag(name = "Image Management", description = "APIs for managing image uploads and retrievals")
public class ImageController {
    private final ImageService imageService;

    @Operation(summary = "Get presigned URL", description = "Generates a presigned URL for accessing an image in S3")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully generated presigned URL"),
            @ApiResponse(responseCode = "400", description = "Invalid bucket or key name"),
            @ApiResponse(responseCode = "500", description = "Error generating presigned URL")
    })
    @GetMapping("/presigned-url")
    public String getPresignedUrl() {
        String bucketName = "your-bucket-name";
        String keyName = "your-object-key";
        return imageService.createPresignedGetUrl(bucketName, keyName);
    }
}
