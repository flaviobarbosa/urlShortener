package br.com.bmb.dao;

import java.util.ArrayList;
import java.util.List;

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
	public UrlResource findByAlias(String alias) throws NoResultException {
		try { 
			UrlResource urlResource = 
					(UrlResource) entityManager.createNamedQuery(UrlResource.FIND_BY_ALIAS)
											   .setParameter("alias", alias)
											   .getSingleResult();
			
			return urlResource;
		} catch (NoResultException e) {
			throw e;
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UrlResource> findTopTen() {
		try {
			List<UrlResource> urlResources = (List<UrlResource>) entityManager.createNamedQuery(UrlResource.FIND_ORDERED_BY_REQUESTS)
																			  .setMaxResults(10)
																			  .getResultList();
			return urlResources;
			
		} catch (NoResultException e) {
			return new ArrayList<UrlResource>();
		}
	}
}
