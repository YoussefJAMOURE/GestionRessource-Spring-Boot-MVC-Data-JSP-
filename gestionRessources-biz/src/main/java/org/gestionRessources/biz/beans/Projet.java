package org.gestionRessources.biz.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
public class Projet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRessource",referencedColumnName = "id")
	private Ressource responsable;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;

	public Projet(Long idProjet, String nom, Ressource responsable, Date dateDebut, Date dateFin) {
		super();
		this.id = idProjet;
		this.nom = nom;
		this.responsable = responsable;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	public Projet(String nom, Ressource responsable, Date dateDebut, Date dateFin) {
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

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public String toString() {
		return "Projet [id=" + id + ", nom=" + nom + ", responsable=" + responsable + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + "]";
	}

}
