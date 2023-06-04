package Vista;

import java.util.ArrayList;
import java.util.Scanner;

public class RecogidaDatosMedicamento {

	boolean resultadoMedicamento;
	Modelo.Validar miValidar = new Modelo.Validar();
	Scanner lector = new Scanner(System.in);

	// RECOJO TODOS LOS DATOS NECESARIOS PARA CREAR UN OBJETO TIPO MEDICAMENTO

	public ArrayList<Modelo.Medicamento> datosMedicamento() {

		// GUARDO LOS OBJETOS MEDICAMENTOS EN UNA LISTA
		ArrayList<Modelo.Medicamento> medicamentos = new ArrayList<Modelo.Medicamento>();
		Scanner scaner = new Scanner(System.in);
		String salir;

		try {
			do {

				Modelo.Medicamento miMedicamento = new Modelo.Medicamento();

				System.out.println("Escriba el nombre del medicamento");
				miMedicamento.setNombre(lector.next());
				System.out.println("Escriba la composición del medicamento");
				miMedicamento.setComposicion(lector.next());
				System.out.println("Escriba el precio del medicamento");
				miMedicamento.setPrecio(lector.nextFloat());

				// VALIDO QUE LOS DATOS INTRODUCIDOS ESTAN BIEN
				resultadoMedicamento = miValidar.validacionMedicamento(miMedicamento);

				// UNA VEZ VALIDADOS LOS AÑADO A LA LISTA
				medicamentos.add(miMedicamento);

				System.out.println("Escriba una s para salir");
				salir = lector.next();

			} while (!salir.equals("s"));

			return medicamentos;

		} catch (Exception e) {
			return null;
		}

	}

}
