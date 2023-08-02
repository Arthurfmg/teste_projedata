package br.com.projedata.teste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Funcionario extends Pessoa{
	
	private BigDecimal salario;
	private String funcao;
	
	public Funcionario() {
	}
	
	public Funcionario(String nome, LocalDate dataNasc, BigDecimal salario, String funcao) {
		super();
		super.setNome(nome);
		super.setDataNasc(dataNasc);
		this.salario = salario;
		this.funcao = funcao;
	}

	public BigDecimal getSalario() {
		return salario;
	}
	
	public String getFuncao() {
		return funcao;
	}
	
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(funcao, salario);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(funcao, other.funcao) && Objects.equals(salario, other.salario);
	}
}
