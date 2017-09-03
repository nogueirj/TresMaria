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
	
	@Autowired
	private PrecoProjection projection;
	
	public Function<Servico, ServicoDto> project = (Servico servico) -> {

			ServicoDto dto = new ServicoDto();
			dto.id = servico.getId();
			dto.descricao = servico.getDescricao();
			Preco p = servico.getPrecoCollection()
					.stream()
					.filter(x -> x.getDataHoraCadastro().before(new Date()))
					.findAny()
					.get();

			dto.valor = p.getValor();
			dto.idPreco = Optional.ofNullable(p.getId());
			dto.precos = servico.getPrecoCollection()
					.stream()
					.map(projection.project)
					.collect(Collectors.<PrecoDto> toList());
			dto.IdsPrecos = servico.getPrecoCollection().stream().map(Preco::getId).collect(Collectors.toList());
			return dto;
	};
}