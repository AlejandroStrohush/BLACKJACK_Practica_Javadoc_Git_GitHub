package Principales;

import java.util.ArrayList;

/**
 * Esta clase inicia la partida, da las cartas iniciales a cada jugador y la resolucion final de la partida
 * 
 * @version 1.0.0
 * @since 1.0
 * @author Alejandro Strohush Loyish
 */

public class Main {

    /**
     * Método principal que inicia la partida.
     * 
     * @param args Los argumentos de la línea de comandos (no utilizados en este caso)
     */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("El Dealer siempre te va a igualar la apuesta");

		int contadorRondas = 0;

		CartaAleatoria generador = new CartaAleatoria();

		int dinero = 700;
		int dineroDealer = 1000;
		int victoria = dinero + dineroDealer;

		// Creo a los jugadores y les asigno un dinero base para que puedan apostar
		Jugador jugador = new Jugador(dinero);

		Jugador dealer = new Jugador(dineroDealer);

		do {

			// En el caso de que uno de los jugadores pierda, ignore el bucle y acabe la
			// partida
			if (!(jugador.getDinero() <= 0 || jugador.getDinero() >= victoria)) {

				// Borra las cartas de los jugadores para empezar una nueva ronda
				jugador.getListaCartas().clear();

				dealer.getListaCartas().clear();

				// Da las cartas iniciales a cada jugador
				for (int i = 0; i < 2; i++) {

					Partida.addCartaJugador(jugador);
					Partida.addCartaJugador(dealer);

				}

				// Te dice en que ronda de la partida estas
				contadorRondas++;

				System.out.println("Empieza la Ronda: " + contadorRondas);

				Menu.menu(jugador, dealer);

			}

		} while (!(jugador.getDinero() <= 0 || jugador.getDinero() >= victoria));

		// Si la partida acaba indica al ganador y finaliza el programa
		if (jugador.getDinero() <= 0) {
			System.out.println("Has perdido, te has quedado sin dinero");
		} else {
			System.out.println("Te has llevado todo el dinero del Dealer, has ganado, gg");
		}

	}

}
