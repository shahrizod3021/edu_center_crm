package edu.center.edu_center;

import edu.center.edu_center.Config.InitConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EduCenterApplication {

    public static void main(String[] args) {
        if (InitConfig.isStart()) {
            SpringApplication.run(EduCenterApplication.class, args);
        }else {
            System.err.println("parol hato qayta urun gaday");
        }
    }

}
