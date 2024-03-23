package Principales;

import java.util.Scanner;

/**
 * Esta clase es para que el jugador pueda elegir que quiere hacer en la partida con un menu interactivo
 * @author Alex
 * @version JavaSE-17
 */

public class Menu {

	public static void menu(Jugador jugador, JugadorCPU jugadorCPU) {

		Scanner entradaUsuario = new Scanner(System.in);

		int opcion = 0;
		int cantidadApostada = 0;

		do {

			// Siempre que empiece una ronda, el jugador podra elegir la cantidad que quiere
			// apostar
			System.out.println("Cuanto quieres apostar? (Tienes en total " + jugador.getDinero() + "€)"
					+ " (El Dealer tiene " + jugadorCPU.getDinero() + "€)");

			do {

				cantidadApostada = entradaUsuario.nextInt();

				if (cantidadApostada > jugador.getDinero() || cantidadApostada > jugadorCPU.getDinero()) {

					System.err.println(
							"No puedes apostar una cantidad mayor a la que tienes o una superior a la del Dealer");

				}

			} while (cantidadApostada > jugador.getDinero() || cantidadApostada > jugadorCPU.getDinero());

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
					break;

				case 2:

					// Le dara al jugador una carta mas y ademas se le va a atribuir que valor tiene
					// si 5, 10 u 11 o el que sea, se hace principalmente por las de tipo (J,Q,K,AS)
					if (jugador.getListaCartas().size() != 5) {
						Partida.pedirCarta(jugador, jugadorCPU);
						Partida.puntuacion(jugador, jugadorCPU);
					} else {
						System.out.println("Maximo puedes tener 5 cartas");
					}

					break;

				case 3:
					// Este metodo hara el resolucion de la ronda, indicara el ganador de la ronda
					Partida.stand(jugador, jugadorCPU);

					break;

				case 4:
					// Duplicara la apuesta del jugador, le añadira una nueva carta y por ultimo
					// resolucionara la partida, indicando el ganador de la misma
					System.out.println("Has duplicado tu apuesta!!");
					cantidadApostada = cantidadApostada * 2;

					if (jugador.getListaCartas().size() != 5) {
						Partida.pedirCarta(jugador, jugadorCPU);
						Partida.puntuacion(jugador, jugadorCPU);
					} else {
						System.out.println("Como ya tenias 5, no recibes una nueva");
					}

					Partida.stand(jugador, jugadorCPU);

					break;

				// Explica las reglas del juego
				case 5:

					System.out.println(
							"El objetivo es obtener una mano con un valor cercano a 21 sin pasarse pero tener mas puntos que el Dealer\r\n"
									+ "Las cartas numéricas valen su número, las figuras valen 10 y el As puede valer 1 u 11.\r\n"
									+ "Los jugadores deciden pedir cartas adicionales (\"hit\") para acercarse a 21 o quedarse con su mano actual (\"stand\").\r\n"
									+ "El dealer se detiene cuando tiene al menos 17 puntos.\r\n"
									+ "Un \"blackjack\" es una mano inicial con un As y una carta de valor 10, que gana automáticamente a menos que el dealer también tenga blackjack.\r\n"
									+ "Si el dealer se pasa de 21, los jugadores que no se pasaron ganan automáticamente.");

					break;

				default:
					break;
				}

			} while (!(opcion == 3 || opcion == 4));

			System.out.println();

		} while (!(opcion == 3 || opcion == 4));

	}

}
