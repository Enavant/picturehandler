package com.pboot.util;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class OssUtil {



    public static String accessKey = "VTPM2FI0NHGGFP6C6FAY";
    public static String secretKey = "IA7lmEvUjocxOpKbmcHnOpkR151v5V60DjGO8VLe";
    public static String hostname = "http://eos-jinan-1.cmecloud.cn";


//创建桶方法
    public void  newbucket(){
        //移动云对象存储初始化
        ClientConfiguration opts = new ClientConfiguration();
        opts.setSignerOverride("S3SignerType");
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonS3Client client = new AmazonS3Client(credentials,opts);
        client.setEndpoint(hostname);

        String bucketName = "abcde";
         //创建桶
        CreateBucketRequest request = new CreateBucketRequest(bucketName);
        //默认权限是私有读写，设置成公共可读写
        request.setCannedAcl(CannedAccessControlList.PublicReadWrite);
        client.createBucket(request);
    }




    public void  newphotoes(){
        //移动云对象存储初始化
        ClientConfiguration opts = new ClientConfiguration();
        opts.setSignerOverride("S3SignerType");
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonS3Client client = new AmazonS3Client(credentials,opts);
        client.setEndpoint(hostname);

        //上传桶的名称
        String bucketName = "abcde";

        //设置为公共读写
        client.setBucketAcl(bucketName, CannedAccessControlList.PublicReadWrite);

        //上传本地图片
        String objectKey = "test5.png";
        client.putObject(bucketName, objectKey, new File("C:\\Users\\admin\\Desktop\\专利\\elk.png"));

        //设置Object ACL,方便url形式为hostname+buckname+objectKey
        client.setObjectAcl(bucketName, objectKey, CannedAccessControlList.PublicReadWrite);

    }




    public void  getPhotoesUrl(){

        //移动云对象存储初始化
        ClientConfiguration opts = new ClientConfiguration();
        opts.setSignerOverride("S3SignerType");
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonS3Client client = new AmazonS3Client(credentials,opts);
        client.setEndpoint(hostname);

        int num=0;
        //通过简单列举桶中object来计算数组长度
        ObjectListing obnum = client.listObjects("abcde");
        for (S3ObjectSummary s3ObjectSummary: obnum.getObjectSummaries()) {
            num++;
        }

        // 列出Object
        ObjectListing objects = client.listObjects("abcde");
        // 遍历所有Object
        System.out.println("Objects:");
        //建立字符串数组目的组成完整url,数组长度按照桶中对象数量来计算
        String uurl[]=new String[num];
        int i=0;
        for (S3ObjectSummary s3ObjectSummary: objects.getObjectSummaries()) {
            //输出每个对象名称
//        System.out.println(s3ObjectSummary.getKey());
            //组成url
            uurl[i]="http://http://eos-jinan-1.cmecloud.cn/abcde/"+s3ObjectSummary.getKey();
            i++;
        }


//// 遍历所有CommonPrefix
//System.out.println("\nCommonPrefixs:");
//for (String commonPrefix : objects.getCommonPrefixes()) {
//        System.out.println(commonPrefix);
//    }

//        遍历全部url
        for(int j =0;j<uurl.length;j++){
            System.out.println(uurl[j]);
        }

    }



//    public static void main(String[] args) {
//
//        
//    }



}



