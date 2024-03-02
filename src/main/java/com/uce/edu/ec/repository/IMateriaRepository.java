package com.uce.edu.ec.repository;

import com.uce.edu.ec.repository.modelo.Materia;

public interface IMateriaRepository {
	public void insertar(Materia materia);

	public Materia seleccionarPorCodigo(String codigo);

}
