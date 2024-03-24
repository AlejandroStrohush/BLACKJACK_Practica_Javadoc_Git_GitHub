package Principales;

/**
 * Esta clase representa una carta de un juego. Las cartas tienen un valor, un símbolo y pueden 
 * tener asociados puntos.
 * 
 * @version 1.0.0
 * @since 1.0
 * @author Alejandro Strohush Loyish
 */ 
public class Carta {

	private String valores;
	private String simbolo;
	private int puntos;

    /**
     * Constructor de la clase Carta.
     * 
     * @param valores El valor de la carta.
     * @param simbolo El símbolo de la carta.
     */
	public Carta(String valores, String simbolo) {
		super();
		this.valores = valores;
		this.simbolo = simbolo;
	}
	/**
	 * Obtiene el valor de la carta.
	 * 
	 * @return El valor de la carta.
	 */
	public String getValores() {
		return valores;
	}
	/**
	 * Establece el valor de la carta.
	 * 
	 * @param valores El valor de la carta.
	 */
	public void setValores(String valores) {
		this.valores = valores;
	}
	/**
	 * Obtiene el símbolo de la carta.
	 * 
	 * @return El símbolo de la carta.
	 */
	public String getSimbolo() {
		return simbolo;
	}
	/**
	 * Establece el símbolo de la carta.
	 * 
	 * @param simbolo El símbolo de la carta.
	 */
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	/**
	 * Obtiene los puntos asociados a la carta.
	 * 
	 * @return Los puntos de la carta.
	 */
	public int getPuntos() {
		return puntos;
	}
	/**
	 * Establece los puntos asociados a la carta.
	 * 
	 * @param puntos Los puntos de la carta.
	 */
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	@Override
	public String toString() {
		return "Carta [valores=" + valores + ", simbolo=" + simbolo + "]";
	}

}
