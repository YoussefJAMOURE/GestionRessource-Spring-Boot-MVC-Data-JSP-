package com.ibm.common;


import java.util.Date;




public class Projet {


	private Long id;
	private String nom;
	private Ressource responsable;
	private String dateDebut;
	private String dateFin;

	public Projet(Long id, String nom, Ressource responsable, String dateDebut, String dateFin) {
		super();
		this.id = id;
		this.nom = nom;
		this.responsable = responsable;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	public Projet(String nom, Ressource responsable, String dateDebut, String dateFin) {
		super();
		this.nom = nom;
		this.responsable = responsable;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	public Projet() {
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

	public Ressource getResponsable() {
		return responsable;
	}

	public void setResponsable(Ressource responsable) {
		this.responsable = responsable;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public String toString() {
		return "Projet [id=" + id + ", nom=" + nom + ", responsable=" + responsable + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + "]";
	}

}
