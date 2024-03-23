package Principales;

/**
 * Esta clase manipula la puntuacion de la partida, el resultado de la partida,
 * que cartas va a recibir cada jugador y que valor tiene cada carta
 * 
 * @author Alex
 * @version JavaSE-17
 */

public class Partida {

	// En el menu interactivo activa este metodo, lo cual hace que añade una nueva
	// carta al arrayList del jugador
	// ademas se añade al Dealer para que tenga la capacidad de coger cartas si
	// quiere, para hacer al juego mas dinamico
	public static void pedirCarta(Jugador jugador, JugadorCPU jugadorCPU) {

		int puntosCPU = 0;
		int contador = 0;
		CartaAleatoria generador = new CartaAleatoria();

		System.out.println("Has recibido una carta");

		// Le da una nueva carta al jugador
		jugador.añadirCarta(new Carta(generador.obtenerValorAleatoria(), generador.obtenerSimboloAleatoria()));

		// Hace recuento de los puntos del Dealer
		for (Carta carta : jugadorCPU.getListaCartas()) {

			puntosCPU += jugadorCPU.getListaCartas().get(contador).getPuntos();
			contador++;
		}

		// Si tiene menos de 17 puntos el Dealer cogera otra carta con este metodo
		dealerCogeCarta(jugadorCPU);

	}

	// Este metodo es la resolucion de la partida, dira que jugador ha ganado, se
	// pasa de parametro a ambos jugadores porque en sus atributos esta almacenado
	// las cartas con su respectiva puntuacion
	public static void stand(Jugador jugador, JugadorCPU jugadorCPU) {

		int puntos = 0;
		int puntosCPU = 0;
		int contador = 0;
		int contadorCPU = 0;

		// Calcula cuantos puntos tiene el jugador en base al valor de cada carta
		for (Carta carta : jugador.getListaCartas()) {

			puntos += jugador.getListaCartas().get(contador).getPuntos();
			contador++;
		}

		jugador.setPuntos(puntos);

		// Calcula cuantos puntos tiene el Dealer en base al valor de cada carta
		for (Carta carta : jugadorCPU.getListaCartas()) {

			puntosCPU += jugadorCPU.getListaCartas().get(contadorCPU).getPuntos();
			contadorCPU++;
		}

		jugadorCPU.setPuntos(puntosCPU);

		// Los puntos se comparan en los proximos if y dependiendo de la condicion dara
		// que ha ganado un jugador u otro, aparte de ingresar el dinero al ganador y
		// restarselo al perdedor
		if (jugador.getPuntos() == 21 && jugadorCPU.getPuntos() == 21) {
			System.out.println("Ambos tienen BlackJack!!! EMPATE");
		} else {
			if (jugador.getPuntos() == 21) {
				System.out.println("Has ganado teniendo un BlackJack!!");
				victoria(jugador, jugadorCPU);
			} else {
				if (jugadorCPU.getPuntos() == 21) {
					System.out.println("Has perdido! El Dealer tenía un BlackJack!!!");
					System.out.println("Dealer: recuerda que la casa siempre gana jajajajaja");
					derrota(jugador, jugadorCPU);
				} else {
					if (jugador.getPuntos() >= 22 && jugadorCPU.getPuntos() >= 22) {
						System.out.println("Ambos se han pasado de 21 puntos, empate");
					} else {
						if (jugador.getPuntos() >= 22) {
							System.out.println("Has perdido, te has pasado de 21 puntos...");
							derrota(jugador, jugadorCPU);
						} else {
							if (jugadorCPU.getPuntos() >= 22) {
								System.out.println("El dealer se ha pasado de 21 puntos, has GANADO!!!");
								victoria(jugador, jugadorCPU);
							} else {
								if (jugador.getPuntos() == jugadorCPU.getPuntos()) {
									System.out.println("Habeis empatado en puntos");
								} else {
									if (jugador.getPuntos() > jugadorCPU.getPuntos()) {
										System.out.println("Tienes más puntos que el Dealer! Has GANADO!");
										victoria(jugador, jugadorCPU);
									} else {
										System.out.println("Tienes menos puntos que el Dealer! Has PERDIDO!");
										derrota(jugador, jugadorCPU);
									}
								}
							}
						}
					}
				}
			}
		}

		System.out.println("Tus cartas: " + jugador.getListaCartas() + " puntos: " + jugador.getPuntos());
		System.out.println(
				"Las cartas del Dealer: " + jugadorCPU.getListaCartas() + " puntos: " + jugadorCPU.getPuntos());

	}

