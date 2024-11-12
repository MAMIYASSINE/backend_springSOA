package com.project.voitures.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.voitures.entities.Image;

public interface ImageRepository extends JpaRepository<Image , Long> {

}
