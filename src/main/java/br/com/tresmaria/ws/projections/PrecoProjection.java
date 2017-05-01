package br.com.tresmaria.ws.projections;

import br.com.tresmaria.ws.entity.Preco;
import br.com.tresmaria.ws.model.PrecoDto;

import java.util.function.Function;

/**
 * Created by julionogueira on 04/04/17.
 */
public class PrecoProjection {

    public Function<Preco, PrecoDto> project = new Function<Preco, PrecoDto>() {
        @Override
        public PrecoDto apply(Preco preco) {
            PrecoDto dto = new PrecoDto();
            dto.id = preco.getId();
            dto.valor = preco.getValor();
            dto.dataHoraCadastro = preco.getDataHoraCadastro();
            dto.dataHoraFimVigencia = preco.getDataHoraFimVigencia();
            return dto;
        }
    };
}
