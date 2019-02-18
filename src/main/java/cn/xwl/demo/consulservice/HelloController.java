package cn.xwl.demo.consulservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Autowired
	DbConfig config;
	
	@Autowired
	AppConfig appConfig;
	
    @RequestMapping("/hello")
    public String home() {    	
    	System.out.println(appConfig.getSpringDatasourceUrl());
        return "Hello " + config.getUsername();
    }
}
