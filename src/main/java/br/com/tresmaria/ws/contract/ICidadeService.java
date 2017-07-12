package br.com.tresmaria.ws.contract;

import br.com.tresmaria.ws.model.CidadeDto;
import java.util.List;

public interface ICidadeService {

    void salvar(CidadeDto dto);

    void alterar(CidadeDto dto);

    void excluir(Long Id);

    List<CidadeDto> listar();
}
