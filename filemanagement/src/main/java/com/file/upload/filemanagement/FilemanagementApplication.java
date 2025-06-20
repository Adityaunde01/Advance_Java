package com.file.upload.filemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.file.upload.filemanagement.component","com.file.upload.filemanagement.model"})
public class FilemanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilemanagementApplication.class, args);
	}

}
