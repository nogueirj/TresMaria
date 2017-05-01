package br.com.tresmaria.ws.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by julionogueira on 03/04/17.
 */
public class PrecoDto {
    public long id;
    public BigDecimal valor;
    public Date dataHoraCadastro;
    public Date dataHoraFimVigencia;

}
