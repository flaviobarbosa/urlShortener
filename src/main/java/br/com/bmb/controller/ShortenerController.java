package br.com.bmb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortenerController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "Up and running!";
	}
}
