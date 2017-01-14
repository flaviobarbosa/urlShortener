package br.com.bmb.service;

import javax.persistence.NoResultException;

import org.springframework.dao.DataIntegrityViolationException;

import br.com.bmb.model.UrlResource;

public interface ShortenerService {

	public UrlResource getLongUrlForAlias(String alias) throws NoResultException;
	public UrlResource create(String basePath, UrlResource url) throws DataIntegrityViolationException;
}
