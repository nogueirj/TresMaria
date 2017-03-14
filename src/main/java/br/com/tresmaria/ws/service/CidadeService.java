package br.com.tresmaria.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tresmaria.entity.Cidade;
import br.com.tresmaria.ws.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cidade salvar(Cidade cidade){
		return cidadeRepository.saveAndFlush(cidade);
	}
	
	public List<Cidade> listar(){
		return cidadeRepository.findAll();
	}
	
	public void remover(Cidade cidade){
		cidadeRepository.delete(cidade);
	}
	
	public Cidade buscar(Cidade cidade){
		return cidadeRepository.findOne(cidade.getId());
	}
}
