package org.irvin.ManageUserGroups;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.irvin"})
public class UserGroupManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserGroupManagementApplication.class, args);
	}
}
