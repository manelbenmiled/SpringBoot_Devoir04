package com.manel.formations.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.manel.formations.entities.Centre;
import com.manel.formations.entities.Formation;

@RepositoryRestResource(path="rest")
public interface FormationRepository extends JpaRepository<Formation, Long> {

	List<Formation> findByNomFormation(String nomFormation);
	List<Formation> findByNomFormationContains(String nomFormation);
	@Query("select f from Formation f where f.nomFormation like %:nom and f.prixFormation > :prix")
	List<Formation> findByNomPrix (@Param("nom") String nom, @Param("prix") Double prix);
	@Query("select f from Formation f where f.centre =?1")
	List<Formation> findByCentre (Centre centre);
	List<Formation> findByCentreIdCentre(Long id);
	List<Formation> findByOrderByNomFormationAsc();
	@Query("select f from Formation f order by f.nomFormation ASC, f.prixFormation DESC")
	List<Formation> trierFormationsNomsPrix();
}
