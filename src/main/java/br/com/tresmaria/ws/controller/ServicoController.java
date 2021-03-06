package br.com.tresmaria.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tresmaria.ws.contract.IServicoService;
import br.com.tresmaria.ws.model.ServicoDto;

@RestController
public class ServicoController {

	@Autowired
	private IServicoService servicoService;

	@RequestMapping(value = "/servicos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<ServicoDto>> servicos() {
		Collection<ServicoDto> servicos = servicoService.listar();
		return new ResponseEntity<Collection<ServicoDto>>(servicos, HttpStatus.OK);
	}

	@RequestMapping(value = "/cadastrar-servico", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServicoDto> cadastrar(@RequestBody ServicoDto servico) {
		ServicoDto servicoCadastrado = servicoService.salvar(servico);
		return new ResponseEntity<ServicoDto>(servicoCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/alterar-servico", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServicoDto> alterar(@RequestBody ServicoDto servico) {
		ServicoDto servicoCadastrado = servicoService.alterar(servico);
		return new ResponseEntity<ServicoDto>(servicoCadastrado, HttpStatus.OK);
	}

	@RequestMapping(value = "/excluir-servico/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> remover(@PathVariable("id") long idServico) {
		ServicoDto servico = servicoService.buscar(idServico);
		if (servico != null) {
			servicoService.remover(servico);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}