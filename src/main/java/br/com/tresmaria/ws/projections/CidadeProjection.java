/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tresmaria.ws.projections;

import br.com.tresmaria.ws.entity.Cidade;
import br.com.tresmaria.ws.model.CidadeDto;
import java.util.function.Function;
import org.springframework.stereotype.Controller;

/**
 *
 * @author julionogueira
 */
@Controller
public class CidadeProjection {
    public Function<Cidade, CidadeDto> projection = (Cidade cidade) -> {
        CidadeDto dto = new CidadeDto();
        dto.cidadeMunicipio = cidade.getNome();
        dto.estado = cidade.getIdEstado().getNome();
        dto.UF = cidade.getIdEstado().getUf();
        dto.idEstado = cidade.getIdEstado().getId();
        dto.id = cidade.getId();
        return dto;
    };
}
