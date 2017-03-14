package br.com.tresmaria.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tresmaria.entity.Pessoa;
import br.com.tresmaria.ws.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repositoryPessoa;
	
	public Pessoa salvar(Pessoa pessoa){
		return repositoryPessoa.saveAndFlush(pessoa);
	}
	
	public List<Pessoa> listar(){
		return repositoryPessoa.findAll();
	}
	
	public void remover(Pessoa pessoa){
		repositoryPessoa.delete(pessoa);
	}
	
	public Pessoa buscar(Pessoa pessoa){
		return repositoryPessoa.findOne(pessoa.getId());
	}
}
