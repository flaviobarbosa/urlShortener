package br.com.bmb.service;

import org.springframework.dao.DataIntegrityViolationException;

import br.com.bmb.model.UrlResource;

public interface ShortenerService {

	public UrlResource create(String basePath, UrlResource url) throws DataIntegrityViolationException;
}
