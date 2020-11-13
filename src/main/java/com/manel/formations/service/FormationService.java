package com.manel.formations.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.manel.formations.entities.Centre;
import com.manel.formations.entities.Formation;
import com.manel.formations.repos.FormationRepository;

public interface FormationService 
{
	Formation saveFormation(Formation f);
	Formation updateFormation(Formation f);
	void deleteFormation(Formation f);
	void deleteFormationById(Long id);
	Formation getFormation(Long id);
	List<Formation> getAllFormations();
	public Page<Formation> getAllFormationsParPage(int page, int size);
	List<Formation> findByNomFormation(String nom);
	List<Formation> findByNomFormationContains(String nom);
	List<Formation> findByNomPrix (String nom, Double prix);
	List<Formation> findByCentre (Centre centre);
	List<Formation> findByCentreIdCentre(Long id);
	List<Formation> findByOrderByNomFormationAsc();
	List<Formation> trierFormationsNomsPrix();
	
}
