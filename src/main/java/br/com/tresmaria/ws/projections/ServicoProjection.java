package br.com.tresmaria.ws.projections;

import java.util.Date;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import br.com.tresmaria.ws.entity.Preco;
import br.com.tresmaria.ws.model.PrecoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.tresmaria.ws.entity.Servico;
import br.com.tresmaria.ws.model.ServicoDto;


@Controller
public class ServicoProjection{
	
	public Function<Servico, ServicoDto> project = new Function<Servico, ServicoDto>() {

		@Autowired
		private PrecoProjection projection;

		@Override
		public ServicoDto apply(Servico t) {
			ServicoDto dto = new ServicoDto();
			dto.id = t.getId();
			dto.descricao = t.getDescricao();
			Preco p = t.getPrecoCollection()
					.stream()
					.filter(x -> x.getDataHoraCadastro().after(new Date())  && x.getDataHoraFimVigencia().before(new Date()))
					.findAny()
					.get();

			dto.valor = p.getValor();
			dto.idPreco = Optional.of(p.getId());
			dto.precos = t.getPrecoCollection()
					.stream()
					.map(projection.project)
					.collect(Collectors.<PrecoDto> toList());
			return dto;
		}
	};
}