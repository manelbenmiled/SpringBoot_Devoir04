package com.manel.formations.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Formation 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFormation;
	private String nomFormation;
	private String typeFormation;
	private Double prixFormation;
	private Date dateFormation;
	
	@ManyToOne
	private Centre centre;
	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Formation(String nomFormation, String typeFormation, Double prixFormation, Date dateFormation) {
		super();
		this.nomFormation = nomFormation;
		this.typeFormation = typeFormation;
		this.prixFormation = prixFormation;
		this.dateFormation = dateFormation;
	}

	public Long getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Long idFormation) {
		this.idFormation = idFormation;
	}

	public String getNomFormation() {
		return nomFormation;
	}

	public void setNomFormation(String nomFormation) {
		this.nomFormation = nomFormation;
	}

	public String getTypeFormation() {
		return typeFormation;
	}

	public void setTypeFormation(String typeFormation) {
		this.typeFormation = typeFormation;
	}

	public Double getPrixFormation() {
		return prixFormation;
	}

	public void setPrixFormation(Double prixFormation) {
		this.prixFormation = prixFormation;
	}

	public Date getDateFormation() {
		return dateFormation;
	}

	public void setDateFormation(Date dateFormation) {
		this.dateFormation = dateFormation;
	}

	@Override
	public String toString() {
		return "Formation [idFormation=" + idFormation + ", nomFormation=" + nomFormation + ", typeFormation="
				+ typeFormation + ", prixFormation=" + prixFormation + ", dateFormation=" + dateFormation + "]";
	}
	
	

}
