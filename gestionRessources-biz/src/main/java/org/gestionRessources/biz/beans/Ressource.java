package org.gestionRessources.biz.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ressource {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String refog;
	@Temporal(TemporalType.DATE)
	private Date dateAffectation;
	// List<Projet> projets;

	public Ressource(Long idRessource, String nom, String prenom, String refog, Date dateAffectation) {
		super();
		this.id = idRessource;
		this.nom = nom;
		this.prenom = prenom;
		this.refog = refog;
		this.dateAffectation = dateAffectation;
	}

	public Ressource(String nom, String prenom, String refog, Date dateAffectation) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.refog = refog;
		this.dateAffectation = dateAffectation;
	}

	public Ressource() {
		super();

	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getRefog() {
		return refog;
	}

	public void setRefog(String refog) {
		this.refog = refog;
	}

	public Date getDateAffectation() {
		return dateAffectation;
	}

	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}

	/*
	 * public List<Projet> getProjets() { return projets; }
	 * 
	 * public void setProjets(List<Projet> projets) { this.projets = projets; }
	 */
	@Override
	public String toString() {
		return "Ressource [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", refog=" + refog
				+ ", dateAffectation=" + dateAffectation + "]";
	}

}
