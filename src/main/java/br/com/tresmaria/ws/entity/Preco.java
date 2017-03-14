package br.com.tresmaria.ws.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Preco {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="Id")
	private Long Id;
	
	@JoinColumn(name="IdServico", referencedColumnName="Id")
	@ManyToOne(optional=false)
	private Servico IdServico;
	
	@Basic(optional=false)
	@NotNull
	@Column(name="Valor")
	private Double Valor;

	@Column(name="DataHoraCadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date DataHoraCadastro;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Servico getIdServico() {
		return IdServico;
	}

	public void setIdServico(Servico idServico) {
		IdServico = idServico;
	}

	public Double getPreco() {
		return Valor;
	}

	public void setPreco(Double valor) {
		Valor = valor;
	}
	
	public Preco() {
	}
}
