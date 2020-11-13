package com.manel.formations;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.manel.formations.entities.Formation;
import com.manel.formations.service.FormationService;

@SpringBootApplication
public class FormationsApplication implements CommandLineRunner {
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	//FormationService formationService;
	public static void main(String[] args) {
	SpringApplication.run(FormationsApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	repositoryRestConfiguration.exposeIdsFor(Formation.class);
	}
	
//	@Override
//	public void run(String... args) throws Exception {
//		formationService.saveFormation(new Formation("data science","en ligne", 20.0, new Date()));
//		formationService.saveFormation(new Formation("spring boot","presentielle", 30.0, new Date()));
//		formationService.saveFormation(new Formation("python","en ligne",30.0, new Date()));
//	}

}
