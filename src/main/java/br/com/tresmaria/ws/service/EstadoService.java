package br.com.tresmaria.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tresmaria.ws.entity.Estado;
import br.com.tresmaria.ws.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado salvar(Estado estado){
		return estadoRepository.saveAndFlush(estado);
	}
	
	public Collection<Estado> listar(){
		return estadoRepository.findAll();
	}
	
	public void remover(Estado estado){
		estadoRepository.delete(estado);
	}
	
	public Estado buscar(Estado estado){
		return estadoRepository.findOne(estado.getId());
	}
}
