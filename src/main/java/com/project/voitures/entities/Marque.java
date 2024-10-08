package com.project.voitures.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Marque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMarque;
	private String nomMarque;
	private String descriptionMarque;
	
	@JsonIgnore
	@OneToMany(mappedBy = "marque")
	private List<Voiture> voitures;
	

}
