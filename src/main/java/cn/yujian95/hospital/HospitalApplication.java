package cn.yujian95.hospital;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HospitalApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

}
