package br.com.projedata.teste;

import java.time.LocalDate;
import java.util.Objects;

public class Pessoa {
	
	private String nome;
	private LocalDate dataNasc;
	
	public Pessoa() {
	}
	
	public Pessoa(String nome, LocalDate dataNasc) {
		this.nome = nome;
		this.dataNasc = dataNasc;
	}

	public String getNome() {
		return nome;
	}
	
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataNasc, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(dataNasc, other.dataNasc) && Objects.equals(nome, other.nome);
	}
}
