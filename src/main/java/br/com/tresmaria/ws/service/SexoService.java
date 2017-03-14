package br.com.tresmaria.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tresmaria.ws.entity.Sexo;
import br.com.tresmaria.ws.repository.SexoRepository;

@Service
public class SexoService {

	@Autowired
	private SexoRepository sexoRepository;
	
	public Collection<Sexo> listar(){
		return sexoRepository.findAll();
	}
	
	public Sexo buscar(Sexo sexo){
		return sexoRepository.findOne(sexo.getId());
	}
}
