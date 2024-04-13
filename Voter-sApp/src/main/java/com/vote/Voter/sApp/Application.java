package com.vote.Voter.sApp;

import com.vote.Voter.sApp.pvc.dto.request.Register;
import com.vote.Voter.sApp.pvc.dto.response.RegisterResponse;
import com.vote.Voter.sApp.pvc.services.PvcService;
import com.vote.Voter.sApp.pvc.servicesImpl.PvcServiceImpl;
import com.vote.Voter.sApp.pvc.utils.GeneratePvcNumber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

}
