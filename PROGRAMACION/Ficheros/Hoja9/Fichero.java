package Hoja9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.security.DigestException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Fichero {

	private String ruta;

	public Fichero(String ruta) {
		super();
		this.ruta = ruta;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	@Override
	public String toString() {
		return "Fichero [ruta=" + ruta + "]";
	}

	// este es el metodo para poder leer en el fichero, debo de llamarlo en la clase
	// de control

	public void leerFichero() {

		// declara las clases fuera porque con el finally al cerrar el archivo daría
		// error

		FileReader fichero = null;
		BufferedReader lector = null;
		// supongo que cadena camb pq quiero
		String cadena;

		try {
			// aqui dentro las inicializa debo meter una ruta para que el lector lea en un
			// fichero llamado fichero

			fichero = new FileReader("C:/Users/34682/Desktop/prueba.txt");
			lector = new BufferedReader(fichero);

			// leo la cadena siempre que esta no este vacia.
			// Sungo que esta cadena ahora es un array.

			while ((cadena = lector.readLine()) != null) {
				System.out.println(cadena);
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error inesperado");
			e.printStackTrace();
		} finally {
			try {
				if (lector != null) {
					lector.close();
				}
				if (fichero != null) {
					fichero.close();
				}

			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero");
				e.printStackTrace();
			}

		}

	}

	// metodo para poder recibir la lista, debo llamarlo en la clase controlador

	@SuppressWarnings("finally")
	public ArrayList<String> devolverFichero() {

		FileReader fichero = null;
		BufferedReader lector = null;
		String cadena;

		ArrayList<String> contenido = new ArrayList<String>();

		try {
			fichero = new FileReader("C:/Users/34682/Desktop/prueba.txt");// la ruta donde se encuentra el fichero
			lector = new BufferedReader(fichero);// el lector leera el fichero linea a linea

			while ((cadena = lector.readLine()) != null) {// la cadena será cada lectura liea a linea siempre que no sea
															// nula y se añadira al contenido
				contenido.add(cadena);
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error inesperado");
			e.printStackTrace();
		} finally {
			try {
				if (lector != null) {
					lector.close();
				}
				if (fichero != null) {
					fichero.close();
				}

			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero");
				e.printStackTrace();
			} finally {
				return contenido;
			}

		}

	}

	// metodo para escribir la lista en el fichero

	public void escribirFichero(ArrayList<String> datos) {

		// Lo creo fuera del try pq estoy usando finally
		FileWriter guardar = null;

		try {
			// pongo true porque el fichero existe y no hace falta que lo cree.
			guardar = new FileWriter("C:/Users/34682/Desktop/prueba.txt", true);// true = append. de esta forma usaremos
																				// un archivo ya creado

			// recorre la lista datos y guarda cada dato en el archivo.

			for (String dato : datos) {
				guardar.write(dato + (char) 13); // aquí es donde realmente se escribe el dato en el fichero. (char) 13
													// es un salto de linea, un enter
			}
			// for(int i=0;i<datos.length;i++) {}

		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {

			System.out.println("Un error incontrolado");
		} finally {
			try {
				if (guardar != null) {
					guardar.close();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	public void escribirFichero(Fichero datos) {
		FileWriter guardar = null;
		FileReader fichero = null;
		BufferedReader lector = null;
		String cadena;

		try {
			guardar = new FileWriter("C:/Users/34682/Desktop/prueba.txt", true);// true = append
			fichero = new FileReader(datos.getRuta());
			lector = new BufferedReader(fichero);

			while ((cadena = lector.readLine()) != null) {
				guardar.write(cadena + (char) 13);
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error inesperado");
			e.printStackTrace();
		} finally {
			try {
				if (guardar != null) {
					guardar.close();
				}
				if (lector != null) {
					lector.close();
				}
				if (fichero != null) {
					fichero.close();
				}

			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero");
				e.printStackTrace();

			}

		}

	}

	public void escribirFichero(String dato) {
		FileWriter guardar = null;

		try {
			guardar = new FileWriter("C:/Users/34682/Desktop/prueba.txt", true);// true = append
			guardar.write(dato + (char) 13);

		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {

			System.out.println("Un error incontrolado");
		} finally {
			try {
				if (guardar != null) {
					guardar.close();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

}