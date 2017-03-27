package br.com.tresmaria.ws.contract;

import java.util.Collection;

import br.com.tresmaria.ws.entity.Servico;
import br.com.tresmaria.ws.model.ServicoDto;

public interface IServicoService {
	Servico salvar(Servico servico);
	
	Collection<ServicoDto> listar();
	
	void remover(Servico servico);
	
	Servico buscar(Servico servico);
}
