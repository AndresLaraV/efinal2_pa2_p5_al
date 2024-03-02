package com.uce.edu.ec.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ec.repository.modelo.Matricula;
import com.uce.edu.ec.repository.modelo.dto.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements IMatriculaRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = Transactional.TxType.REQUIRED)
	// Por la programacion en paralelo
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.entityManager.persist(matricula);
	}

	@Override
	@Transactional(value = Transactional.TxType.NOT_SUPPORTED)
	public List<MatriculaDTO> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<MatriculaDTO> query = this.entityManager.createQuery(
				"SELECT new com.uce.edu.ec.repository.modelo.dto.MatriculaDTO(m.estudiante.cedula, m.materia.codigo, m.fecha, m.nombreHilo) FROM Matricula m",
				MatriculaDTO.class);
		return query.getResultList();

	}

}
