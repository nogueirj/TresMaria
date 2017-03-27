package br.com.tresmaria.ws.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tresmaria.ws.contract.IContatoService;
import br.com.tresmaria.ws.entity.Contato;
import br.com.tresmaria.ws.model.ContatoDto;
import br.com.tresmaria.ws.projections.ContatoProjection;
import br.com.tresmaria.ws.repository.ContatoRepository;

@Service
public class ContatoService implements IContatoService{

	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private ContatoProjection projetor;
	
	public Contato salvar(Contato contato){
		return contatoRepository.saveAndFlush(contato);
	}
	
	public List<ContatoDto> listar(){
		return contatoRepository.findAll().stream().map(projetor.contatoProjection).collect(Collectors.<ContatoDto> toList());
	}
	
	public void remover(Contato contato){
		contatoRepository.delete(contato);
	}
	
	public Contato buscar(Contato contato){
		return contatoRepository.findOne(contato.getId());
	}
}
