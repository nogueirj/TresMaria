package br.com.tresmaria.ws.contract;

import br.com.tresmaria.ws.model.CidadeDto;

public interface ICidadeService {
  public void salvar(CidadeDto dto);
  public void alterar(CidadeDto dto);
  public void excluir(Longong Id);
}
