package com.jb.project2;

import com.jb.project2.utils.Art;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //Configuration + @ComponentScan(basePackages = "com.jb.project2")
public class Project2Application {

	public static void main(String[] args) {
		Art.START();
		SpringApplication.run(Project2Application.class, args);
		Art.END();
	}

}
