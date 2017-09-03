package br.com.tresmaria.ws.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

public class ServicoDto {
	
	public Long id;
	
	@NotBlank(message="Descrição não pode ser vazio.")
	public String descricao;
	
	@Min(value=1, message="Valor tem que ser maior que R$ 1,00.")
	public BigDecimal valor;

	public Optional<Long> idPreco;

    public Collection<Long> IdsPrecos;
        
	public Collection<PrecoDto> precos;
}
