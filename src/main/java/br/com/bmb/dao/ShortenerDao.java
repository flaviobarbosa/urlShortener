package br.com.bmb.dao;

import javax.persistence.NoResultException;

import br.com.bmb.model.UrlResource;

public interface ShortenerDao {

	public void save(UrlResource url);
	public UrlResource findByAlias(String alias) throws NoResultException;
	
}
