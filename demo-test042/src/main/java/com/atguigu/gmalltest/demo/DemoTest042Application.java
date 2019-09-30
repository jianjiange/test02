package com.atguigu.gmalltest.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.atguigu.gmalltest.demo.mapper")
public class DemoTest042Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoTest042Application.class, args);
	}

}
