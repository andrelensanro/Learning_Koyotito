package com.koyotito.project.media;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService{

    String store(MultipartFile file, String medialocation);
    Resource loadAsResource(String filename);
    
}
