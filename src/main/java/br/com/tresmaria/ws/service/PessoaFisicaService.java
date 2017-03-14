package br.com.tresmaria.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tresmaria.entity.PessoaFisica;
import br.com.tresmaria.ws.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService {

	@Autowired
	private PessoaFisicaRepository repositoryPessoaFisica;
	
	public PessoaFisica salvar(PessoaFisica pessoa){
		return repositoryPessoaFisica.saveAndFlush(pessoa);
	}
	
	public List<PessoaFisica> listar(){
		return repositoryPessoaFisica.findAll();
	}
	
	public void remover(PessoaFisica pessoa){
		repositoryPessoaFisica.delete(pessoa);
	}
	
	public PessoaFisica buscar(Long IdPessoa){
		return repositoryPessoaFisica.findOne(IdPessoa);
	}
}
