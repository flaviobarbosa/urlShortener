package br.com.bmb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.bmb.model.UrlResource;

public interface ShortenerController {

	public String index();
	public ResponseEntity<?> create(HttpServletRequest req, @RequestBody UrlResource urlResource);
	public ResponseEntity<?> getLongUrlForAlias(String alias);
	public ResponseEntity<?> getTopTen();
}
