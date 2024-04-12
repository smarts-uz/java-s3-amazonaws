package org.example;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;

import java.io.File;
import java.util.List;
import java.io.IOException;
import java.io.FileOutputStream;

public class Main {

    static String accessKey = "5AB3b1QUDWqsjary";
    static String secretKey = "VKjOi0F8ctwNu9aVUeSstTDjH5Ema9yo8qkgq2cL";
    static String endpointUrl = "http://s3.tebi.io";
    static String region = "UZB";
    static String bucketName = "birikkiuch";
    static String bucketFilePath = "https://client.tebi.io/objects/birikkiuch";
    static String filePath = "D:\\JavaBackend\\SmartUz\\tebi.io\\src\\main\\java\\org\\example\\rasm\\16.jpg";

    public static void main(String[] args) {
        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpointUrl, region))
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .enablePathStyleAccess()
                .build();

        PutObjectRequest request = new PutObjectRequest(bucketName,secretKey, new File(filePath));
        request.setCannedAcl(CannedAccessControlList.PublicRead);


        s3Client.putObject(request);



//        Print the names of the objects
//        List<S3ObjectSummary> objectSummaries = s3Client.listObjects(bucketName).getObjectSummaries();
//        System.out.println("Objects in bucket " + bucketName + ":");
//        for (S3ObjectSummary objectSummary : objectSummaries) {
//            System.out.println("- " + objectSummary.getKey());
//        }


//        S3Object s3Object = s3Client.getObject(bucketName, bucketFilePath);
//
//        S3ObjectInputStream objectInputStream = s3Object.getObjectContent();
//
//// Save the object content to a local file
//        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath))) {
//            byte[] buffer = new byte[1024];
//            int bytesRead;
//            while ((bytesRead = objectInputStream.read(buffer)) != -1) {
//                fileOutputStream.write(buffer, 0, bytesRead);
//            }
//            System.out.println("File retrieved and saved successfully!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        S3Object s3Object = s3Client.getObject(new GetObjectRequest(bucketName,filePath));
//        S3ObjectInputStream objectInputStream = s3Object.getObjectContent();
//        byte[] buffer = new byte[1024];
//        int bytesRead = 0;
//        while (true){
//            try {
//                if ((bytesRead = objectInputStream.read(buffer)) == -1) break;
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("File retrivied and saved successfully");
//        }
    }
}