package com.ibm.common;


public class Ressource {

	    private Long id;
	    private String nom;
	    private String prenom;
	    private String refog;
	    private String dateAffectation;
	   // List<Projet> projets;

		public Ressource(Long id, String nom, String prenom, String refog, String dateAffectation) {
			super();
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
			this.refog = refog;
			this.dateAffectation = dateAffectation;
		}
		public Ressource(String nom, String prenom, String refog, String dateAffectation) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.refog = refog;
			this.dateAffectation = dateAffectation;
		}
		
		public Ressource() {
			super();

		}
		
		public Ressource(Long id) {
			super();
			this.id = id;
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

		public String getDateAffectation() {
			return dateAffectation;
		}

		public void setDateAffectation(String dateAffectation) {
			this.dateAffectation = dateAffectation;
		}
/*
		public List<Projet> getProjets() {
			return projets;
		}

		public void setProjets(List<Projet> projets) {
			this.projets = projets;
		}
*/
		@Override
		public String toString() {
			return "Ressource [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", refog=" + refog
					+ ", dateAffectation=" + dateAffectation +  "]";
		}
	    
	    
	      
}
