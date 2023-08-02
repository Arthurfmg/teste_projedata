package br.com.projedata.teste;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class IniflexTest {
	
	//formata o tipo de data
	static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	//adiciona ponto em milhar e virgula em casa decimal
	static Locale locale = new Locale("pt","BR");
	static NumberFormat decimal = NumberFormat.getNumberInstance(locale);

	public static void main(String[] args) {
		
		ArrayList<Funcionario> funcionarios = new ArrayList();
		
		//Adiciona os funcionários na ordem
		funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), 
				BigDecimal.valueOf(2009.44), "Operador"));
		funcionarios.add(new Funcionario("João", LocalDate.of(1990, 05, 12), 
				BigDecimal.valueOf(2284.38), "Operador"));
		funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 05, 02), 
				BigDecimal.valueOf(9836.14), "Coordenador"));
		funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), 
				BigDecimal.valueOf(19119.88), "Diretor"));
		funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 01, 05), 
				BigDecimal.valueOf(2234.68), "Recepcionista"));
		funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), 
				BigDecimal.valueOf(1582.72), "Operador"));
		funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 03, 31), 
				BigDecimal.valueOf(4071.84), "Contador"));
		funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 07, 8), 
				BigDecimal.valueOf(3017.45), "Gerente"));
		funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 05, 24), 
				BigDecimal.valueOf(1606.85), "Eletricista"));
		funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 02), 
				BigDecimal.valueOf(2799.93), "Gerente"));
		
		//remove João
		funcionarios.remove(1);
		
		Scanner entrada = new Scanner(System.in);
		int numero = 0;
		
		do {
			System.out.println("Escolha um número entre 1 a 8\n"
					+ "1 - Imprime as informações de todos os funcionários\n"
					+ "2 - Aumenta em 10% o salário dos funcionários\n"
					+ "3 - Imprime os funcionários agrupados por função\n"
					+ "4 - Imprime os funcionários que fazem aniversário no mês 10 e 12\n"
					+ "5 - Imprime o funcionário mais velho\n"
					+ "6 - Imprime os funcionários em ordem alfabética\n"
					+ "7 - Imprime o total dos salários dos funcionários\n"
					+ "8 - Quantos salários mínimos ganha cada funcionário\n"
					+ "0 - Sair");
			numero = entrada.nextInt();
			
			switch(numero) {
				case 1:
					imprimeFuncionarios(funcionarios);
					System.out.println("-------------------------");
					break;
				case 2:
					aumentoSalario(funcionarios);
					System.out.println("-------------------------");
					break;
				case 3:
					mapFuncionarios(funcionarios);
					System.out.println("-------------------------");
					break;
				case 4:
					imprimeAniversarios(funcionarios);
					System.out.println("-------------------------");
					break;
				case 5:
					funcionarioMaisVelho(funcionarios);
					System.out.println("-------------------------");
					break;
				case 6:
					ordemAlfabetica(funcionarios);
					System.out.println("-------------------------");
					break;
				case 7:
					totalSalario(funcionarios);
					System.out.println("-------------------------");
					break;
				case 8:
					qtdSalarioMinimo(funcionarios);
					System.out.println("-------------------------");
					break;
				default:
					break;
			}
		} while(numero != 0);
	}
	
	
	//Imprime todos os funcionários com suas informações
	public static void imprimeFuncionarios(ArrayList<Funcionario> funcionarios) {
		for(int i = 0; i < funcionarios.size(); i++) {
			System.out.println(funcionarios.get(i).getNome());
			System.out.println(funcionarios.get(i).getDataNasc().format(formato));
			System.out.println(decimal.format(funcionarios.get(i).getSalario()));
			System.out.println(funcionarios.get(i).getFuncao());
			System.out.println("-------------------------");
		}
	}
	
	
	//Adiciona 10% ao salário de todos os funcionários
	public static void aumentoSalario(ArrayList<Funcionario> funcionarios) {
		for(int i = 0; i < funcionarios.size(); i++) {
			BigDecimal salario = funcionarios.get(i).getSalario();
			BigDecimal dez = new BigDecimal("0.1");
			BigDecimal percentual = salario.multiply(dez);
			BigDecimal aumento = salario.add(percentual);
			funcionarios.get(i).setSalario(aumento);
			
			System.out.println(funcionarios.get(i).getNome());
			System.out.println(funcionarios.get(i).getDataNasc().format(formato));
			System.out.println(decimal.format(funcionarios.get(i).getSalario()));
			System.out.println(funcionarios.get(i).getFuncao());
			System.out.println("-------------------------");
		}
	}
	
	
	//Insere os funcionários em um map e imprime a lista separada por função
	public static void mapFuncionarios(ArrayList<Funcionario> funcionarios) {
		//Cria o Map
		Map<String, ArrayList<Funcionario>> mapaFuncionarios = new HashMap<>();
		
		//Popula o Map
		for(int i = 0; i < funcionarios.size(); i++) {
			String funcao = funcionarios.get(i).getFuncao();
			mapaFuncionarios.put(funcao, funcionarios);
		}
		
		//Imprime funcionário por função
		for(Map.Entry<String, ArrayList<Funcionario>> entry : mapaFuncionarios.entrySet()) {
			System.out.println("----------"+ entry.getKey() +"----------");
			for(Funcionario func : entry.getValue()) {
				if(func.getFuncao().equals(entry.getKey())) {
					System.out.println(func.getNome());
				}
			}
		}
	}
	
	
	//Imprime os funcionários que fazem aniversário no mês 10 e 12
	public static void imprimeAniversarios(ArrayList<Funcionario> funcionarios) {
		for(int i = 0; i < funcionarios.size(); i++) {
			if(funcionarios.get(i).getDataNasc().getMonthValue() == 10 || 
					funcionarios.get(i).getDataNasc().getMonthValue() == 12){
				System.out.println(funcionarios.get(i).getNome() + " - " 
					+ funcionarios.get(i).getDataNasc().format(formato));
			}
		}
	}
	
	
	//Imprime o funcionário mais velho
	public static void funcionarioMaisVelho(ArrayList<Funcionario> funcionarios) {
		
		LocalDate diaDeHoje = LocalDate.now();
		int idade = 0;
		
		//compara as datas de nascimento
		Comparator<Funcionario> comparadorIdade = 
				(Funcionario func1, Funcionario func2) -> func1.getDataNasc().compareTo(func2.getDataNasc());
		Collections.sort(funcionarios, comparadorIdade);
		
		int ano = funcionarios.get(0).getDataNasc().getYear();
		idade = diaDeHoje.getYear() - ano;
		
		System.out.println(funcionarios.get(0).getNome() + " - " + idade + " anos");
	}
	
	
	//Coloca e imprime a lista em orde alfabética
	public static void ordemAlfabetica(ArrayList<Funcionario> funcionarios) {
		//compara os nomes
		Comparator<Funcionario> comparadorNome = 
				(Funcionario func1, Funcionario func2) -> func1.getNome().compareTo(func2.getNome());
		Collections.sort(funcionarios, comparadorNome);
		
		for(int i = 0; i < funcionarios.size(); i++) {
			System.out.println(funcionarios.get(i).getNome());
		}
	}
	
	
	//Imprime o total de salários dos funcionários
	public static void totalSalario(ArrayList<Funcionario> funcionarios) {
		BigDecimal totalSalario = new BigDecimal("0");
		
		for(int i = 0; i < funcionarios.size(); i++) {
			BigDecimal salario = funcionarios.get(i).getSalario();
			totalSalario = totalSalario.add(salario);
		}
		
		System.out.println("O Total dos salários dos funcionários é: R$" + totalSalario);
	}
	
	
	//Imprime quantos salários mínimos a pessoa ganha
	public static void qtdSalarioMinimo(ArrayList<Funcionario> funcionarios) {
		BigDecimal qtdSalarios;
		BigDecimal salarioMinimo = new BigDecimal("1212.00");
		
		for(int i = 0; i < funcionarios.size(); i++) {
			BigDecimal salario = funcionarios.get(i).getSalario();
			String nome = funcionarios.get(i).getNome();
			qtdSalarios = salario.divide(salarioMinimo, 1, RoundingMode.HALF_UP);
			System.out.println(nome + " recebe " + qtdSalarios + " salários mínimos");
		}
	}
}
