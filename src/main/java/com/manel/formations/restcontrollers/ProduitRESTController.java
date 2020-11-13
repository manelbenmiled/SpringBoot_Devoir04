package com.manel.formations.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manel.formations.entities.Formation;
import com.manel.formations.service.FormationService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProduitRESTController 
{
	@Autowired
	FormationService formationService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Formation> getAllFormations()
	{
		return formationService.getAllFormations();
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public Formation getFormationById(@PathVariable("id") Long id)
	{
		return formationService.getFormation(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Formation createFormation(@RequestBody Formation formation)
	{
		return formationService.saveFormation(formation);
	}
	
	@RequestMapping(method =RequestMethod.PUT)
	public Formation updateFormation(@RequestBody Formation formation)
	{
		return formationService.updateFormation(formation);
	}

	@RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
	public void deleteFormation(@PathVariable("id") Long id)
	{
		formationService.deleteFormationById(id);
	}
	
	@RequestMapping(value="/formsCen/{idCen}",method = RequestMethod.GET)
	public List<Formation> getFormationByCenId(@PathVariable("idCen") Long idCen)
	{
		return formationService.findByCentreIdCentre(idCen);
	}
}
