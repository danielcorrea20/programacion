package Vista;

import java.util.ArrayList;
import java.util.Scanner;

public class RecogidaDatosFarmaceutica {

	boolean resultadoFarmaceutica;
	Modelo.Validar miValidar = new Modelo.Validar();
	Scanner lector = new Scanner(System.in);

	// RECOJO TODOS LOS DATOS NECESARIO PARA CREAR UN OBJETO DEL TIPO FARMACEUTICA

	public ArrayList<Modelo.Farmaceutica> datosFarmaceutica() {
		// CREO UN LISTA DE FARMACIAS
		ArrayList<Modelo.Farmaceutica> farmacias = new ArrayList<Modelo.Farmaceutica>();
		Scanner scaner = new Scanner(System.in);
		String salir;

		try {
			do {

				Modelo.Farmaceutica miFarmaceutica = new Modelo.Farmaceutica();

				System.out.println("Escriba el nombre de la farmaceutica");
				miFarmaceutica.setNombre(lector.next());
				System.out.println("Escriba el CIF de la farmaceutica");
				miFarmaceutica.setCIF(lector.next());
				System.out.println("Escriba la ciudad sede");
				miFarmaceutica.setCiudad(lector.next());

				// VALIDO QUE LOS DATOS INTRODUCIDOS SON CORRECTOS

				resultadoFarmaceutica = miValidar.validacionFarmaceutica(miFarmaceutica);

				// UNA VEZ VALIDADOS LOS AÑADO A LA LISTA FARMACIAS
				farmacias.add(miFarmaceutica);
				System.out.println("Escriba una s para salir");
				salir = lector.next();
			} while (!salir.equals("s"));

			return farmacias;

		} catch (Exception e) {
			return null;
		}

	}

}
