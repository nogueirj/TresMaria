package br.com.tresmaria.ws.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tresmaria.ws.contract.IServicoService;
import br.com.tresmaria.ws.entity.Servico;
import br.com.tresmaria.ws.model.ServicoDto;
import br.com.tresmaria.ws.projections.ServicoProjection;
import br.com.tresmaria.ws.repository.ServicoRepository;

@Service
public class ServicoService implements IServicoService{

	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private ServicoProjection projetor;
	
	public Servico salvar(Servico servico){
		return servicoRepository.saveAndFlush(servico);
	}
	
	public Collection<ServicoDto> listar(){
		Collection<ServicoDto> servicos = servicoRepository.findAll().stream().map(projetor.projectionServico).collect(Collectors.<ServicoDto> toList());
		return servicos;
	}
	
	public void remover(Servico servico){
		servicoRepository.delete(servico);
	}
	
	public Servico buscar(Servico servico){
		return servicoRepository.findOne(servico.getId());
	}
}
