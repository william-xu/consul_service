package cn.xwl.demo.consulservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({AppConfig.class})
public class ConsulDemoApplication {

    public static void main(String[] args) {
    	SpringApplication.run(ConsulDemoApplication.class, args);
    }

}
