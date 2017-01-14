package br.com.bmb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bmb.model.UrlResource;
import br.com.bmb.service.ShortenerService;
import br.com.bmb.wrapper.ErrorWrapper;

@RestController
public class ShortenerControllerImpl implements ShortenerController {
	
	@Autowired
	ShortenerService service;
	
	@Autowired
	EmbeddedWebApplicationContext server;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "Up and running!";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(HttpServletRequest req, @RequestBody UrlResource urlResource) {
		
		String basePath = req.getScheme() + "://" + req.getServerName();
		
		try {
			service.create(basePath, urlResource);
		} catch (DataIntegrityViolationException  e) {
			ErrorWrapper wrapper = new ErrorWrapper(urlResource.getAlias(), "001", "CUSTOM ALIAS ALREADY EXISTS");
			
			return new ResponseEntity<ErrorWrapper>(wrapper, HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<UrlResource>(urlResource, HttpStatus.OK);
	}
}
