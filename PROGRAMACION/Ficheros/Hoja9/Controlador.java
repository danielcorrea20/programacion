package Hoja9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.LeafElement;

public class Controlador {

	public static void main(String[] args) {

		int mesCumple;

		int dia = 0; // pido el día al usuario
		int mes = 0;// pido el mes al usuario
		int ano; // pido el año al usuario. Lo pido por separado par luego hacer una casteo a
					// formato localdate
		String ruta = "C:/Users/34682/Desktop/prueba.txt"; // Selecciono la ruta de mi fichero
		String opcion = ""; // ofrezco la opción de dejar de introducir alumnos
		ArrayList<Persona> alumnos = new ArrayList<Persona>(); // Creo una lista donde poder guardar los alumnos

		Aula miAula = new Aula(); // Creo un objeto de la clase aula
		miAula.setLista(alumnos); // Llamo al método set para poder modificar la lista alumnos

		Scanner sc = new Scanner(System.in);

		try { // Dentro del try coloco las instrucciones que puedan dar problemas

			while (!opcion.equals("s")) {
				Persona persona = new Persona(); // Creo un objeto de la clase persona que el usuario podra completar
													// con el scanner

				System.out.println("Escribe un nombre"); // pido el nombre y lo seteo en el atributo nombre
				persona.setNombre(sc.next());

				while (dia < 1 || dia > 31) {
					System.out.println("Escribe el día que naciste");// pido el día y lo seteo en el atributo día.
																		// Antes compruebo que el día esta entre 1 y 31
					dia = sc.nextInt();
					sc.nextLine();
					if (dia < 1 || dia > 31) {
						System.out.println("día erroneo");
					}

				}

				while (mes < 1 || mes > 12) {
					System.out.println("Escribe el mes que naciste");// pido el mes y lo seteo en el atributo día.
																		// Antes compruebo que el mes esta entre 1 y 12
					mes = sc.nextInt();
					sc.nextLine();
					if (mes < 1 || mes > 12) {
						System.out.println("mes erroneo");
					}

				}

				System.out.println("Escribe el año que naciste");// pido el año y lo seteo en el atributo año.
				ano = sc.nextInt();
				sc.nextLine();

				LocalDate fecha = LocalDate.of(ano, mes, dia);
				persona.setFecha(fecha); // relaizo el casteo a local date de la fecha y lo seteo como fecha

				System.out.println("Escribe un curso");//pido el curso del alumno y lo seteo como curso
				persona.setCurso(sc.next());

				System.out.println("Escribe s para salir u otra tecla para continuar");//Le doy la opción al usuario de poder dejar de introducir datos
				opcion = sc.next();

				alumnos = miAula.anadir(alumnos, persona); // cada alumno que el usuario añada se iran sumando a la
															// lista de alumnos

			}

			miAula.mostrar(alumnos); // voy mostrando la lista

			Fichero miFichero = new Fichero(ruta); // declaro el objeto de la clase fichero

			ArrayList<String> alumnosFichero = new ArrayList<String>();// creo una lista para los alumnos que guardare
																		// en el fichero
			for (Persona persona : alumnos) { // recorro la lista de alumnos
				alumnosFichero.add(persona.toString()); // Guardo el formato tostring de cada objeto persona (que he
														// modiifcado) en la lista alumnosFichero
			}

			miFichero.escribirFichero(alumnosFichero);// Con el método escribir fichero llevo a mi fichero la lista
														// alumnosFichero

			miFichero.leerFichero();// con en metodo leerFichero puedo leer el contenido de mi fichero en la consola

			ArrayList<String> alumnosFicheroDevueltos = miFichero.devolverFichero();// Necsito los datos de mi fichero
																					// para trabajar con ellos. Uso
			// el metodo de devolverFichero y lo guardo en una lista de string

			System.out.println("Escribe el mes de nacimiento de los alumnos");// para el primer metodo de saber que
																				// alumnos cumplen años en un mes
																				// determinado
			// Solicito el mes al usuario
			mesCumple = sc.nextInt();
			sc.nextLine();
			// Creo una lista que recoja todos los alumnos que cumplen los años en el mes.
			// Llamndo al metodo que he creado en la clase aula
			// Le doy el mes y la lista de alumno que me ha devuelto el fichero

			ArrayList<Persona> alumnosCumpleMes = miAula.nacidosMes(mesCumple, alumnosFicheroDevueltos);
			// Recorro la lista y muesto los alumnos
			for (Persona persona : alumnosCumpleMes) {
				System.out.println(persona.toString());
			}

			miAula.mayorMenor(alumnosFicheroDevueltos);
			miAula.edad1825(alumnosFicheroDevueltos);
			miAula.horoscopo(alumnosFicheroDevueltos);
			miAula.edadMedia(alumnosFicheroDevueltos);
			miAula.orden(alumnosFicheroDevueltos);
			sc.close();

		} catch (Exception e) {
			System.out.println("Ha cometido algún error al introducir los datos");
		}

	}

}
