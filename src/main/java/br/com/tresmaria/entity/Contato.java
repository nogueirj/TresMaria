package br.com.tresmaria.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Contato")
public class Contato {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="Id")
	private Long Id;
	
	@Basic(optional=false)
	@NotNull
	@Column(name="DataHoraContato")
	@Temporal(TemporalType.TIMESTAMP)
	private Date DataHoraContato;
	
	@JoinColumn(name="IdTelefoneContato", referencedColumnName="Id")
	@ManyToOne(optional=false)
	private TelefoneContato IdTelefoneContato;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getDataHoraContato() {
		return DataHoraContato;
	}

	public void setDataHoraContato(Date dataHoraContato) {
		DataHoraContato = dataHoraContato;
	}

	public TelefoneContato getIdTelefoneContato() {
		return IdTelefoneContato;
	}

	public void setIdTelefoneContato(TelefoneContato idTelefoneContato) {
		IdTelefoneContato = idTelefoneContato;
	}
	
	public Contato() {
	}
}
