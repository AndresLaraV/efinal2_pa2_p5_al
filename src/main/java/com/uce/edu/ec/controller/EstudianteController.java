package com.uce.edu.ec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.ec.repository.modelo.Estudiante;
import com.uce.edu.ec.service.IEstudianteService;

@Controller
@RequestMapping(value = "/estudiantes")
public class EstudianteController {
	@Autowired
	private IEstudianteService iEstudianteService;

	@GetMapping(value = "/iniciarRegistro")
	public String inicarRegistro(Estudiante estudiante) {
		return "vistaRegistroEstudiante";
	}

	@PostMapping(value = "/registrar")
	public String registrar(Estudiante estudiante) {
		this.iEstudianteService.guardar(estudiante);
		return "redirect:/estudiantes/iniciarRegistro";
	}
}