	// Este metodo le da a cada carta su valor, Si tienes una J esta valdra 10 y asi
	// con el resto de cartas, se pasa de parametros ambos jugadores porque tienen
	// almacenadas las cartas con los atributos de los valores
	public static void puntuacion(Jugador jugador, JugadorCPU jugadorCPU) {

		int posicionCarta = 0;
		int posicionCartaCPU = 0;

		for (Carta carta : jugador.getListaCartas()) {

			if (jugador.getListaCartas().get(posicionCarta).getValores().matches(".*[2-9].*")) {

				int puntos = Integer.parseInt(jugador.getListaCartas().get(posicionCarta).getValores());

				jugador.getListaCartas().get(posicionCarta).setPuntos(puntos);

			} else {

				switch (jugador.getListaCartas().get(posicionCarta).getValores()) {

				case "10":
				case "J":
				case "Q":
				case "K":

					jugador.getListaCartas().get(posicionCarta).setPuntos(10);

					break;

				case "AS":

					int puntosAS = 0;
					int contadorAS = 0;

					for (Carta carta2 : jugador.getListaCartas()) {
						puntosAS += jugador.getListaCartas().get(contadorAS).getPuntos();
						contadorAS++;
					}

					if (puntosAS <= 10) {

						jugador.getListaCartas().get(posicionCarta).setPuntos(11);

					} else {

						jugador.getListaCartas().get(posicionCarta).setPuntos(1);

					}

					break;

				default:
					break;
				}

			}

			posicionCarta++;

		}

		posicionCarta = 0;

		for (Carta carta : jugadorCPU.getListaCartas()) {

			if (jugadorCPU.getListaCartas().get(posicionCartaCPU).getValores().matches(".*[2-9].*")) {

				int puntos = Integer.parseInt(jugadorCPU.getListaCartas().get(posicionCartaCPU).getValores());

				jugadorCPU.getListaCartas().get(posicionCartaCPU).setPuntos(puntos);

			}

			switch (jugadorCPU.getListaCartas().get(posicionCartaCPU).getValores()) {

			case "10":
			case "J":
			case "Q":
			case "K":

				jugadorCPU.getListaCartas().get(posicionCartaCPU).setPuntos(10);

				break;

			case "AS":

				int puntosAsCPU = 0;
				int contadorAsCPU = 0;

				for (Carta carta2 : jugadorCPU.getListaCartas()) {

					puntosAsCPU += jugadorCPU.getListaCartas().get(contadorAsCPU).getPuntos();
					contadorAsCPU++;
				}

				// En el caso de que el jugador tenga mas de 10 puntos que el AS valga 1 porque
				// sino perderia directamente
				if (puntosAsCPU <= 10) {

					jugadorCPU.getListaCartas().get(posicionCartaCPU).setPuntos(11);

				} else {

					jugadorCPU.getListaCartas().get(posicionCartaCPU).setPuntos(1);

				}

				break;

			default:
				break;
			}
			posicionCartaCPU++;
		}
		posicionCartaCPU = 0;
	}

	// En caso de que el jugador gane se lleva el dinero y se lo resta al Dealer
	public static void victoria(Jugador jugador, JugadorCPU jugadorCPU) {

		jugador.setDinero(jugador.getDinero() + jugador.getCantidadApostada());
		jugadorCPU.setDinero(jugadorCPU.getDinero() - jugador.getCantidadApostada());
	}

	// En caso de que el Dealer gane se lleva el dinero y se le resta el dinero al
	// jugador
	public static void derrota(Jugador jugador, JugadorCPU jugadorCPU) {

		jugador.setDinero(jugador.getDinero() - jugador.getCantidadApostada());
		jugadorCPU.setDinero(jugadorCPU.getDinero() + jugador.getCantidadApostada());

	}

	// Permite al dealer coger cartas para que sea mas dinamico, se pasa de
	// parametro al Dealer para ver cuantos puntos tiene
	public static void dealerCogeCarta(JugadorCPU jugadorCPU) {

		int contadorCPU = 0;
		int puntosCPU = 0;

		CartaAleatoria generador = new CartaAleatoria();

		// Hace recuento de los puntos que tiene el Dealer - tipo si tiene J y un 6 pues
		// tendria 16 puntos
		for (Carta carta : jugadorCPU.getListaCartas()) {

			puntosCPU += jugadorCPU.getListaCartas().get(contadorCPU).getPuntos();
			contadorCPU++;
		}

		// En caso que el Dealer tengo menos de 17 puntos coge una carta
		if (puntosCPU <= 17) {
			System.out.println("\u001B[31m" + "Ves como el dealer coge una carta" + "\u001B[0m");
			jugadorCPU.añadirCarta(new Carta(generador.obtenerValorAleatoria(), generador.obtenerSimboloAleatoria()));
		}

	}

}
