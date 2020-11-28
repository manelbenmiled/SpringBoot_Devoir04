package com.manel.formations.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
public class Formation 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFormation;
	@NotNull
	@Size (min = 4,max = 15)
	private String nomFormation;
	private String typeFormation;
	@Min(value = 10)
	@Max(value = 10000)
	private Double prixFormation;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
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
