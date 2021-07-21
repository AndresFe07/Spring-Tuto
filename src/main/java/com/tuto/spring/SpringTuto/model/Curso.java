package com.tuto.spring.SpringTuto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="cursos")
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
	
	public Curso(String dateini, String duration, String name) {
		this.dateini = dateini;
		this.duration = duration;
		this.name = name;
	}

	@JsonProperty(value="id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty(value="name")
	@NotEmpty
	@Size(max = 15)
	private String name;
	
	@JsonProperty(value="duration")
	@Size(min = 10, max = 20)
	private String duration;
	
	@JsonProperty(value="dateini")
	@Size(min = 10, max = 45)
	@Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}", message="Invalid status date")
	private String dateini;
}
