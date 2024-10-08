package com.project.voitures.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.project.voitures.entities.Marque;
import com.project.voitures.entities.Voiture;

@RepositoryRestResource(path = "rest")
public interface VoitureRepository extends JpaRepository<Voiture, Long> {

	List<Voiture> findByNomVoiture(String nom);

	List<Voiture> findByNomVoitureContains(String nom);

	/*
	 * @Query("select v from Voiture v where v.nomVoiture like %?1 and v.prixVoiture > ?2"
	 * ) List<Voiture> findByNomPrix (String nom, Double prix);
	 */
	@Query("select v from Voiture v where v.nomVoiture like%:nom and v.prixVoiture > :prix")
	List<Voiture> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);

	@Query("select v from Voiture v where v.marque = ?1")
	List<Voiture> findByMarque(Marque marque);

	List<Voiture> findByMarqueIdMarque(Long id);

	List<Voiture> findByOrderByNomVoitureAsc();

	@Query("select v from Voiture v order by v.nomVoiture ASC, v.prixVoiture DESC")
	List<Voiture> trierVoituresNomsPrix();

}