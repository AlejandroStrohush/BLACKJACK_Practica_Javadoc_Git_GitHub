package Principales;

import java.util.ArrayList;

/**
 * Esta clase inicia la partida y da las cartas iniciales a cada jugador
 * @author Alex
 * @version JavaSE-17
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("El Dealer siempre te va a igualar la apuesta");

		int contadorRondas = 0;

		CartaAleatoria generador = new CartaAleatoria();

		int dinero = 700;
		int dineroCPU = 1000;
		int victoria = dinero + dineroCPU;

		// Creo a los jugadores y les asigno un dinero base para que puedan apostar
		Jugador jugador = new Jugador(dinero);

		JugadorCPU jugadorCPU = new JugadorCPU(dineroCPU);

		do {

			// En el caso de que uno de los jugadores pierda, ignore el bucle y acabe la
			// partida
			if (!(jugador.getDinero() <= 0 || jugador.getDinero() >= victoria)) {

				// Borra las cartas de los jugadores para empezar una nueva partida
				jugador.getListaCartas().clear();

				jugadorCPU.getListaCartas().clear();

				// Da las cartas iniciales a cada jugador, la carta se crea con la clase Carta y
				// recibe de parametros la clase CartaAleatoria su unica función es pasar
				// parametros aleatorios para la creacion de las cartas
				for (int i = 0; i < 2; i++) {
					jugador.añadirCarta(
							new Carta(generador.obtenerValorAleatoria(), generador.obtenerSimboloAleatoria()));
					jugadorCPU.añadirCarta(
							new Carta(generador.obtenerValorAleatoria(), generador.obtenerSimboloAleatoria()));
				}

				// Le asigna la puntuacion a la carta de cada jugador, sirve para cartas como
				// J,Q,K,AS que estan en formato String y queremos tranformar la puntuacion en
				// int
				Partida.puntuacion(jugador, jugadorCPU);

				// Te dice en que ronda de la partida estas
				contadorRondas++;

				System.out.println("Empiza la Ronda: " + contadorRondas);

				Menu.menu(jugador, jugadorCPU);

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
