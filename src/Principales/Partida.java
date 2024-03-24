package Principales;

/**
 * Clase que gestiona la logica de una partida, incluyendo la manipulacion de la
 * puntuacion, el resultado de las rondas, la distribucion y valoracion de las
 * cartas entre los jugadores.
 * 
 * Utiliza {@link Jugador} para manejar las acciones y estados tanto del jugador
 * como del dealer.
 *
 * 
 * @version 1.0.0
 * @since 1.0
 * @author Alejandro Strohush Loyish
 */

public class Partida {

	/**
	 * Añade una nueva carta al arrayList del jugador y permite al Dealer coger
	 * cartas para hacer al juego mas dinamico.
	 * 
	 * @param jugador El jugador al cual se le añade una nueva carta.
	 * @param dealer  El dealer de la partida, quien puede coger cartas bajo ciertas
	 *                condiciones.
	 */
	public static void pedirCarta(Jugador jugador, Jugador dealer) {

		System.out.println("Has recibido una carta");

		// Le da una nueva carta al jugador
		addCartaJugador(jugador);

		calcularPuntos(dealer);

		// Si tiene menos de 17 puntos el Dealer cogera otra carta con este metodo
		dealerCogeCarta(dealer);

	}

	/**
	 * Dice el resultado de la partida en base a la puntuacion de cada jugador
	 * 
	 * 
	 * @param jugador El jugador humano.
	 * @param dealer  El dealer de la partida.
	 */
	public static void stand(Jugador jugador, Jugador dealer) {

		if (jugador.getAs() == true) {

			cambiarValorAs(jugador);

		}

		if (dealer.getAs() == true) {

			cambiarValorAs(dealer);

		}
		calcularPuntos(jugador);
		calcularPuntos(dealer);

		if (jugador.getPuntos() == 21 && dealer.getPuntos() == 21) {
			System.out.println("Ambos tienen BlackJack!!! EMPATE");
		} else {
			if (jugador.getPuntos() == 21) {
				System.out.println("Has ganado teniendo un BlackJack!!");
				victoria(jugador, dealer);
			} else {
				if (dealer.getPuntos() == 21) {
					System.out.println("Has perdido! El Dealer tenia un BlackJack!!!");
					System.out.println("Dealer: recuerda que la casa siempre gana jajajajaja");
					derrota(jugador, dealer);
				} else {
					if (jugador.getPuntos() >= 22 && dealer.getPuntos() >= 22) {
						System.out.println("Ambos se han pasado de 21 puntos, empate");
					} else {
						if (jugador.getPuntos() >= 22) {
							System.out.println("Has perdido, te has pasado de 21 puntos...");
							derrota(jugador, dealer);
						} else {
							if (dealer.getPuntos() >= 22) {
								System.out.println("El dealer se ha pasado de 21 puntos, has GANADO!!!");
								victoria(jugador, dealer);
							} else {
								if (jugador.getPuntos() == dealer.getPuntos()) {
									System.out.println("Habeis empatado en puntos");
								} else {
									if (jugador.getPuntos() > dealer.getPuntos()) {
										System.out.println("Tienes mas puntos que el Dealer! Has GANADO!");
										victoria(jugador, dealer);
									} else {
										System.out.println("Tienes menos puntos que el Dealer! Has PERDIDO!");
										derrota(jugador, dealer);
									}
								}
							}
						}
					}
				}
			}
		}

		System.out.println("Tus cartas: " + jugador.getListaCartas() + " puntos: " + jugador.getPuntos());
		System.out.println("Las cartas del Dealer: " + dealer.getListaCartas() + " puntos: " + dealer.getPuntos());

	}

	/**
	 * Asigna puntaje a la carta dada, considerando valores especiales para figuras
	 * y ases.
	 * 
	 * @param carta          La carta a la cual asignar un valor de puntos.
	 * @param ambosJugadores El jugador que recibe la carta, utilizado para
	 *                       gestionar el caso de los ases.
	 */
	public static void puntuacion(Carta carta, Jugador ambosJugadores) {

		if (carta.getValores().matches(".*[2-9].*")) {

			int puntos = Integer.parseInt(carta.getValores());

			carta.setPuntos(puntos);

		} else {

			switch (carta.getValores()) {

			case "10":
			case "J":
			case "Q":
			case "K":

				carta.setPuntos(10);

				break;

			case "AS":

				carta.setPuntos(1);
				ambosJugadores.setAs(true);
				break;

			default:
				break;
			}

		}

	}

