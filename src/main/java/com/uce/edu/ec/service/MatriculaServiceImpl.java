package com.uce.edu.ec.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ec.repository.IEstudianteRepository;
import com.uce.edu.ec.repository.IMateriaRepository;
import com.uce.edu.ec.repository.IMatriculaRepository;
import com.uce.edu.ec.repository.modelo.Estudiante;
import com.uce.edu.ec.repository.modelo.Materia;
import com.uce.edu.ec.repository.modelo.Matricula;
import com.uce.edu.ec.repository.modelo.dto.MatriculaDTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IMatriculaRepository iMatriculaRepository;

	@Autowired
	private IEstudianteRepository iEstudianteRepository;

	@Autowired
	private IMateriaRepository iMateriaRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public List<MatriculaDTO> reporte() {
		// TODO Auto-generated method stub
		return this.iMatriculaRepository.buscarTodos();
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void matriculacionParalela(MatriculaDTO matriculaDTO) {
		// TODO Auto-generated method stub
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

		Matricula m1 = new Matricula();
		m1.setFecha(LocalDate.now());
		Materia mat1 = new Materia();
		mat1.setCodigo(matriculaDTO.getCodigo1());
		m1.setMateria(mat1);

		Matricula m2 = new Matricula();
		m2.setFecha(LocalDate.now());
		Materia mat2 = new Materia();
		mat2.setCodigo(matriculaDTO.getCodigo2());
		m2.setMateria(mat2);

		Matricula m3 = new Matricula();
		m3.setFecha(LocalDate.now());
		Materia mat3 = new Materia();
		mat3.setCodigo(matriculaDTO.getCodigo3());
		m3.setMateria(mat3);

		Matricula m4 = new Matricula();
		Materia mat4 = new Materia();
		mat4.setCodigo(matriculaDTO.getCodigo4());
		m4.setMateria(mat4);

		List<Matricula> matriculas = new ArrayList<>();

		matriculas.add(m1);
		matriculas.add(m2);
		matriculas.add(m3);
		matriculas.add(m4);

		matriculas.parallelStream().forEach(matricula -> {
			String hilo = Thread.currentThread().getName();
			matricula.setNombreHilo(hilo);
			this.matricularConCedulaCodigo(matriculaDTO.getCedulaEstudiante(), matricula.getMateria().getCodigo(),
					matricula);
		});
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void matricularConCedulaCodigo(String cedula, String codigo, Matricula matricula) {
		// TODO Auto-generated method stub
		System.out.println("2 " + codigo + TransactionSynchronizationManager.isActualTransactionActive());
		
		Estudiante estudiante = this.iEstudianteRepository.seleccionarPorCedula(cedula);
		
		Materia materia = this.iMateriaRepository.seleccionarPorCodigo(codigo);

		matricula.setEstudiante(estudiante);
		matricula.setMateria(materia);
		matricula.setFecha(LocalDate.now());
		this.iMatriculaRepository.insertar(matricula);

	}

}