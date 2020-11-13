package com.manel.formations.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.manel.formations.entities.Formation;
import com.manel.formations.service.FormationService;

@Controller
public class FormationController {
	
	@Autowired
	FormationService formationService;
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createFormation";
	}

	@RequestMapping("/saveFormation")
	public String saveFormation(@ModelAttribute("formation") Formation formation,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateFormation = dateformat.parse(String.valueOf(date)); 
	formation.setDateFormation(dateFormation);
	Formation saveFormation = formationService.saveFormation(formation);
	String msg ="formation enregistré avec Id "+saveFormation.getIdFormation();
	modelMap.addAttribute("msg", msg);
	return "createFormation";
	}
	
	
	
	
	@RequestMapping("/ListeFormations")
	public String listeFormations(ModelMap modelMap,
		@RequestParam (name="page",defaultValue = "0") int page,
		@RequestParam (name="size", defaultValue = "2") int size)
	
	{   Page<Formation> forms = formationService.getAllFormationsParPage(page, size);
		modelMap.addAttribute("formations", forms);
		modelMap.addAttribute("pages", new int[forms.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeFormations";
	}
	
	
	
	
	
	@RequestMapping("/supprimerFormation")
	public String supprimerFormation(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	formationService.deleteFormationById(id);
	Page<Formation> forms = formationService.getAllFormationsParPage(page, size);
	modelMap.addAttribute("formations", forms);
	modelMap.addAttribute("pages", new int[forms.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeFormations";
	}
	
	
	
	@RequestMapping("/modifierFormation")
	public String editerFormation(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Formation f= formationService.getFormation(id);
	modelMap.addAttribute("formation", f);
	return "editerFormation";
	}
	@RequestMapping("/updateFormation")
	public String updateFormation(@ModelAttribute("formation") Formation formation,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException
	{
		//conversion de la date 
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateFormation = dateformat.parse(String.valueOf(date));
		formation.setDateFormation(dateFormation);
		formationService.updateFormation(formation);
		List<Formation> forms = formationService.getAllFormations();
		modelMap.addAttribute("formations", forms);
		return "listeFormations";
		}
}
