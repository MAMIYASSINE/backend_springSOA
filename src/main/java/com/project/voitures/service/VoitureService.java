package com.project.voitures.service;

import java.util.List;

import com.project.voitures.entities.Marque;
import com.project.voitures.entities.Voiture;

public interface VoitureService {
	Voiture saveVoiture(Voiture v);
	Voiture updateVoiture(Voiture v);
	void deleteVoiture(Voiture v);
	void deleteVoitureById(Long id);
	Voiture getVoiture(Long id);
	List<Voiture> getAllVoitures();
	List<Voiture> findByNomVoiture(String nom);
	List<Voiture> findByNomVoitureContains(String nom);
	List<Voiture> findByNomPrix (String nom, Double prix);
	List<Voiture> findByMarque (Marque ma);
	List<Voiture> findByMarqueIdMarque(Long id);
	List<Voiture> findByOrderByNomVoitureAsc();
	List<Voiture> trierVoituresNomsPrix();
}
