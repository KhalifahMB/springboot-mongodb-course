package com.khalifahmb.springbootmongodb.service;

import com.khalifahmb.springbootmongodb.collection.Photo;

import org.springframework.web.multipart.MultipartFile;


public interface PhotoService {

    String addPhoto(String originalFilename, MultipartFile image);

	Photo getPhoto(String id);
    
}
