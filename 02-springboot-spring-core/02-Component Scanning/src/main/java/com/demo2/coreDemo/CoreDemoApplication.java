package com.demo2.coreDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// explicitly list base packages to scan
@SpringBootApplication(scanBasePackages = {"com.demo2coreDemo","com.demoCore"} )

)

public class CoreDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreDemoApplication.class, args);
	}

}
