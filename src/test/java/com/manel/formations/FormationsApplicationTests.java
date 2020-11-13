package com.manel.formations;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.manel.formations.entities.Centre;
import com.manel.formations.entities.Formation;
import com.manel.formations.repos.FormationRepository;
import com.manel.formations.service.FormationService;

@SpringBootTest
class FormationsApplicationTests {

	@Autowired
	private FormationRepository formationRepository;
	private FormationService formationService;
	
	@Test
	public void testCreateFormation()
	{
		Formation form = new Formation("JEE" , "présentielle" , 50.000 , new Date());
		formationRepository.save(form);
	}

	@Test
	public void testFindFormation()
	{ 
		Formation f = formationRepository.findById(1L).get(); 
		System.out.println(f);
	}
	
	@Test
	public void testUpdateFormation()
	{ 
		Formation f = formationRepository.findById(1L).get();
		f.setPrixFormation(100.0);; 
		formationRepository.save(f);
	}
	
	@Test
	public void testDeleteFormation()
	{
		formationRepository.deleteById(1L);;
	}
	
	@Test
	public void ListerTousFormation()
	{
		List<Formation> form = formationRepository.findAll();
		for (Formation f : form)
		{
			System.out.println(f);
		}
	}
	
	@Test
	public void testFindByNomFormation()
	{
		List<Formation> forms = formationRepository.findByNomFormation("JEE");
		for (Formation f : forms)
		{
			System.out.println(f);
		}
	}
	
	@Test
	public void testFindByNomFormationContains()
	{
		List<Formation> forms = formationRepository.findByNomFormationContains("JEE");
		for (Formation f : forms)
		{
			System.out.println(f);
		}
	}
	
	@Test public void testfindByNomPrix()
	{
		List<Formation> forms = formationRepository.findByNomPrix("JEE", 10.0);
		for (Formation f : forms)
			{
			System.out.println(f);
			}
	}
	
	@Test
	public void testfindByCentre()
	{
		Centre cen = new Centre();
		cen.setIdCentre(1L);
		List<Formation> forms = formationRepository.findByCentre(cen);
		for (Formation f : forms)
		{
			System.out.println(f);
		}
	}
	
	@Test 
	public void findByCentreIdCentre()
	{
		List<Formation> forms = formationRepository.findByCentreIdCentre(2L);
		for (Formation f : forms)
			{
			System.out.println(f);
			}
	}
	
	@Test 
	public void testfindByOrderByNomFormationAsc()
	{
		List<Formation> forms = formationRepository.findByOrderByNomFormationAsc();
		for (Formation f : forms)
			{
			System.out.println(f);
			}
	}
	
	@Test 
	public void testTrierFormationsNomsPrix()
	{
		List<Formation> forms = formationRepository.trierFormationsNomsPrix();
		for (Formation f : forms)
			{
			System.out.println(f);
			}
	}
}
