package org.gestionRessources.biz.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.gestionRessources.biz.beans.Projet;
import org.gestionRessources.biz.beans.Ressource;
import org.gestionRessources.biz.repository.IntProjets;
import org.gestionRessources.biz.repository.IntRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;


@Component
public class Seed {

	@Autowired
	IntRessources reassources;

	@Autowired
	IntProjets projets;

	@PostConstruct
	public void seed() {
		//creat the feaker and list of entities
		Faker faker = new Faker();
		List<Ressource> fakedRessources = new ArrayList<Ressource>();
		List<Projet> fakedProjets = new ArrayList<Projet>();
		
		//creating 'Ressources'
		for (int i = 0; i < 3; i++) {
			Ressource resource = new Ressource(faker.name().firstName(), faker.name().lastName(),
					"ZZ"+faker.number().numberBetween(1000, 2999), faker.date().birthday());
			fakedRessources.add(resource);
		}
		
		//Adding 'Ressources' to the data base
		reassources.saveAll(fakedRessources);
		//Geting 'Ressouces' from data base to get the auto generated ID
		fakedRessources = reassources.findAll();
		
		//for each 'Ressource' we create 3 projects
		for (Ressource responsable : fakedRessources) {
			for (int i = 0; i < 3; i++) {

				Projet projet = new Projet("PR"+faker.number().numberBetween(111, 245),responsable,new Date(),new Date());
				fakedProjets.add(projet);
			}
		}
		
		//Adding the 'Projects' o the database
		projets.saveAll(fakedProjets);
	}
}
