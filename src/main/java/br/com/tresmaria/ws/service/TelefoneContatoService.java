package br.com.tresmaria.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tresmaria.ws.entity.TelefoneContato;
import br.com.tresmaria.ws.repository.TelefoneContatoRepository;

@Service
public class TelefoneContatoService {

	@Autowired
	private TelefoneContatoRepository telefoneContatoRepository;
	
	public TelefoneContato salvar(TelefoneContato telefoneContato){
		return telefoneContatoRepository.saveAndFlush(telefoneContato);
	}
	
	public Collection<TelefoneContato> listar(){
		return telefoneContatoRepository.findAll();
	}
	
	public void remover(TelefoneContato telefoneContato){
		telefoneContatoRepository.delete(telefoneContato);
	}
	
	public TelefoneContato buscar(TelefoneContato telefoneContato){
		return telefoneContatoRepository.findOne(telefoneContato.getId());
	}
}
