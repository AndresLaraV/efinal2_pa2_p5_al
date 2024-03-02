package com.uce.edu.ec.service;

import com.uce.edu.ec.repository.modelo.Estudiante;

public interface IEstudianteService {

	public void guardar(Estudiante estudiante);

	public Estudiante buscarPorCedula(String cedula);

}
