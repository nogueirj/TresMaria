/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tresmaria.ws.factory;

import br.com.tresmaria.ws.entity.Cidade;
import br.com.tresmaria.ws.entity.Estado;
import br.com.tresmaria.ws.model.CidadeDto;
import br.com.tresmaria.ws.repository.EstadoRepository;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author julionogueira
 */
public class CidadeFactory {
    
    @Autowired
    private EstadoRepository estadoRepository;
    
    public Function<CidadeDto, Cidade> factory = (CidadeDto dto) -> {
        Cidade cidade = new Cidade();
        cidade.setIdEstado(estadoRepository.findOne(dto.idEstado));
        cidade.setNome(dto.cidadeMunicipio);
        cidade.setUf(dto.UF);
        return cidade;
    };
}
