package com.uce.edu.ec.service;

import java.util.List;

import com.uce.edu.ec.repository.modelo.Matricula;
import com.uce.edu.ec.repository.modelo.dto.MatriculaDTO;

public interface IMatriculaService {
	
	public List<MatriculaDTO> reporte();

	public void matriculacionParalela(MatriculaDTO matriculaTO);

	public void matricularConCedulaCodigo(String cedula, String codigo, Matricula matricula);


}
