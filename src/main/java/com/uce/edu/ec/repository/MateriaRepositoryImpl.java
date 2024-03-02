package com.uce.edu.ec.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.ec.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = Transactional.TxType.MANDATORY)
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
	}

	@Override
	@Transactional(value = Transactional.TxType.NOT_SUPPORTED)
	public Materia seleccionarPorCodigo(String codigo) {
		// TODO Auto-generated method stub

		TypedQuery<Materia> query = this.entityManager
				.createQuery("SELECT m FROM Materia m WHERE m.codigo = :datoCodigo"	, Materia.class);
		query.setParameter("datoCodigo", codigo);
		return query.getSingleResult();

	}

}
