package br.com.tresmaria.ws.contract;

import java.util.Collection;

import br.com.tresmaria.ws.entity.Contato;
import br.com.tresmaria.ws.model.ContatoDto;

public interface IContatoService {
	
	Collection<ContatoDto> listar();
	
	Contato salvar(Contato contato);
	
	void remover(Contato contato);
	
	Contato buscar(Contato contato);
}
