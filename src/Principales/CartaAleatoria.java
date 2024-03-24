package Principales;

import java.util.Random;

/**
 * La unica funcion de esta clase es pasar parametros de manera aleatoria para
 * la creacion de las cartas, el valor y su simbolo, ejemplo: J y Diamantes
 * 
 * 
 * @version 1.0.0
 * @since 1.0
 * @author Alejandro Strohush Loyish
 */

public class CartaAleatoria {
	private String[] valor = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "AS" };
	private String[] simbolo = { "Treboles", "Corazones", "Diamantes", "Picas" };
	private Random random;

    /**
     * Obtiene aleatoriamente el valor de una carta.
     * 
     * @return Valor de la carta aleatorio.
     */
	public String obtenerValorAleatoria() {
		return valorAleatorio();
	}

	/**
	 * Constructor de la clase CartaAleatoria.
	 * Inicializa una instancia de la clase Random para generar números aleatorios.
	 */
	public CartaAleatoria() {
		random = new Random();
	}
	
    /**
     * Obtiene aleatoriamente el símbolo de una carta.
     * 
     * @return Símbolo de la carta aleatoria.
     */
	public String obtenerSimboloAleatoria() {
		return simboloAleatorio();
	}

	// Este metodo es para conseguir aleatoriamente el valor -
	// 2,3,4,5,6,7,8,9,10,J,Q,K o AS
	private String valorAleatorio() {
		int indice = random.nextInt(valor.length);
		return valor[indice];
	}

	// Este metodo es para conseguir aleatoriamente el simbolo - Corazon, picas,
	// diamantes o treboles
	private String simboloAleatorio() {
		int indice = random.nextInt(simbolo.length);
		return simbolo[indice];
	}
}
