package com.project.voitures;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.voitures.entities.Marque;
import com.project.voitures.entities.Voiture;
import com.project.voitures.repos.VoitureRepository;

@SpringBootTest
class VoituresApplicationTests {

	@Autowired
	private VoitureRepository voitureRepository;

	@Test
	public void testCreateVoiture() {
		Voiture voit = new Voiture("audi", 4, 700, "Disel", 250.0, new Date());
		voitureRepository.save(voit);
	}

	@Test
	public void testFindVoiture() {
		Voiture v = voitureRepository.findById(1L).get();
		System.out.println(v);
	}

	@Test
	public void testUpdateVoiture() {
		Voiture v = voitureRepository.findById(3L).get();
		v.setPrixVoiture(1000.0);
		voitureRepository.save(v);
		System.out.println(v);

	}

	@Test
	public void testDeleteVoiture() {
		voitureRepository.deleteById(3L);
		;
	}

	@Test
	public void testListerTousVoitures() {
		List<Voiture> voits = voitureRepository.findAll();
		for (Voiture v : voits) {
			System.out.println(v);
		}
	}

	@Test
	public void testFindVoitureByNom() {
		List<Voiture> voits = voitureRepository.findByNomVoiture("bmw");
		for (Voiture v : voits) {
			System.out.println(v);
		}
	}

	@Test
	public void testFindVoitureByNomContains() {
		List<Voiture> voits = voitureRepository.findByNomVoitureContains("b");
		for (Voiture v : voits) {
			System.out.println(v);
		}
	}

	@Test
	public void testfindByNomPrix() {
		List<Voiture> voits = voitureRepository.findByNomPrix("mercedes", 150.0);
		for (Voiture v : voits) {
			System.out.println(v);
		}
	}

	@Test
	public void testfindByMarque() {
		Marque ma = new Marque();
		ma.setIdMarque(1L);
		List<Voiture> voits = voitureRepository.findByMarque(ma);
		for (Voiture v : voits) {
			System.out.println(v);
		}
	}

	@Test
	public void findByMarqueIdMarque() {
		List<Voiture> voits = voitureRepository.findByMarqueIdMarque(1L);
		for (Voiture v : voits) {
			System.out.println(v);
		}
	}

	@Test
	public void testfindByOrderByNomVoitureAsc() {
		List<Voiture> voits = voitureRepository.findByOrderByNomVoitureAsc();
		for (Voiture v : voits) {
			System.out.println(v);
		}
	}

	@Test
	public void testTrierVoituresNomsPrix() {
		List<Voiture> voits = voitureRepository.trierVoituresNomsPrix();
		for (Voiture v : voits) {
			System.out.println(v);
		}
	}

}
