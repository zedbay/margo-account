package com.margo.tt.tt;

import com.margo.tt.tt.user.User;
import com.margo.tt.tt.user.UsersManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class TtApplication {

	public static void main(String[] args) {
		SpringApplication.run(TtApplication.class, args);
	}

}
