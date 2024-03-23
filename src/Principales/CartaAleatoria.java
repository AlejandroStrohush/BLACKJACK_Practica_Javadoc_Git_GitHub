package Principales;

import java.util.Random;

/**
 * La funcion de esta clase es crear de manera aleatoria cartas con los siguientes parametros
 * 
 * @author Alex
 * @version JavaSE-17
 */

public class CartaAleatoria {
	private String[] valor = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "AS" };
	private String[] simbolo = { "Treboles", "Corazones", "Diamantes", "Picas" };
	private Random random;

	public CartaAleatoria() {
		random = new Random();
	}

	public String obtenerValorAleatoria() {
		return valorAleatorio();
	}

	public String obtenerSimboloAleatoria() {
		return simboloAleatorio();
	}

	// Este metodo es para conseguir aleatoriamente el valor osea -
	// 2,3,4,5,6,7,8,9,10,J,Q,K,AS
	private String valorAleatorio() {
		int indice = random.nextInt(valor.length);
		return valor[indice];
	}

	// Este metodo es para conseguir aleatoriamente el simbolo osea - Corazon,
	// picas, diamantes o treboles
	private String simboloAleatorio() {
		int indice = random.nextInt(simbolo.length);
		return simbolo[indice];
	}
}
