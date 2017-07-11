package br.com.tresmaria.ws.projections;

import br.com.tresmaria.ws.entity.Preco;
import br.com.tresmaria.ws.model.PrecoDto;

import java.util.function.Function;
import org.springframework.stereotype.Controller;

/**
 * Created by julionogueira on 04/04/17.
 */
@Controller
public class PrecoProjection {

    public Function<Preco, PrecoDto> project = (Preco preco) -> {
        PrecoDto dto = new PrecoDto();
        dto.id = preco.getId();
        dto.valor = preco.getValor();
        dto.dataHoraCadastro = preco.getDataHoraCadastro();
        dto.dataHoraFimVigencia = preco.getDataHoraFimVigencia();
        return dto;
    };
}
