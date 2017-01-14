package br.com.bmb.service;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bmb.dao.ShortenerDao;
import br.com.bmb.model.Statistic;
import br.com.bmb.model.UrlResource;
import br.com.bmb.util.ShortenerUtil;

@Service
public class ShortenerServiceImpl implements ShortenerService {

	@Autowired
	ShortenerDao dao;
	
	@Override
	@Transactional
	public UrlResource create(String basePath, UrlResource urlResource) throws DataIntegrityViolationException {

		try {
			long startTime = new Date().getTime();
			
			String alias = urlResource.getAlias();
			if(alias == null) {
				alias = createAlias();
				urlResource.setAlias(alias);
			}
			
			urlResource.setShortUrl(basePath + "/u/" + alias);
	
			long endTime = new Date().getTime();
			long totalTime = endTime - startTime;
			
			Statistic statistic = new Statistic(totalTime);
			urlResource.setStatistics(statistic);
			
			dao.save(urlResource);
		} catch (DataIntegrityViolationException e) {
			throw e;
		}
		
		return urlResource;
	}

	private String createAlias() {
		boolean isSearchingForAlias = true;
		String alias = "";

		do {
			alias = ShortenerUtil.createAlias();

			try {
				dao.findByAlias(alias);
			} catch (NoResultException e) {
				isSearchingForAlias = false;
			}
		} while(isSearchingForAlias);

		return alias;
	}

	@Transactional
	@Override
	public UrlResource getLongUrlForAlias(String alias) throws NoResultException {
		try {
			UrlResource urlResource = dao.findByAlias(alias);
			
			updateStatistic(urlResource);
 
			return urlResource; 
		} catch (NoResultException e) {
			throw e;
		}
	}
	
	public void updateStatistic(UrlResource urlResource) {
		Statistic statistic = urlResource.getStatistics();
		
		int numberOfRequests = statistic.getNumberOfRequests() + 1;
		Date lastAccess = new Date();
		
		statistic.setNumberOfRequests(numberOfRequests);
		statistic.setLastAccess(lastAccess);
		
		urlResource.setStatistics(statistic);
		
		dao.save(urlResource);
	}

	@Override
	public List<UrlResource> getTopTen() {
		return dao.findTopTen();
	}

}
