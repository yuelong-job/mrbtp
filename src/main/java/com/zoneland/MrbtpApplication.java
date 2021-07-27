package com.zoneland;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.zoneland.**.mapper")
@ServletComponentScan
@EnableScheduling
public class MrbtpApplication {

	public static void main(String[] args) {
		SpringApplication.run(MrbtpApplication.class, args);
	}

}
