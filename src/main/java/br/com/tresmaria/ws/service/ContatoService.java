package br.com.tresmaria.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tresmaria.entity.Contato;
import br.com.tresmaria.ws.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;
	
	public Contato salvar(Contato contato){
		return contatoRepository.saveAndFlush(contato);
	}
	
	public List<Contato> listar(){
		return contatoRepository.findAll();
	}
	
	public void remover(Contato contato){
		contatoRepository.delete(contato);
	}
	
	public Contato buscar(Contato contato){
		return contatoRepository.findOne(contato.getId());
	}
}
