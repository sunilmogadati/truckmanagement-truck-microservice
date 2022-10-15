package com.truck.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class S3Config {

  @Value("${cloud.aws.credentials.access-key}")
  private String accessKey;

  @Value("${cloud.aws.credentials.secret-key}")
  private String secretKey;

  private String region = "us-west-1";

  @Primary
  @Bean
  public AmazonS3 s3Client() {
    AWSCredentials creds = new BasicAWSCredentials(accessKey, secretKey);
    return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(creds))
        .withRegion(region).build();
  }

}
