package com.pboot.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/tool",produces = "multipart/form-data")
public class bodyPost {
       @PostMapping("/img")
        public String transfbase64(String content){
/*        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);


        HttpEntity<String> request = new HttpEntity<>(content, headers);

        String url = "http://bz4m5k.natappfree.cc/zhangyongqi";
        ResponseEntity<String> postForEntity = restTemplate.postForEntity(url, request, String.class);

        String body = postForEntity.getBody();

        System.out.println(body);*/
                System.out.println(content);
            return "success";
    }


    }

