package br.com.tresmaria.ws.projections;

import java.util.function.Function;

import org.springframework.stereotype.Controller;

import br.com.tresmaria.ws.entity.Contato;
import br.com.tresmaria.ws.model.ContatoDto;

@Controller
public class ContatoProjection {
	public Function<Contato, ContatoDto> contatoProjection = (Contato t) -> {
            ContatoDto dto = new ContatoDto();
            dto.pessoaNome = t.getIdPessoa().getNomeRazaoSocial();
            return dto;
        };
}
