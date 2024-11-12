package com.project.voitures.restcontrollers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.project.voitures.entities.Image;
import com.project.voitures.entities.Voiture;
import com.project.voitures.service.ImageService;
import com.project.voitures.service.VoitureService;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
	@Autowired
	ImageService imageService;
	
	@Autowired
	VoitureService voitureService;

	@RequestMapping(value = "/uploadFS/{id}", method = RequestMethod.POST)
	public void uploadImageFS(@RequestParam("image") MultipartFile file, @PathVariable("id") Long id)
			throws IOException {
		Voiture v = voitureService.getVoiture(id);
		v.setImagePath(id + ".jpg");
		// Nouveau chemin pour D:\
	    String uploadDir = "D:/images/";

	    // Création du répertoire si nécessaire
	    File dir = new File(uploadDir);
	    if (!dir.exists()) {
	        dir.mkdirs();  // Crée le répertoire s'il n'existe pas
	    }
	    Files.write(Paths.get(uploadDir + v.getImagePath()), file.getBytes());
		voitureService.saveVoiture(v);
	}

	@RequestMapping(value = "/loadfromFS/{id}", method = RequestMethod.GET, produces = org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {
		Voiture v = voitureService.getVoiture(id);
				//.getProduit(id);
		String uploadDir = "D:/images/";
		return Files.readAllBytes(Paths.get(uploadDir + v.getImagePath()));
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Image uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}

	@RequestMapping(value = "/get/info/{id}", method = RequestMethod.GET)
	public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
		return imageService.getImageDetails(id);
	}

	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
		return imageService.getImage(id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteImage(@PathVariable("id") Long id) {
		imageService.deleteImage(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Image UpdateImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}

	@PostMapping(value = "/uplaodImageVoiture/{idVoiture}")
	public Image uploadMultiImages(@RequestParam("image") MultipartFile file, @PathVariable("idVoiture") Long idVoiture)
			throws IOException {
		return imageService.uplaodImageVoiture(file, idVoiture);
	}

	@RequestMapping(value = "/getImagesVoiture/{idVoiture}", method = RequestMethod.GET)
	public List<Image> getImagesVoiture(@PathVariable("idVoiture") Long idVoiture) throws IOException {
		return imageService.getImagesParVoiture(idVoiture);
	}

}