package com.manel.formations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.manel.formations.entities.Centre;
import com.manel.formations.entities.Formation;
import com.manel.formations.repos.FormationRepository;

@Service
public class FormationServiceImpl implements FormationService
{
	@Autowired
	FormationRepository formationRepository;

	@Override
	public Formation saveFormation(Formation f) {
		// TODO Auto-generated method stub
		return formationRepository.save(f);
	}

	@Override
	public Formation updateFormation(Formation f) {
		// TODO Auto-generated method stub
		return formationRepository.save(f);
	}

	@Override
	public void deleteFormation(Formation f) {
		// TODO Auto-generated method stub
		formationRepository.delete(f);
	}

	@Override
	public void deleteFormationById(Long id) {
		// TODO Auto-generated method stub
		formationRepository.deleteById(id);
	}

	@Override
	public Formation getFormation(Long id) {
		// TODO Auto-generated method stub
		return formationRepository.findById(id).get();
	}

	@Override
	public List<Formation> getAllFormations() {
		// TODO Auto-generated method stub
		return formationRepository.findAll();
	}

	@Override
	public Page<Formation> getAllFormationsParPage(int page, int size) {
		// TODO Auto-generated method stub
		return formationRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Formation> findByNomFormation(String nom) {
		// TODO Auto-generated method stub
		return formationRepository.findByNomFormation(nom);
	}

	@Override
	public List<Formation> findByNomFormationContains(String nom) {
		// TODO Auto-generated method stub
		return formationRepository.findByNomFormationContains(nom);
	}

	@Override
	public List<Formation> findByNomPrix(String nom, Double prix) {
		// TODO Auto-generated method stub
		return formationRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Formation> findByCentre(Centre centre) {
		// TODO Auto-generated method stub
		return formationRepository.findByCentre(centre);
	}

	@Override
	public List<Formation> findByCentreIdCentre(Long id) {
		// TODO Auto-generated method stub
		return formationRepository.findByCentreIdCentre(id);
	}

	@Override
	public List<Formation> findByOrderByNomFormationAsc() {
		// TODO Auto-generated method stub
		return formationRepository.findByOrderByNomFormationAsc();
	}

	@Override
	public List<Formation> trierFormationsNomsPrix() {
		// TODO Auto-generated method stub
		return formationRepository.trierFormationsNomsPrix();
	}
	
	

}
