package com.project.voitures.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Voiture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVoiture;
	private String nomVoiture;
	private int nbPortes;
	private int puissance;
	private String type;
	private Double prixVoiture;
	private Date dateCreationVoiture;
	
	@ManyToOne
	private Marque marque;
	
	
	
	
	
	public Voiture() {
		super();
	}
	
	
	
	public Voiture(String nomVoiture, int nbPortes, int puissance, String type, Double prixVoiture,Date dateCreationVoiture) {
		super();
		this.nomVoiture = nomVoiture;
		this.nbPortes = nbPortes;
		this.puissance = puissance;
		this.type = type;
		this.prixVoiture = prixVoiture;
		this.dateCreationVoiture = dateCreationVoiture;
	}



	public Long getIdVoiture() {
		return idVoiture;
	}
	public void setIdVoiture(Long idVoiture) {
		this.idVoiture = idVoiture;
	}
	public String getNomVoiture() {
		return nomVoiture;
	}
	public void setNomVoiture(String nomVoiture) {
		this.nomVoiture = nomVoiture;
	}
	public int getNbPortes() {
		return nbPortes;
	}
	public void setNbPortes(int nbPortes) {
		this.nbPortes = nbPortes;
	}
	public int getPuissance() {
		return puissance;
	}
	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getPrixVoiture() {
		return prixVoiture;
	}
	public void setPrixVoiture(Double prixVoiture) {
		this.prixVoiture = prixVoiture;
	}
	public Date getDateCreationVoiture() {
		return dateCreationVoiture;
	}
	public void setDateCreationVoiture(Date dateCreationVoiture) {
		this.dateCreationVoiture = dateCreationVoiture;
	}



	@Override
	public String toString() {
		return "Voiture [idVoiture=" + idVoiture + ", nomVoiture=" + nomVoiture + ", nbPortes=" + nbPortes
				+ ", puissance=" + puissance + ", type=" + type + ", prixVoiture=" + prixVoiture
				+ ", dateCreationVoiture=" + dateCreationVoiture + "]";
	}



	public Marque getMarque() {
		return marque;
	}



	public void setMarque(Marque marque) {
		this.marque = marque;
	}
	
	
	
	
	
	
}
