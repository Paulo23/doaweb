package br.unifor.pin.doaweb.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.doaweb.entity.Usuarios;
import br.unifor.pin.doaweb.exceptions.DAOException;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UsuariosDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Usuarios usuario){
		entityManager.persist(usuario);
	}
	
	public void atualizar(Usuarios usuario) {
		entityManager.merge(usuario);
	}

	public Usuarios buscarPorEmail(String email) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuarios> criteriaQuery = criteriaBuilder
				.createQuery(Usuarios.class);
		Root<Usuarios> usuarios = criteriaQuery.from(Usuarios.class);
		criteriaQuery.where(criteriaBuilder.equal(
				usuarios.<String> get("email"), email));

		Query query = entityManager.createQuery(criteriaQuery);
		try {
			return (Usuarios) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Usuarios buscarPorEmailSenha(String email, String senha) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuarios> criteriaQuery = criteriaBuilder
				.createQuery(Usuarios.class);
		Root<Usuarios> usuarios = criteriaQuery.from(Usuarios.class);
		Predicate restriction = criteriaBuilder.and(
				criteriaBuilder.equal(usuarios.<String> get("email"), email),
				criteriaBuilder.equal(usuarios.<String> get("senha"), senha));
		criteriaQuery.where(criteriaBuilder.and(restriction));

		Query query = entityManager.createQuery(criteriaQuery);
		try {
			return (Usuarios) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Usuarios buscaPorId(Integer id) throws DAOException {
		String jpql = "select u from Usuarios u where u.id = :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", id);
		try {
			return (Usuarios) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

}
