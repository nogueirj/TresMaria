package br.com.tresmaria.ws.service;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tresmaria.ws.entity.Servico;
import br.com.tresmaria.ws.repository.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;
	
	public Servico salvar(Servico servico){
		return servicoRepository.saveAndFlush(servico);
	}
	
	public Collection<Servico> listar(){
		return servicoRepository.findAll();
	}
	
	public void remover(Servico servico){
		servicoRepository.delete(servico);
	}
	
	public Servico buscar(Servico servico){
		return servicoRepository.findOne(servico.getId());
	}
}
