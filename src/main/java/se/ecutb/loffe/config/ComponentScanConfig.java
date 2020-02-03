package se.ecutb.loffe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan("se.ecutb.loffe")
public class ComponentScanConfig {

    @Bean
    public Scanner Scanner(){
        return new Scanner(System.in);
    }




}
