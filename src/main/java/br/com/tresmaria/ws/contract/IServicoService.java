package br.com.tresmaria.ws.contract;

import java.util.Collection;

import br.com.tresmaria.ws.entity.Servico;
import br.com.tresmaria.ws.model.ServicoDto;

public interface IServicoService {
	ServicoDto salvar(ServicoDto servico);
	
	Collection<ServicoDto> listar();
	
	void remover(Servico servico);
	
	ServicoDto buscar(long idServico);
}
