package br.com.tresmaria.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tresmaria.entity.ContatoXServico;
import br.com.tresmaria.ws.repository.ContatoXServicoRepository;

@Service
public class ContatoXServicoService {

	@Autowired
	private ContatoXServicoRepository contatoxservicorepository;
	
	public ContatoXServico salvar(ContatoXServico contatoxservico){
		return contatoxservicorepository.saveAndFlush(contatoxservico);
	}
	
	public List<ContatoXServico> listar(){
		return contatoxservicorepository.findAll();
	}
	
	public void remover(ContatoXServico contatoxservico){
		contatoxservicorepository.delete(contatoxservico);
	}
	
	public ContatoXServico buscar(ContatoXServico contatoxservico){
		return contatoxservicorepository.findOne(contatoxservico.getId());
	}
}
