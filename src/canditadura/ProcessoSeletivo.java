package canditadura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	public static void main(String[] args) {
		String [] candidatos = {"FELIPE", "MARCELO", "LUIZ", "OTAVIO", "RICARDO"};
		
		for(String candidato: candidatos) {
			entrandoEmContato(candidato);
		}
	}
	
	static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		
		do {
			atendeu = atender();
			continuarTentando = !atender();
			if(continuarTentando) {
				tentativasRealizadas++;
			} else {
				System.out.println("Contato realizado com sucesso");
			}
			
		} while(continuarTentando && tentativasRealizadas < 3);
		
		if(atendeu) {
			System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas);
		} else {
			System.out.println("Não conseguimos contato");
		}
	}
	
	static boolean atender() {
		return new Random().nextInt(3) == 1;
	}
	
	static void imprimirSelecionados() {
		String [] candidatos = {"FELIPE", "MARCELO", "LUIZ", "OTAVIO", "RICARDO"};
		System.out.println("Imprimento a lista de candidatos informando o indice do elemento");
		for(int indice=0; indice < candidatos.length; indice ++) {
			System.out.println("O candidato de n° " + (indice + 1) + " é "+ candidatos[indice]);
		}
		
		// forma abreviada com for each
		
		for(String candidato: candidatos) {
			System.out.println("O candidato selecionado foi " + candidato);
		}
	}
	
	static void selecaoCandidato() {
		String [] candidatos = {"FELIPE", "MARCELO", "LUIZ", "OTAVIO", "RICARDO", "HELLENA", "MIRELA", "DANIELA", "HENRIQUE", "MARCOS"};
		
		int candidatosSelecionados = 0;
		
		int candidatosAtual = 0;
		
		double salarioBase = 2000.0;
		
		while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
			String candidato = candidatos[candidatosAtual];
			
			double salarioPretendido = valorPretendido();
			
			System.out.println("O candidato " + candidato + " Solicitou este valor de salário " + salarioPretendido);
			
			if(salarioBase >= salarioPretendido) {
				System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
				candidatosSelecionados++;
			}
			
			candidatosAtual++;
		}
		
		
		System.out.println("Finalistas: " + candidatosSelecionados);
	}
	
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800,2200);
	}
	
	static void analisarCandidato(double salarioPretendido) {
		double salarioBase = 2000.0;
		
		if(salarioBase > salarioPretendido) {
			System.out.println("LIGAR PARA O CANDIDATO");
		} else if(salarioBase == salarioPretendido) {
			System.out.println("LIGAR PARA CANDIDATO COM CONTRA PROPOSTA");
		} else {
			System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
		}
	}
}
