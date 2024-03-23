package Principales;

/**
 * Esta clase es solo para crear el objeto carta, de parametros recibira de la clase CartaAleatoria
 * su unica función es ser almacenada en el arrayList de cada jugador para poder ser usadas
 * 
 * @author Alex
 * @version JavaSE-17
 */
public class Carta {

	private String valores;
	private String simbolo;
	private int puntos;

	public Carta(String valores, String simbolo) {
		super();
		this.valores = valores;
		this.simbolo = simbolo;
	}

	public String getValores() {
		return valores;
	}

	public void setValores(String valores) {
		this.valores = valores;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	@Override
	public String toString() {
		return "Carta [valores=" + valores + ", simbolo=" + simbolo + "]";
	}

}
