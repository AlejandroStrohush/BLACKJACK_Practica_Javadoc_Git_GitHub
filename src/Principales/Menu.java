package Principales;

import java.util.Random;
import java.util.Scanner;

/**
 * Esta clase es para que el jugador pueda elegir que quiere hacer en la partida
 * con un menu interactivo
 * 
 * @version 1.0.0
 * @since 1.0
 * @author Alejandro Strohush Loyish
 */

public class Menu {
	
	/**
	 * Método que muestra un menú interactivo para que el jugador pueda tomar decisiones durante la partida.
	 * 
	 * @param jugador El jugador que participa en la partida.
	 * @param dealer El dealer con el que compite el jugador.
	 */
	
	public static void menu(Jugador jugador, Jugador dealer) {

		Scanner entradaUsuario = new Scanner(System.in);

		Random aleatorio = new Random();

		int opcion = 0;
		int cantidadApostada = 0;
		int probabilidad = aleatorio.nextInt(2);

		do {

			// Siempre que empiece una ronda, el jugador podra elegir la cantidad que quiere
			// apostar
			System.out.println("Cuanto quieres apostar? (Tienes en total " + jugador.getDinero() + "€)"
					+ " (El Dealer tiene " + dealer.getDinero() + "€)");

			do {

				cantidadApostada = entradaUsuario.nextInt();

				if (cantidadApostada > jugador.getDinero() || cantidadApostada > dealer.getDinero()) {

					System.err.println(
							"No puedes apostar una cantidad mayor a la que tienes o una superior a la del Dealer");

				}

			} while (cantidadApostada > jugador.getDinero() || cantidadApostada > dealer.getDinero());

			jugador.setCantidadApostada(cantidadApostada);

			System.out.println("Empieza la partida!");

			System.out.println();

			System.out.println("El dealer reparte las cartas");

			System.out.println();

			do {

				System.out.println(
						"Elige una opcion \n 1 Ver tus cartas \n 2 Pedir carta (hit) \n 3 Quedarse (stand) \n 4 Doblar (double down - ademas cogeras una carta mas) \n 5 Help");
				opcion = entradaUsuario.nextInt();

				switch (opcion) {
				case 1:
					// Esta opcion enseña al jugador que cartas tiene
					System.out.println(jugador.getListaCartas());

					// Hay una probabilidad del 50% de que si tu miras tu carta le das la posiblidad
					// de que el Dealer coja una si quiere
					probabilidad = aleatorio.nextInt(2);
					if (probabilidad == 1) {

						Partida.dealerCogeCarta(dealer);

					}

					break;

				case 2:

					// Le da al jugador una carta mas
					if (jugador.getListaCartas().size() != 5) {
						Partida.pedirCarta(jugador, dealer);
					} else {
						System.out.println("Maximo puedes tener 5 cartas");
					}

					break;

				case 3:
					// Este metodo hara el resolucion de la ronda, indicara el ganador de la ronda
					Partida.stand(jugador, dealer);

					break;

				case 4:
					// Duplicara la apuesta del jugador, le añadira una nueva carta y por ultimo
					// resolucionara la partida, indicando el ganador de la misma
					System.out.println("Has duplicado tu apuesta!!");
					cantidadApostada = cantidadApostada * 2;
					jugador.setCantidadApostada(cantidadApostada);
					if (jugador.getListaCartas().size() != 5) {
						Partida.pedirCarta(jugador, dealer);
					} else {
						System.out.println("Como ya tenias 5, no recibes una nueva");
					}

					Partida.stand(jugador, dealer);

					break;

				// Explica las reglas del juego
				case 5:

					System.err.println(
							"El objetivo es obtener una mano con un valor cercano a 21 sin pasarse pero tener mas puntos que el Dealer,\nsi alguien se pasa el otro gana\r\n"
									+ "Las cartas numéricas valen su número, las figuras valen 10 y el As puede valer 1 u 11.\r\n"
									+ "Los jugadores deciden pedir cartas adicionales (\"hit\") para acercarse a 21 o quedarse con su mano actual (\"stand\").\r\n"
									+ "Un \"blackjack\" es una mano que su suma da 21 exactos, ganas automáticamente, a menos que el dealer también tenga blackjack.\r\n");

					break;

				default:
					break;
				}

			} while (!(opcion == 3 || opcion == 4));

			System.out.println();

		} while (!(opcion == 3 || opcion == 4));

	}

}
