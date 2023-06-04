package Modelo;
import java.util.Scanner;

public class Transformar {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// METODO BORRAR PARA RECOGER EL ID DE LA FARMACEUTICA/FARMACIA QUE QUIERO
	// ELIMINAR

	public int borrar() {

		Scanner scaner = new Scanner(System.in);
		int id = 0;
		try {

			System.out.println("¿Que farmaceutica quiere eliminar?");
			id = scaner.nextInt();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return id;

	}

	// METODO UPDATE PARA CONSEGUIR EL ID DE LA FARMACEUTICA QUE QUIERO MODIFICAR

	public Farmaceutica update() {

		Scanner scaner = new Scanner(System.in);
		int id;
		try {

			Farmaceutica mifarmaceutica = new Farmaceutica();
			System.out.println("¿Que farmaceutica quiere modificar?");
			id = scaner.nextInt();
			scaner.nextLine();
			mifarmaceutica.setId(id);

			// REGOJO LOS NUEVOS DATOS Y LOS SETEO EN EL OBJETO MIFARMACIA

			System.out.println("Nuevo nombre de la farmaceutica");
			mifarmaceutica.setNombre(scaner.next());
			System.out.println("Nuevo CIF de la farmaceutica");
			mifarmaceutica.setCIF(scaner.next());
			System.out.println("Nueva ciudad de la farmaceutica");
			mifarmaceutica.setCiudad(scaner.next());

			return mifarmaceutica;

		} catch (Exception e) {
			return null;
		}

	}

	// METODO UPDATEMEDICAMENTO PARA CONSEGUIR EL ID DE LA MEDICAMENTO QUE QUIERO
	// MODIFICAR

	public Medicamento updatemedicamento() {

		Scanner scaner = new Scanner(System.in);
		int id;
		try {

			Medicamento miMedicamento = new Medicamento();
			System.out.println("¿Que medicamento quiere modificar?");
			id = scaner.nextInt();
			scaner.nextLine();
			miMedicamento.setId(id);

			// REGOJO LOS NUEVOS DATOS Y LOS SETEO EN EL OBJETO MIMEDICAMENTO

			System.out.println("Nuevo nombre del medicamento");
			miMedicamento.setNombre(scaner.next());
			System.out.println("Nueva composición del medicamento");
			miMedicamento.setComposicion(scaner.next());
			System.out.println("Nuevo precio del medicamento");
			miMedicamento.setPrecio(scaner.nextInt());
			scaner.nextLine();
			return miMedicamento;

		} catch (Exception e) {
			return null;
		}

	}

}
