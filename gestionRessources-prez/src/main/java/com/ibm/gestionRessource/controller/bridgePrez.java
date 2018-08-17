package com.ibm.gestionRessource.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.common.Projet;
import com.ibm.common.ProjetFormulaire;
import com.ibm.common.Ressource;
import com.ibm.common.WrapperProjet;
import com.ibm.common.WrapperRessource;

@Controller
public class bridgePrez {

	@RequestMapping(value = "/Hi", method = RequestMethod.GET)
	public ModelAndView Hi() {
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("response", "Hi");
		return mv;
	}

	/*
	 * @RequestMapping(value="/toBiz",method=RequestMethod.GET) public void
	 * toBiz() { SimpleClientHttpRequestFactory requestFactory = new
	 * SimpleClientHttpRequestFactory(); RestTemplate restTemplate = new
	 * RestTemplate(requestFactory); String url = "http://localhost:8080/cnx";
	 * System.out.println("works till now"); ResponseEntity<String> response =
	 * restTemplate.postForEntity(url,"from Prez",String.class);
	 * System.out.println(response); }
	 * 
	 * @RequestMapping(value="/toBiz2",method=RequestMethod.GET) public void
	 * toBiz2() { SimpleClientHttpRequestFactory requestFactory = new
	 * SimpleClientHttpRequestFactory(); RestTemplate restTemplate = new
	 * RestTemplate(requestFactory); String url = "http://localhost:8080/cnx2";
	 * System.out.println("works till now");
	 * restTemplate.postForObject(url,"from Prez",String.class); }
	 * 
	 * @RequestMapping(value="/getRessource",method=RequestMethod.GET) public
	 * void toBiz3() { SimpleClientHttpRequestFactory requestFactory = new
	 * SimpleClientHttpRequestFactory(); RestTemplate restTemplate = new
	 * RestTemplate(requestFactory); String url =
	 * "http://localhost:8080/getRessource";
	 * System.out.println("works till now"); ResponseEntity<Ressource> response
	 * = restTemplate.getForEntity(url,Ressource.class); Ressource r =
	 * response.getBody(); System.out.println(r); }
	 * 
	 * @RequestMapping(value="/afficheRessource",method=RequestMethod.GET)
	 * public void toBiz4() { SimpleClientHttpRequestFactory requestFactory =
	 * new SimpleClientHttpRequestFactory(); RestTemplate restTemplate = new
	 * RestTemplate(requestFactory); String url =
	 * "http://localhost:8080/bizRessource";
	 * System.out.println("works till now"); restTemplate.postForObject(url,new
	 * Ressource("youssef","jamoure","ZZ02122","2010-12-12"),Ressource.class); }
	 */
	// -----------------------------------
	/*
	 * @RequestMapping(value="/addRessource",method=RequestMethod.GET) public
	 * void addRessource() { SimpleClientHttpRequestFactory requestFactory = new
	 * SimpleClientHttpRequestFactory(); RestTemplate restTemplate = new
	 * RestTemplate(requestFactory); String url =
	 * "http://localhost:8080/addRessource";
	 * System.out.println("works till now"); restTemplate.postForObject(url,new
	 * Ressource("youssef","jamoure","ZZ02122","2010-12-12"),Ressource.class); }
	 */
	// -----------------------------------

	// All for the RESSOURCE
	// -------------------------------
	// -------------------------------

	@RequestMapping(value = "/addRessource", method = RequestMethod.POST)
	public String addRessource(@ModelAttribute Ressource r) {
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		String url = "http://localhost:8080/addRessource";
		System.out.println("adding");
		restTemplate.postForObject(url, r, Ressource.class);
		System.out.println("added");
		return "redirect:/getRessource";
	}

	@RequestMapping(value = "/getRessource", method = RequestMethod.GET)
	public ModelAndView getAllRessource() {
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		String url = "http://localhost:8080/getAllRessource";
		ResponseEntity<WrapperRessource> response = restTemplate.getForEntity(url, WrapperRessource.class);
		WrapperRessource objects = response.getBody();
		ModelAndView mv = new ModelAndView("listRessource");
		mv.addObject("ressources", objects.getList());
		return mv;
	}

	/*
	 * @RequestMapping(value = "/removeRessource/{id}", method =
	 * RequestMethod.GET) public String addRessource(@PathVariable Long id) {
	 * System.out.println("in prez "+id); SimpleClientHttpRequestFactory
	 * requestFactory = new SimpleClientHttpRequestFactory(); RestTemplate
	 * restTemplate = new RestTemplate(requestFactory); String url =
	 * "http://localhost:8080/removeRessource"; restTemplate.postForObject(url,
	 * new Ressource(id), Ressource.class); System.out.println("after prez ");
	 * return "redirect:/getRessource"; }
	 */
	@RequestMapping(value = "/removeRessource/{id}", method = RequestMethod.GET)
	public String addRessource(@PathVariable Long id) {
		System.out.println("in prez " + id);
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		String url = "http://localhost:8080/removeRessource/" + id;
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		System.out.println("after prez ,  " + response.getBody());
		return "redirect:/getRessource";
	}

