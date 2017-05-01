package br.com.tresmaria.ws.contract;

import br.com.tresmaria.ws.model.PrecoDto;

/**
 * Created by julionogueira on 03/04/17.
 */
public interface IPrecoService {

    PrecoDto buscar(long idPreco);
}
