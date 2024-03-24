package Principales;

import java.util.ArrayList;

/**
 * Esta clase es para crear al jugador / dealer y poder manipular sus atributos
 * dentro de la partida, dinero, cantidadApostada, puntos, si tienen AS y el
 * arrayList con las cartas
 * 
 * @version 1.0.0
 * @since 1.0
 * @author Alejandro Strohush Loyish
 */
public class Jugador {

	private int dinero;
	private int cantidadApostada;
	private int puntos;
	private Boolean As = false;
	private ArrayList<Carta> listaCartas;

	/**
	 * Constructor de la clase Jugador.
	 * 
	 * @param dinero El dinero inicial del jugador.
	 */
	public Jugador(int dinero) {
		super();
		this.dinero = dinero;
		this.listaCartas = new ArrayList();

	}

	/**
	 * Obtiene el dinero del jugador.
	 * 
	 * @return El dinero del jugador.
	 */
	public int getDinero() {
		return dinero;
	}

	/**
	 * Establece el dinero del jugador.
	 * 
	 * @param dinero El nuevo valor del dinero del jugador.
	 */
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

    /**
     * Obtiene la lista de cartas del jugador.
     * 
     * @return La lista de cartas del jugador.
     */
	public ArrayList<Carta> getListaCartas() {
		return listaCartas;
	}

    /**
     * Establece la lista de cartas del jugador.
     * 
     * @param listaCartas La nueva lista de cartas del jugador.
     */
	public void setListaCartas(ArrayList<Carta> listaCartas) {
		this.listaCartas = listaCartas;
	}
    /**
     * Añade una carta a la lista de cartas del jugador.
     * 
     * @param carta La carta a añadir.
     */
	public void addCarta(Carta carta) {

		this.listaCartas.add(carta);

	}
    /**
     * Muestra la primera carta del jugador.
     */
	public void verCarta() {

		System.out.println(listaCartas.get(0));

	}
    /**
     * Obtiene la cantidad apostada por el jugador.
     * 
     * @return La cantidad apostada por el jugador.
     */
	public int getCantidadApostada() {
		return cantidadApostada;
	}
    /**
     * Establece la cantidad apostada por el jugador.
     * 
     * @param cantidadApostada La nueva cantidad apostada por el jugador.
     */
	public void setCantidadApostada(int cantidadApostada) {
		this.cantidadApostada = cantidadApostada;
	}
    /**
     * Obtiene los puntos del jugador.
     * 
     * @return Los puntos del jugador.
     */
	public int getPuntos() {
		return puntos;
	}
    /**
     * Establece los puntos del jugador.
     * 
     * @param puntos Los nuevos puntos del jugador.
     */
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
    /**
     * Verifica si el jugador tiene al menos un As.
     * 
     * @return true si el jugador tiene al menos un As, false en caso contrario.
     */
	public Boolean getAs() {
		return As;
	}
	/**
	 * Establece si el jugador tiene al menos un As.
	 * 
	 * @param as true si el jugador tiene al menos un As, false en caso contrario.
	 * @deprecated Este método está marcado como obsoleto, se recomienda usar otro enfoque.
	 * @since 1.0
	 */
	public void setAs(Boolean as) {
	    As = as;
	}

	@Override
	public String toString() {
		return "Jugador [dinero=" + dinero + ", listaCartas=" + listaCartas + ", puntos=\" + puntos]";
	}

}
