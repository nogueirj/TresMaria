package br.com.tresmaria.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tresmaria.ws.entity.Preco;
import br.com.tresmaria.ws.repository.PrecoRepository;

@Service
public class PrecoService {

	@Autowired
	private PrecoRepository precoRepository;
	
	public Preco preco(Preco preco){
		return precoRepository.saveAndFlush(preco);
	}
	
	public Collection<Preco> listar(){
		return precoRepository.findAll();
	}
	
	public void remover(Preco preco){
		precoRepository.delete(preco);
	}
	
	public Preco buscar(Preco preco){
		return precoRepository.findOne(preco.getId());
	}
}