	/**
	 * Le añade el dinero apostado al jugador y le quita el dinero al Dealer
	 * 
	 * @param jugador El jugador que ha ganado la partida.
	 * @param dealer  El dealer que ha perdido la partida.
	 */
	public static void victoria(Jugador jugador, Jugador dealer) {

		jugador.setDinero(jugador.getDinero() + jugador.getCantidadApostada());
		dealer.setDinero(dealer.getDinero() - jugador.getCantidadApostada());
	}

	/**
	 * Le añade el dinero apostado al Dealer y le quita el dinero al Jugador
	 * 
	 * 
	 * @param jugador El jugador que ha perdido la partida.
	 * @param dealer  El dealer que ha ganado la partida.
	 */
	public static void derrota(Jugador jugador, Jugador dealer) {

		jugador.setDinero(jugador.getDinero() - jugador.getCantidadApostada());
		dealer.setDinero(dealer.getDinero() + jugador.getCantidadApostada());

	}

	/**
	 * Permite al dealer coger cartas si tiene menos de 17 puntos, añadiendo
	 * dinamismo al juego.
	 * 
	 * @param dealer El dealer de la partida.
	 */
	public static void dealerCogeCarta(Jugador dealer) {

		int contadorCPU = 0;
		int puntosCPU = 0;

		// Hace recuento de los puntos que tiene el Dealer
		for (Carta carta : dealer.getListaCartas()) {

			puntosCPU += dealer.getListaCartas().get(contadorCPU).getPuntos();
			contadorCPU++;
		}

		// En caso que el Dealer tengo menos de 17 puntos coge una carta
		if (puntosCPU <= 17) {
			System.out.println("\u001B[31m" + "Ves como el dealer coge una carta" + "\u001B[0m");
			addCartaJugador(dealer);

		}

	}

	/**
	 * Calcula y actualiza la puntuacion total del jugador elegido.
	 * 
	 * @param ambosJugadores El jugador cuya puntuacion necesita ser calculada.
	 */
	public static void calcularPuntos(Jugador ambosJugadores) {

		int puntos = 0;
		int contador = 0;

		// Calcula cuantos puntos tiene el jugador en base al valor de cada carta
		for (Carta carta : ambosJugadores.getListaCartas()) {

			puntos += ambosJugadores.getListaCartas().get(contador).getPuntos();
			contador++;
		}

		ambosJugadores.setPuntos(puntos);

	}

	/**
	 * @deprecated En un futuro se creara una nueva clase que maneje mejor la
	 *             puntuacion de los ases. Use la nueva clase cuando esté
	 *             disponible.
	 * 
	 *             Ajusta el valor del AS en la mano del jugador, dependiendo de su
	 *             puntuacion actual.
	 * 
	 * @param ambosJugadores El jugador que tenga los ases
	 * @deprecated Este método será eliminado en futuras versiones. Utilice la nueva
	 *             clase de gestión de puntuación de ases.
	 */
	@Deprecated
	public static void cambiarValorAs(Jugador ambosJugadores) {

		calcularPuntos(ambosJugadores);

		int posicionCartaAS = 0;

		if (ambosJugadores.getPuntos() <= 11) {

			for (Carta carta3 : ambosJugadores.getListaCartas()) {

				if (ambosJugadores.getListaCartas().get(posicionCartaAS).getValores() == "AS") {

					ambosJugadores.getListaCartas().get(posicionCartaAS).setPuntos(11);
					calcularPuntos(ambosJugadores);
					return;
				}

				posicionCartaAS++;

			}

		}

	}

	/**
	 * Genera y añade una carta aleatoria a la mano del jugador / Dealer.
	 * 
	 * @param ambosJugadores El jugador a quien se le añadira una carta aleatoria.
	 */
	public static void addCartaJugador(Jugador ambosJugadores) {

		CartaAleatoria generador = new CartaAleatoria();

		Carta carta = new Carta(generador.obtenerValorAleatoria(), generador.obtenerSimboloAleatoria());
		ambosJugadores.addCarta(carta);
		Partida.puntuacion(carta, ambosJugadores);

	}

}
