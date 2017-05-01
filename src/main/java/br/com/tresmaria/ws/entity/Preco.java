package br.com.tresmaria.ws.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name="Preco")
public class Preco implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Id")
	private Long id;
	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	@Basic(optional = false)
	@NotNull
	@Column(name = "Valor")
	private BigDecimal valor;
	@Basic(optional = false)
	@NotNull
	@Column(name = "DataHoraCadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraCadastro;
	@Column(name = "DataHoraFimVigencia")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraFimVigencia;
	@JoinColumn(name = "IdServico", referencedColumnName = "Id")
	@ManyToOne(optional = false)
	private Servico idServico;

	public Preco() {
	}

	public Preco(Long id) {
			this.id = id;
	}

	public Preco(Long id, BigDecimal valor, Date dataHoraCadastro) {
			this.id = id;
			this.valor = valor;
			this.dataHoraCadastro = dataHoraCadastro;
	}

	public Long getId() {
			return id;
	}

	public void setId(Long id) {
			this.id = id;
	}

	public BigDecimal getValor() {
			return valor;
	}

	public void setValor(BigDecimal valor) {
			this.valor = valor;
	}

	public Date getDataHoraCadastro() {
			return dataHoraCadastro;
	}

	public void setDataHoraCadastro(Date dataHoraCadastro) {
			this.dataHoraCadastro = dataHoraCadastro;
	}

	public Servico getIdServico() {
			return idServico;
	}

	public void setIdServico(Servico idServico) {
			this.idServico = idServico;
	}

	public Date getDataHoraFimVigencia() {
		return dataHoraFimVigencia;
	}

	public void setDataHoraFimVigencia(Date dataHoraFimVigencia) {
		this.dataHoraFimVigencia = dataHoraFimVigencia;
	}

	@Override
	public int hashCode() {
			int hash = 0;
			hash += (id != null ? id.hashCode() : 0);
			return hash;
	}

	@Override
	public boolean equals(Object object) {
			if (!(object instanceof Preco)) {
					return false;
			}
			Preco other = (Preco) object;
			if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
					return false;
			}
			return true;
	}

	@Override
	public String toString() {
			return "br.com.tresmaria.entity.Preco[ id=" + id + " ]";
	}
}
