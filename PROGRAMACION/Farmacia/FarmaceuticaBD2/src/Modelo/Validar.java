package Modelo;

public class Validar {

	public static void main(String[] args) {

		// vadilaciones datos de entrada de farmaceutica.
		// nombre max de 30 letras o números.
		// cif comienza por B o A y le siguen 8 números.
		// ciudad solo letras con un max de 20.
		// stock solo un número entero.

	}

	// VALIDO LOS DATOS DE ENTRADA DE LA FARMACEUTICA

	public boolean validacionFarmaceutica(Farmaceutica farmaceutica) {

		boolean esValido = true;

		// QUE EL NOMBRE NO TENGA UNA LONGITUD MAYOR A 30

		if (farmaceutica.getNombre().length() > 30) {
			System.out.println("El nombre es demasiado largo.");
			esValido = false;
		}

		// QUE EL CIF COMINECE POR A O B

		if (farmaceutica.getCIF().charAt(0) != 'A' && farmaceutica.getCIF().charAt(0) != 'B') {
			System.out.println("El CIF debe comenzar por A o por B.");
			esValido = false;

			// QUE TENGA UNA LONGITUD DE 9

		} else if (farmaceutica.getCIF().length() != 9) {

			System.out.println("El CIF debe tener 9 dígitos");
			esValido = false;
		}

		// QUE EL NOMBRE DE LA CIUDAD NO TENGA MAS DE 20

		if (farmaceutica.getCiudad().length() > 20) {
			System.out.println("El nombre de la ciudad es demasiado largo.");
			esValido = false;
		}

		return esValido;

	}

	// VALIDO LOS DATOS DE ENTRADA DE LA FARMACEUTICA

	public boolean validacionMedicamento(Medicamento medicamento) {

		boolean esValido = true;

		// QUE EL NOMBRE NO TENGA MAS DE 30

		if (medicamento.getNombre().length() > 30) {
			System.out.println("El nombre es demasiado largo.");
			esValido = false;
		}

		// QUE LA COMPOSICION NO TENGA MAS DE 500

		if (medicamento.getComposicion().length() > 500) {
			esValido = false;
			System.out.println("Ha superado los caracteres máximos");
		}

		return esValido;

	}

	// vadilaciones datos de entrada de medicamento
	// nombre max 30 palabras o números.
	// composición max 500 palabras o números.
	// precio un float.

}
