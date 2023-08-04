package edu.center.edu_center.Config;

import groovy.transform.stc.FirstParam;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public class InitConfig {
    public static boolean isStart(){
        Properties properties = new Properties();
        try {
            properties.load(new ClassPathResource("/application.properties").getInputStream());
            if (properties.getProperty("spring.jpa.hibernate.ddl-auto").equals("update")){
                return true;
            }else {
                String s = JOptionPane.showInputDialog( "Ma'lumotlarni o'chirib yubormoqchiligingizga anniq ishonchingiz komilmi siz creat-drop yoki createda turibsiz updatega o'tqazi qaytadan run bering");
                if (s != null && s.equals("0009792")){
                    return true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
