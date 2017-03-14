package br.com.tresmaria.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tresmaria.ws.entity.Endereco;
import br.com.tresmaria.ws.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco salvar(Endereco endereco){
		return enderecoRepository.saveAndFlush(endereco);
	}
	
	public List<Endereco> listar(){
		return enderecoRepository.findAll();
	}
	
	public void remover(Endereco endereco){
		enderecoRepository.delete(endereco);
	}
	
	public Endereco buscar(Endereco endereco){
		return enderecoRepository.findOne(endereco.getId());
	}
}
