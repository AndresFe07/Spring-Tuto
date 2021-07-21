package com.tuto.spring.SpringTuto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tuto.spring.SpringTuto.dao.CursoDao;
import com.tuto.spring.SpringTuto.model.Curso;

@RestController

public class Controller {

	@Autowired
	private CursoDao cursoDao;

	@GetMapping("/curso/{id}")
	public Optional<Curso> getCurso(@PathVariable("id") Long id) {
		return cursoDao.findById(id);
	}

	@GetMapping("/cursos")
	public Iterable<Curso> getCursos() {
		return cursoDao.findAll();
	}

	@PostMapping("/curso/save")
	public String saveCurso(@RequestBody Curso curso) {
		cursoDao.save(new Curso(curso.getDateini(), curso.getDuration(),
				curso.getName()));
		return "Curso salvado";
	}

	@PutMapping("/curso/modify/{id}")
	public String modifyCurso(@RequestBody Curso curso,
			@PathVariable("id") Long id) {
		Optional<Curso> cursoData = cursoDao.findById(id);
		if (cursoData.isPresent()) {
			Curso course = cursoData.get();
			course.setDateini(curso.getDateini());
			course.setDuration(curso.getDuration());
			course.setName(curso.getName());
			cursoDao.save(course);
		} 

		return "Curso Modificado";
	}

	@DeleteMapping("/curso/delete/{id}")
	public String deleteCurso(@PathVariable("id") long id) {
		cursoDao.deleteById(id);
		return "Curso Eliminado";
	}
}
