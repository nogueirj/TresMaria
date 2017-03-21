package br.com.tresmaria.ws.entity;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Servico {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="Id")
	private Long Id;
	
	@Basic(optional=false)
	@NotNull
	@Size(min=1, max = 300)
	@Column(name="Descricao")
	private String Descricao;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="IdServico")
	private Collection<ContatoXServico> contatoXServicoCollection;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="IdServico")
	private Collection<Preco> precoCollection;
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	
	
	@XmlTransient
	public Collection<ContatoXServico> getContatoXServicoCollection() {
		return contatoXServicoCollection;
	}
	
	public void setContatoXServicoCollection(Collection<ContatoXServico> contatoXServicoCollection) {
		this.contatoXServicoCollection = contatoXServicoCollection;
	}
	
	@XmlTransient
	public Collection<Preco> getPrecoCollection() {
		return precoCollection;
	}

	public void setPrecoCollection(Collection<Preco> precoCollection) {
		this.precoCollection = precoCollection;
	}

	public Servico() {
	}
}
