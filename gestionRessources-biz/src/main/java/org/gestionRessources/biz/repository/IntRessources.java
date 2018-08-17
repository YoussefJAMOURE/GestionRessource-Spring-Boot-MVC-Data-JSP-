package org.gestionRessources.biz.repository;

import java.util.Optional;

import org.gestionRessources.biz.beans.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IntRessources extends JpaRepository<Ressource, Long> {
	void deleteById(Long id);
	Optional<Ressource> findById(Long id);
}