	@RequestMapping(value = "/getRessource/{id}", method = RequestMethod.GET)
	public ModelAndView getRessourceToUpdate(@PathVariable Long id) {
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		// to get all ressources
		String url = "http://localhost:8080/getAllRessource";
		ResponseEntity<WrapperRessource> response = restTemplate.getForEntity(url, WrapperRessource.class);
		WrapperRessource objects = response.getBody();
		// to get the want to update ressource
		url = "http://localhost:8080/getRessource/" + id;
		ResponseEntity<Ressource> responseUpdate = restTemplate.getForEntity(url, Ressource.class);
		Ressource object = responseUpdate.getBody();
		// adding objects and object
		ModelAndView mv = new ModelAndView("listRessource");
		mv.addObject("ressources", objects.getList());
		mv.addObject("ressource", object);
		System.out.println("calling ... ");
		return mv;
	}

	// All for the PROJET
	// -------------------------------
	// -------------------------------

	@RequestMapping(value = "/addProjet", method = RequestMethod.POST)
	public String addProjet(@ModelAttribute ProjetFormulaire p) {
		System.out.println("projet "+p);
		
		//Getting Project Ready
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		String url = "http://localhost:8080/addProjet";
		System.out.println("adding");
		
		//Getting Responsable as Object
		String urlResponsable = "http://localhost:8080/getRessource/" + p.getResponsable();
		ResponseEntity<Ressource> responseUpdate = restTemplate.getForEntity(urlResponsable, Ressource.class);
		Ressource responsable = responseUpdate.getBody();
		System.out.println("responsable "+responsable);
		
		//Adding Responsable to project
		Projet projet = new Projet(p.getId(),p.getNom(), responsable, p.getDateDebut(), p.getDateFin());
		
		restTemplate.postForObject(url, projet, Projet.class);
		System.out.println("added");
		return "redirect:/getProjet";
	}

	@RequestMapping(value = "/getProjet", method = RequestMethod.GET)
	public ModelAndView getAllProjet() {
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		//Get Projets
		String url = "http://localhost:8080/getAllProjet";
		ResponseEntity<WrapperProjet> responseProjet = restTemplate.getForEntity(url, WrapperProjet.class);
		WrapperProjet objectsProjet = responseProjet.getBody();
		System.out.println("List of Projects "+objectsProjet.getList());
		//Get Ressources
		url = "http://localhost:8080/getAllRessource";
		ResponseEntity<WrapperRessource> responseRessource = restTemplate.getForEntity(url, WrapperRessource.class);
		WrapperRessource objectsRessource = responseRessource.getBody();
		ModelAndView mv = new ModelAndView("listProjet");
		mv.addObject("projets", objectsProjet.getList());
		mv.addObject("ressources", objectsRessource.getList());
		return mv;
	}

	/*
	 * @RequestMapping(value = "/removeRessource/{id}", method =
	 * RequestMethod.GET) public String addRessource(@PathVariable Long id) {
	 * System.out.println("in prez "+id); SimpleClientHttpRequestFactory
	 * requestFactory = new SimpleClientHttpRequestFactory(); RestTemplate
	 * restTemplate = new RestTemplate(requestFactory); String url =
	 * "http://localhost:8080/removeRessource"; restTemplate.postForObject(url,
	 * new Ressource(id), Ressource.class); System.out.println("after prez ");
	 * return "redirect:/getRessource"; }
	 */
	@RequestMapping(value = "/removeProjet/{id}", method = RequestMethod.GET)
	public String addProjet(@PathVariable Long id) {
		System.out.println("in prez " + id);
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		String url = "http://localhost:8080/removeProjet/" + id;
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		System.out.println("after prez ,  " + response.getBody());
		return "redirect:/getProjet";
	}

	@RequestMapping(value = "/getProjet/{id}", method = RequestMethod.GET)
	public ModelAndView getProjetToUpdate(@PathVariable Long id) {
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		// to get all Projets
				String url = "http://localhost:8080/getAllProjet";
				ResponseEntity<WrapperProjet> response = restTemplate.getForEntity(url, WrapperProjet.class);
				WrapperProjet objects = response.getBody();
		// to get the want to update Projets
				url = "http://localhost:8080/getProjet/" + id;
				ResponseEntity<Projet> responseUpdate = restTemplate.getForEntity(url, Projet.class);
				Projet object = responseUpdate.getBody();
		// to get ressources
		//Get Ressources
				url = "http://localhost:8080/getAllRessource";
				ResponseEntity<WrapperRessource> responseRessource = restTemplate.getForEntity(url, WrapperRessource.class);
				WrapperRessource objectsRessource = responseRessource.getBody();
		// adding objects and object
				ModelAndView mv = new ModelAndView("listProjet");
				mv.addObject("projets", objects.getList());
				mv.addObject("projet", object);
				mv.addObject("ressources", objectsRessource.getList());
				System.out.println("calling ... ");
		return mv;
	}
}
