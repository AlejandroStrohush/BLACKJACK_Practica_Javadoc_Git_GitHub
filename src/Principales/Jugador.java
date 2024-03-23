package Principales;

import java.util.ArrayList;

/**
 * Esta clase es para crear al jugador y poder manipular sus atributos dentro de la partida
 * 
 * @author Alex
 * @version JavaSE-17
 */
public class Jugador {

	private int dinero;
	private int cantidadApostada;
	private int puntos;
	private ArrayList<Carta> listaCartas;

	public Jugador(int dinero) {
		super();
		this.dinero = dinero;
		this.listaCartas = new ArrayList();

	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public ArrayList<Carta> getListaCartas() {
		return listaCartas;
	}

	public void setListaCartas(ArrayList<Carta> listaCartas) {
		this.listaCartas = listaCartas;
	}

	public void añadirCarta(Carta carta) {

		this.listaCartas.add(carta);

	}

	public void verCarta() {

		System.out.println(listaCartas.get(0));

	}

	public int getCantidadApostada() {
		return cantidadApostada;
	}

	public void setCantidadApostada(int cantidadApostada) {
		this.cantidadApostada = cantidadApostada;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	@Override
	public String toString() {
		return "Jugador [dinero=" + dinero + ", listaCartas=" + listaCartas + ", puntos=\" + puntos]";
	}

}
