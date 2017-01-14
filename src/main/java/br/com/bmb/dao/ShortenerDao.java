package br.com.bmb.dao;

import br.com.bmb.model.UrlResource;

public interface ShortenerDao {

	public void save(UrlResource url);
	public boolean isAliasAvailable(String alias);
	
}
