package br.com.tresmaria.ws.service;

import java.util.Collection;
import java.util.stream.Stream;

import br.com.tresmaria.ws.contract.IPrecoService;
import br.com.tresmaria.ws.model.PrecoDto;
import br.com.tresmaria.ws.projections.PrecoProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tresmaria.ws.entity.Preco;
import br.com.tresmaria.ws.repository.PrecoRepository;

@Service
public class PrecoService implements IPrecoService{

	@Autowired
	private PrecoRepository precoRepository;

	@Autowired
	private PrecoProjection precoProjection;
	
	public Preco preco(Preco preco){
		return precoRepository.saveAndFlush(preco);
	}
	
	public Collection<Preco> listar(){
		return precoRepository.findAll();
	}
	
	public void remover(Preco preco){
		precoRepository.delete(preco);
	}
	
        @Override
	public PrecoDto buscar(long idPreco){
		return Stream
				.of(precoRepository.findOne(idPreco))
				.map(precoProjection.project)
				.findAny()
				.get();
	}
}
