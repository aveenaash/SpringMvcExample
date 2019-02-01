package ly.abinash.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ly.abinash.entities.CustomerLoginEntity;

@Repository
public class CustomerLoginRepository {

	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public void save(CustomerLoginEntity loginEntity) {
		entityManager.persist(loginEntity);
	}

	public CustomerLoginEntity getLoginByUsername(String username) {
		Query query = (Query) entityManager
				.createQuery("select cl from CustomerLoginEntity cl where " + "cl.userName = :uname ");
		query.setParameter("uname", username);
		try {
			return (CustomerLoginEntity) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
