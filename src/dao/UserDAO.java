package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entity.User;
import utils.JpaUtils;

public class UserDAO {
	private EntityManager em;

	public UserDAO() {
		this.em = JpaUtils.getEntityManager();
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	public User create(User entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	public User update(User entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	public User remove(String id) {
		try {
			User entity = this.findById(id);
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	public User findById(String id) {
		User entity = em.find(User.class, id);
		return entity;
	}

	public List<User> getAll() {
		String jpql = "FROM User";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		List<User> lst = query.getResultList();
		return lst;

	}

}
