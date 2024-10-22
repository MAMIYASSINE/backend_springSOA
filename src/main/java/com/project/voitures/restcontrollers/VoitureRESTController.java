package com.project.voitures.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.voitures.entities.Voiture;
import com.project.voitures.service.VoitureService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class VoitureRESTController {

	@Autowired
	VoitureService voitureService;

	@RequestMapping(path="all",method = RequestMethod.GET)
	public List<Voiture> getAllVoitures() {
		return voitureService.getAllVoitures();
	}

	@RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
	public Voiture getVoitureById(@PathVariable("id") Long id) {
		return voitureService.getVoiture(id);
	}

	@RequestMapping(value = "/addvoiture",method = RequestMethod.POST)
	public Voiture createVoiture(@RequestBody Voiture voiture) {
		return voitureService.saveVoiture(voiture);
	}
	
	@RequestMapping(value = "/updatevoiture",method = RequestMethod.PUT)
	public Voiture updateVoiture(@RequestBody Voiture voiture) {
		return voitureService.updateVoiture(voiture);
	}
	@RequestMapping(value="/delvoiture/{id}",method = RequestMethod.DELETE)
	public void deleteVoiture(@PathVariable("id") Long id) {
		voitureService.deleteVoitureById(id);
	}
	@RequestMapping(value="/voituresmarque/{idMarque}",method = RequestMethod.GET)
	public List<Voiture> getVoituresByMarqueId(@PathVariable("idMarque") Long idMarque){
		return voitureService.findByMarqueIdMarque(idMarque);
	}
	
	@RequestMapping(value="/voitsByName/{nom}",method = RequestMethod.GET)
	public List<Voiture> findByNomPVoitureContains(@PathVariable("nom") String nom) {
	return voitureService.findByNomVoitureContains(nom);
	}

}
