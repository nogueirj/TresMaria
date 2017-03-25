package br.com.tresmaria.ws.projections;

import java.util.function.Function;

import org.springframework.stereotype.Controller;

import br.com.tresmaria.ws.entity.Servico;
import br.com.tresmaria.ws.model.ServicoDto;

@Controller
public class ServicoProjection{
	
	public Function<Servico, ServicoDto> projectionServico = new Function<Servico, ServicoDto>() {
		
		@Override
		public ServicoDto apply(Servico t) {
			ServicoDto dto = new ServicoDto();
			dto.id = t.getId();
			dto.descricao = t.getDescricao();
			dto.valor = t.getPrecoCollection().iterator().next().getValor();
			return dto;
		}
	};
}