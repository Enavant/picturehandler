package com.pboot;

import com.pboot.util.bodyPost;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PbootApplication {

    public static void main(String[] args) {
 /*       String content="";
        bodyPost b=new bodyPost();
        b.transfbase64(content);

*/
        SpringApplication.run(PbootApplication.class, args);
    }

}
