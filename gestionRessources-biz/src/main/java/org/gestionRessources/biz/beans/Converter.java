package org.gestionRessources.biz.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.ibm.common.WrapperProjet;
import com.ibm.common.WrapperRessource;

public class Converter {
	
	
	public static  com.ibm.common.Ressource withOutAnnotation(Ressource r){
		return new com.ibm.common.Ressource(r.getId(), r.getNom(), r.getPrenom(), r.getRefog(), r.getDateAffectation().toString());
	}
	
	public static  com.ibm.common.Projet withOutAnnotation(Projet r){
		return new com.ibm.common.Projet(r.getId(), r.getNom(), withOutAnnotation(r.getResponsable()),r.getDateDebut().toString(),r.getDateFin().toString());
	}
	
	@SuppressWarnings("deprecation")
	public static  Ressource withAnnotation(com.ibm.common.Ressource r){
		System.out.println("converter " +r);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateAffectaion = new Date();
        try {
        	dateAffectaion = formatter.parse(r.getDateAffectation());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Ressource(r.getId(), r.getNom(), r.getPrenom(), r.getRefog(), dateAffectaion);
	}
	
	@SuppressWarnings("deprecation")
	public static  Projet withAnnotation(com.ibm.common.Projet p){
		System.out.println("converter " +p);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateDebut = new Date();
		Date dateFin = new Date();
        try {
        	dateDebut = formatter.parse(p.getDateDebut());
        	dateFin = formatter.parse(p.getDateFin());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Projet(p.getId(),p.getNom(),withAnnotation(p.getResponsable()),dateDebut,dateFin);
	}
	
	public static  WrapperRessource withOutAnnotation(List<Ressource> lstR){
		WrapperRessource wrapper = new WrapperRessource();
		List<com.ibm.common.Ressource> lst = new ArrayList<com.ibm.common.Ressource>();
		for (Ressource ressource : lstR) {
			lst.add(withOutAnnotation(ressource));
		}
		wrapper.setList(lst);
		return wrapper;
	}
	
	public static  WrapperProjet withOutAnnotationProjet(List<Projet> lstP){
		WrapperProjet wrapper = new WrapperProjet();
		List<com.ibm.common.Projet> lst = new ArrayList<com.ibm.common.Projet>();
		for (Projet projet : lstP) {
			lst.add(withOutAnnotation(projet));
		}
		wrapper.setList(lst);
		return wrapper;
	}
}
