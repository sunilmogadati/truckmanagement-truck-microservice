package com.truck.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class S3Service {
  private final Logger log = LogManager.getLogger(this.getClass());
  
  @Value("${s3.bucket}")
  private String bucketName;
  @Autowired
  private AmazonS3 s3;
  
  public String upload(MultipartFile file) {
    String url = "https://truckmanagement.s3.us-west-1.amazonaws.com/Image/";

    // S3 IMAGE UPLOAD
    File fileObj = convertMultiPartFileToFile(file);
    String folder = "Image/";
    String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
    s3.putObject(new PutObjectRequest(bucketName, folder + fileName, fileObj));
    fileObj.delete();
    
    return url+fileName;
  };
  
  private File convertMultiPartFileToFile(MultipartFile file) {
    File convertedFile = new File(file.getOriginalFilename());
    try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
      fos.write(file.getBytes());
    } catch (IOException e) {
      log.error("Error converting multipartFile to file", e);
    }
    return convertedFile;
  }
  
  public void deleteFile(String fileName) {
    s3.deleteObject(bucketName, fileName);
  }
  
}
