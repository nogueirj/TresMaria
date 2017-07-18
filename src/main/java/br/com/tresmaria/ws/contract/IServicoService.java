package br.com.tresmaria.ws.contract;

import java.util.Collection;

import br.com.tresmaria.ws.model.ServicoDto;

public interface IServicoService {
	ServicoDto salvar(ServicoDto servico);
	
	Collection<ServicoDto> listar();
	
	void remover(ServicoDto servico);
	
	ServicoDto buscar(long idServico); 
}
