package com.ibm.common;


public class ProjetFormulaire {


	private Long id;
	private String nom;
	private Long responsable;
	private String dateDebut;
	private String dateFin;

	public ProjetFormulaire(Long id, String nom, Long responsable, String dateDebut, String dateFin) {
		super();
		this.id = id;
		this.nom = nom;
		this.responsable = responsable;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	public ProjetFormulaire(String nom, Long responsable, String dateDebut, String dateFin) {
		super();
		this.nom = nom;
		this.responsable = responsable;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	public ProjetFormulaire() {
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

	public Long getResponsable() {
		return responsable;
	}

	public void setResponsable(Long responsable) {
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
