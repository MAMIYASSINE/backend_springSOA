package com.project.voitures.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.voitures.entities.Marque;
import com.project.voitures.entities.Voiture;
import com.project.voitures.repos.ImageRepository;
import com.project.voitures.repos.VoitureRepository;

@Service
public class VoitureServiceImpl implements VoitureService {

	@Autowired
	private VoitureRepository voitureRepository;

	@Autowired
	private ImageRepository imageRepository;

	@Override
	public Voiture saveVoiture(Voiture v) {
		return voitureRepository.save(v);
	}

	/*
	 * @Override public Voiture updateVoiture(Voiture v) { return
	 * voitureRepository.save(v); }
	 */
	@Override
	public Voiture updateVoiture(Voiture v) {
//		Long oldVoitImageId = this.getVoiture(v.getIdVoiture()).getImage().getIdImage();
//		Long newVoitImageId = v.getImage().getIdImage();
		Voiture voitUpdated = voitureRepository.save(v);
//		if (oldVoitImageId != newVoitImageId) // si l'image a été modifiée
//			imageRepository.deleteById(oldVoitImageId);
		return voitUpdated;
	}

	@Override
	public void deleteVoiture(Voiture v) {

		voitureRepository.delete(v);
	}

	@Override
	public void deleteVoitureById(Long id) {
		Voiture v = getVoiture(id);
		// suuprimer l'image avant de supprimer la voiture
		String uploadDir = "D:/images/";
		try {
			Files.delete(Paths.get(uploadDir + v.getImagePath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		voitureRepository.deleteById(id);
	}

	@Override
	public Voiture getVoiture(Long id) {
		return voitureRepository.findById(id).get();
	}

	@Override
	public List<Voiture> getAllVoitures() {
		return voitureRepository.findAll();
	}

	@Override
	public List<Voiture> findByNomVoiture(String nom) {
		return voitureRepository.findByNomVoiture(nom);
	}

	@Override
	public List<Voiture> findByNomVoitureContains(String nom) {
		return voitureRepository.findByNomVoitureContains(nom);
	}

	@Override
	public List<Voiture> findByNomPrix(String nom, Double prix) {
		return voitureRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Voiture> findByMarque(Marque ma) {
		return voitureRepository.findByMarque(ma);
	}

	@Override
	public List<Voiture> findByMarqueIdMarque(Long id) {
		return voitureRepository.findByMarqueIdMarque(id);
	}

	@Override
	public List<Voiture> findByOrderByNomVoitureAsc() {
		return voitureRepository.findByOrderByNomVoitureAsc();
	}

	@Override
	public List<Voiture> trierVoituresNomsPrix() {
		return voitureRepository.trierVoituresNomsPrix();
	}

}
