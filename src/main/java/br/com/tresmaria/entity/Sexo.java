package br.com.tresmaria.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity(name="Sexo")
public class Sexo {

	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	private char Sigla;
	
	private String Descricao;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public char getSigla() {
		return Sigla;
	}

	public void setSigla(char sigla) {
		Sigla = sigla;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	
	public Sexo() {
	}
}
