package correcionhoja2.wordel;

import java.util.Scanner;

import javax.sound.sampled.TargetDataLine;

public class Wordle {

	public static final String GRIS = "\u001B[0m"; // Color Gris
	public static final String AMARILLO = "\u001B[33m"; // Color Amarillo
	public static final String VERDE = "\u001B[32m"; // Color Verde

	public static void main(String[] args) {

		int intentos = 0;
		boolean continuo = false;
		String palabraOculto = "coche";
		// Garcias a esta herramienta podemos iniciar un conómetro para que el usuario
		// sepa cuanto
		// tarda en descifrar la palabra secreta.
		long comienzo = System.currentTimeMillis();
		Scanner s = new Scanner(System.in);

		// Arrays para pasar los strings
		char[] arrayOculta = new char[5];
		char[] arrayRespuesta = new char[5];
		String palabraIntento;

		while (!continuo && intentos != 5) {
			intentos++;
			System.out.println("Escribe una palabra de 5 letras");
			// COMBIERTO LAS PALABRAS EN MINUSCULAS
			palabraIntento = s.nextLine().toLowerCase();

			if (palabraIntento.length() < 5) {
				System.out.println("Demasiado corta");
			} else if (palabraIntento.length() > 5) {
				System.out.println("Demasiado larga");
			} else {
				// Pasamos los string a arrays
				for (int i = 0; i < 5; i++) {
					arrayOculta[i] = palabraOculto.charAt(i);
					arrayRespuesta[i] = palabraIntento.charAt(i);
				}
				// Pasamos los dos arrays a un metodo nuevo para compararlos
				if (ComparoArrays(arrayRespuesta, arrayOculta)) {
					continuo = true;
				}

			}
		}
		if (intentos == 5) {
			System.out.println("No tienes más intentos. Has perdido");

		} else {
			System.out.println("Genial, encontraste la respuesta en " + ((System.currentTimeMillis() - comienzo) / 1000)
					+ " segundos y en " + intentos + " intentos.");
		}

	}

	// Creo un método llamado "comparoArrays" que encapsulará la comprobación de que
	// la palabraIntento
	// comparte alguna letra con la palabraSecreta. Si la letra estaen la misma
	// posición se teñirá de verde,
	// Si es acertada pero esta en posición distinta se tiñe de color amarillo, sino
	// coincide se teñirá de gris.
	// Al método debo pasarle los caracteres (char, letra)de la palabraRespuesta y
	// la palabraOculta.

	public static boolean ComparoArrays(char[] arrayRespuesta, char[] palabraOculto) {
		boolean gano = true;
		char[] ocultoTemp = palabraOculto;
		// Creo un Array con números enteros con los colores, para asignar un número a
		// la letra.
		// 0=gris, 2= verde, 1=amarillo. ColoPorLetra es un array numérico de 5 pq
		// sabemos que la palabra tiene 5 caracteres
		int[] colorPorLetra = new int[5];

		// Comprobamos si la letra existe y está en la posición correcta (Verdes). Para
		// ello solo necesito un bucle for.
		for (int i = 0; i < 5; i++) {
			if (arrayRespuesta[i] == ocultoTemp[i]) {
				ocultoTemp[i] = '-';
				colorPorLetra[i] = 2;
			} else {
				// Si entro aquí es porque no ha coincidido ninguna palabra, pero puedo seguir
				// jugando
				gano = false;
			}
		}

		// Comprobamos si la letra existe pero NO está en la posición correcta, para
		// ello necestito dos bucles for
		// uno para comprobar que la letra coincide y otro para saber en que posición.
		// (Amarillos)

		for (int j = 0; j < 5; j++) {
			for (int k = 0; k < 5; k++) {
				if (arrayRespuesta[j] == ocultoTemp[k] && colorPorLetra[j] != 2) {
					colorPorLetra[j] = 1;
					ocultoTemp[k] = '-';
				}
			}
		}

		// Asigno el color a cada letra del array respuesta según el array de colores
		for (int m = 0; m < 5; m++) {
			if (colorPorLetra[m] == 0) {
				System.out.print(arrayRespuesta[m]);
			}
			if (colorPorLetra[m] == 1) {
				System.out.print(AMARILLO + arrayRespuesta[m] + GRIS);
			}
			if (colorPorLetra[m] == 2) {
				System.out.print(VERDE + arrayRespuesta[m] + GRIS);
			}
		}
		// Bajo una linea
		System.out.println("");
		return gano;
	}
}
