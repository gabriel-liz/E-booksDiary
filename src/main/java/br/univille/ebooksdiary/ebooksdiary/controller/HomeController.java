package br.univille.ebooksdiary.ebooksdiary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller public class HomeController {
	@RequestMapping("/") @ResponseBody
	public String index() {
		return "eu n�o acredito";
	}

}





