package com.uce.edu.ec.repository;

import java.util.List;

import com.uce.edu.ec.repository.modelo.Matricula;
import com.uce.edu.ec.repository.modelo.dto.MatriculaDTO;

public interface IMatriculaRepository {
	public void insertar(Matricula matricula);
    public List<MatriculaDTO> buscarTodos();

}
