package org.gestionRessources.biz.controller;

import java.util.List;
import java.util.Optional;

import org.gestionRessources.biz.beans.Converter;
import org.gestionRessources.biz.repository.IntProjets;
import org.gestionRessources.biz.repository.IntRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.common.Ressource;
import com.ibm.common.Projet;
import com.ibm.common.WrapperProjet;
import com.ibm.common.WrapperRessource;

@CrossOrigin("*")
@RestController
@RequestMapping
public class bridgeBiz {
	
	@Autowired
	IntProjets projets;
	
	@Autowired
	IntRessources ressources;
	
	@RequestMapping(value="/Hi",method=RequestMethod.POST)
	public String Hi() {
		return "Hello all works";
	}
	/*
	@RequestMapping(value = "/cnx",method = RequestMethod.POST)
	public void cnxPrezBiz(@RequestParam String msg){
		System.out.println("we made it this far");
		System.out.println("message "+msg);
	}
	
	@PostMapping(value = "/cnx2")
	@ResponseBody
	public void cnxPrezBiz2(@RequestBody String msg){
		System.out.println("we made it this far");
		System.out.println("message "+msg);
	}

	
	@GetMapping(value = "/getRessource")
	@ResponseBody
	public Ressource getRessource(){
		return new Ressource("youssef","jamoure","ZZ02122","2010-12-12");
	}
	
	@PostMapping(value = "/bizRessource")
	@ResponseBody
	public void afficherRessource(@RequestBody Ressource r){
		System.out.println("we made it this far");
		System.out.println(r);
	}
	*/
	
	//All for the RESSOURCE
	//-------------------------------------
	//-------------------------------------
	
	
	@GetMapping(value = "/getAllRessource")
	@ResponseBody
	public WrapperRessource getAllRessource(){
		return Converter.withOutAnnotation(ressources.findAll());
	}
	
	@GetMapping(value = "/getRessource/{id}")
	@ResponseBody
	public Ressource getRessource(@PathVariable Long id){
		Optional<org.gestionRessources.biz.beans.Ressource> ressource = ressources.findById(id);
		System.out.println(ressource);
		System.out.println(ressource.get().getId());
		return new Ressource(ressource.get().getId(),ressource.get().getNom(),ressource.get().getPrenom(),ressource.get().getRefog(),ressource.get().getDateAffectation().toString());
	}
	
	@PostMapping(value = "/addRessource")
	@ResponseBody
	public void addRessource(@RequestBody Ressource r){
		System.out.println("adding");
		ressources.save(Converter.withAnnotation(r));
	}
	
	/*@PostMapping(value = "/removeRessource")
	@ResponseBody
	public void removeRessource(@RequestBody Ressource r){
		System.out.println("in Biz "+r.getId());
		ressources.deleteById(r.getId());
	}*/
	
	@GetMapping(value = "/removeRessource/{id}")
	@ResponseBody
	public String removeRessource(@PathVariable Long id){
		System.out.println("in Biz "+id);
		ressources.deleteById(id);
		return "deleted";
	}
	
	
	//All for the PROJET
	//-------------------------------------
	//-------------------------------------
	
	
	@GetMapping(value = "/getAllProjet")
	@ResponseBody
	public WrapperProjet getAllprojet(){
		return Converter.withOutAnnotationProjet(projets.findAll());
	}
	
	@GetMapping(value = "/getProjet/{id}")
	@ResponseBody
	public Projet getprojet(@PathVariable Long id){
		Optional<org.gestionRessources.biz.beans.Projet> projet = projets.findById(id);
		System.out.println(projet);
		System.out.println(projet.get().getId());
		return new Projet(projet.get().getId(),projet.get().getNom(),Converter.withOutAnnotation(projet.get().getResponsable()),projet.get().getDateDebut().toString(),projet.get().getDateFin().toString());
	}
	
	@PostMapping(value = "/addProjet")
	@ResponseBody
	public void addProjet(@RequestBody Projet r){
		System.out.println("adding");
		projets.save(Converter.withAnnotation(r));
	}
	
	@GetMapping(value = "/removeProjet/{id}")
	@ResponseBody
	public String removeProjet(@PathVariable Long id){
		System.out.println("in Biz "+id);
		projets.deleteById(id);
		return "deleted";
		}
	
}
