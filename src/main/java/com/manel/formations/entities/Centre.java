package com.manel.formations.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Centre 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCentre;
	private String nomCentre;
	private String localisation;
	private Long tel;
	
	@JsonIgnore
	@OneToMany(mappedBy = "centre")
	private List<Formation> formations;
	
	
}
