package br.com.tresmaria.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ContatoXServico")
public class ContatoXServico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="Id")
	private Long Id;
	
	@JoinColumn(name="IdContato", referencedColumnName="Id")
	@ManyToOne(optional=false)
	private Contato IdContato;
	
	@JoinColumn(name="IdServico", referencedColumnName="Id")
	@ManyToOne(optional=false)
	private Servico IdServico;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Contato getIdContato() {
		return IdContato;
	}

	public void setIdPreco(Contato idContato) {
		IdContato = idContato;
	}

	public Servico getIdServico() {
		return IdServico;
	}

	public void setIdServico(Servico idServico) {
		IdServico = idServico;
	}
	
	public ContatoXServico() {
	}
}
