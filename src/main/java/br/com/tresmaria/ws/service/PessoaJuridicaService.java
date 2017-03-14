package br.com.tresmaria.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tresmaria.ws.entity.PessoaJuridica;
import br.com.tresmaria.ws.repository.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaService {
	@Autowired
	private PessoaJuridicaRepository repositoryPessoaJuridica;
	
	public PessoaJuridica salvar(PessoaJuridica pessoa){
		return repositoryPessoaJuridica.saveAndFlush(pessoa);
	}
	
	public List<PessoaJuridica> listar(){
		return repositoryPessoaJuridica.findAll();
	}
	
	public void remover(PessoaJuridica pessoa){
		repositoryPessoaJuridica.delete(pessoa);
	}
	
	public PessoaJuridica buscar(Long IdPessoa){
		return repositoryPessoaJuridica.findOne(IdPessoa);
	}
	
}
