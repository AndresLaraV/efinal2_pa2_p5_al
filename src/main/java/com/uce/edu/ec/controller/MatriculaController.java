package com.uce.edu.ec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.ec.repository.modelo.dto.MatriculaDTO;
import com.uce.edu.ec.service.IMatriculaService;



@Controller
@RequestMapping(value = "/matriculas")
public class MatriculaController {
	@Autowired
	private IMatriculaService iMatriculaService;

	@GetMapping(value = "/iniciarReporte")
	public String iniciarReporte(MatriculaDTO matriculaDTO, Model model) {
		List<MatriculaDTO> matriculas = this.iMatriculaService.reporte();
		model.addAttribute("reporteModel", matriculas);
		return "vistaReporteMatriculas";
	}

	@GetMapping(value = "/iniciarMatricula")
	public String iniciarMatricula(MatriculaDTO matriculaTO) {
		return "vistaRegistroMatricula";
	}

	@PostMapping(value = "/matricular")
	public String matricular(MatriculaDTO matriculaTO) {
		this.iMatriculaService.matriculacionParalela(matriculaTO);
		return "redirect:/matriculas/iniciarMatricula";
	}
}
