package br.com.tresmaria.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tresmaria.entity.Servico;
import br.com.tresmaria.ws.service.ServicoService;

@RestController
public class ServicoController {
	
	@Autowired
	private ServicoService servicoService;
	
	@RequestMapping(value="/servicos", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Servico>> servicos(){
		Collection<Servico> servicos = servicoService.listar();
		return new ResponseEntity<Collection<Servico>>(servicos, HttpStatus.OK);
	}
}
