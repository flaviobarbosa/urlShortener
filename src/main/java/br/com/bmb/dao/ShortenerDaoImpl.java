package br.com.bmb.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.bmb.model.UrlResource;

@Repository
public class ShortenerDaoImpl implements ShortenerDao {

	@Autowired
	EntityManager entityManager;

	@Override
	public void save(UrlResource urlResource) {
		entityManager.persist(urlResource);
	}

	@Override
	public boolean isAliasAvailable(String alias) {
		try { 
			entityManager.createNamedQuery(UrlResource.FIND_BY_ALIAS)
						 .setParameter("alias", alias)
						 .getSingleResult();
			
			return false;
		} catch (NoResultException e) {
			return true;
		}		
	}
}
