package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Controlador {

	public static void main(String[] args) throws ClassNotFoundException {

		// AQUI METO LA CONEXION CON LA BD
		// ME FALTA QUE LA FARMACEUTICA TAMBIEN SE BORRE EN LA TABLA
		// FARMACEUTICA_MEDICAMENTO PERO EN ESA TABLA NO HAY DATOS
		// ME FALTA QUE AL METERE UN MEDICAMENTO PUEDO ENLAZARLO A UNA FARMACEUTICA
		// TODOS LOS SELECT
		int opcion;

		String opcion2 = "";
		String salir = "";
		Vista.RecogidaDatosFarmaceutica miRogidaDatosFarmaceutica = new Vista.RecogidaDatosFarmaceutica();
		Vista.RecogidaDatosMedicamento miRecogidaDatosMedicamento = new Vista.RecogidaDatosMedicamento();
		Scanner lector = new Scanner(System.in);
		Statement sentenciaSQL = null;
		int resultado = 0;
		String sql = "";
		Modelo.Transformar miTrasformador = new Modelo.Transformar();
		int id;
		String opcionSalir = "";

		do {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/laboratorios", "root", "");

				// creamos sentencias ejecutables sobre esa conexión
				sentenciaSQL = conexion.createStatement();

				try {
					// Uso un menú asociado a un swith que conducira al usuario a la opción elegida
					System.out.println("************************************");
					System.out.println("");
					System.out.println("Elija la opción en la que quiera trabajar");
					System.out.println("1.- Farmaceutica.");
					System.out.println("2.- Medicamentos.");
					System.out.println("3.- Insertar medicamentos en farmacia.");
					System.out.println("4.- ¿Quiere conocer los medicamentos que produce una farmaceutica?.");
					System.out.println("5.- ¿Quiere conocer donde se produce el medicamento?.");
					System.out.println("6.- Número total de medicamentos.");
					System.out.println("7.- ¿Cuál es el medicamento más caro?.");
					System.out.println("8.- ¿Cuál es la farmaceutica con más stock de un medicamento?.");
					System.out.println("9.- Salir.");
					System.out.println("");
					System.out.println("************************************");

					opcion = lector.nextInt();
					lector.nextLine();

					// ELIJO LA OPCION FARMACIA O MEDICAMENTO

					switch (opcion) {
					// El caso 1 se refiere a las farmaceuticas.
					case 1:
						// Creo un submenú para las opciones de farmaceutica que asocio a un nuevo swith

						System.out.println("Elija una opción");
						System.out.println("a.- Crear nueva farmaceútica");
						System.out.println("b.- Modificar farmaceútica");
						System.out.println("c.- Ver datos farmaceútica");
						System.out.println("d.- Eliminar farmaceútica");
						opcion2 = lector.next();

						switch (opcion2) {
						case "a":

							// En la opción "a" puedo crear una nueva farmacia.

							// Creo una lista para recoger los nuevos objetos que se van creando en la clase
							// recogidadDatosFarmacia
							ArrayList<Modelo.Farmaceutica> farmacias = miRogidaDatosFarmaceutica.datosFarmaceutica();
							// Recorro la lista e inserto los objetos en la BD.
							for (Modelo.Farmaceutica farmacia : farmacias) {
								sql = "INSERT INTO farmaceutica (NOMBRE, CIF, CIUDAD) VALUES ('" + farmacia.getNombre()
										+ "', '" + farmacia.getCIF() + "', '" + farmacia.getCiudad() + "')";
								System.out.println(sql);

								resultado = sentenciaSQL.executeUpdate(sql);

								if (resultado >= 1) {
									System.out.println("Se ha INSERTADO bien.");
								}
							}

							break;

						case "b":

							// En esta opción modifico los datos que ya tengo en la BD.
							// Con un select muestro el nombre de las farmaceuticas.

							ResultSet rsFarmaceutica;
							sentenciaSQL = conexion.createStatement();

							sql = "SELECT * FROM farmaceutica";

							rsFarmaceutica = sentenciaSQL.executeQuery(sql);
							while (rsFarmaceutica.next()) {

								System.out.println(" Nombre: " + rsFarmaceutica.getString("nombre"));
							}

							Modelo.Farmaceutica farmaceutica = miTrasformador.update();
							sql = "UPDATE farmaceutica SET NOMBRE='" + farmaceutica.getNombre() + "'," + " CIF='"
									+ farmaceutica.getCIF() + "', CIUDAD	= '" + farmaceutica.getCiudad() + "' "
									+ "WHERE id = " + farmaceutica.getId();
							System.out.println(sql);
							resultado = sentenciaSQL.executeUpdate(sql);

							if (resultado >= 1) {
								System.out.println("Se ha MODIFICADO bien.");
							}

							break;

						case "c":

							// Muestro todos los datos de la farmaceutica.

							ResultSet rs;
							sentenciaSQL = conexion.createStatement();

							sql = "SELECT * FROM farmaceutica";

							rs = sentenciaSQL.executeQuery(sql);

							System.out.println("*****************Resultado*******************");
							System.out.println("");

							while (rs.next()) {

								System.out.println("id: " + rs.getInt("id") + " || Nombre: " + rs.getString("nombre")
										+ " || CIF: " + rs.getString("cif") + " || Ciudad: " + rs.getString("ciudad"));
							}

							break;

						case "d":

							// Borro la farmaceutica. Añado un select para mostrar las diferentes
							// farmaceuticas

							ResultSet rsFarmaceuticaEliminar;
							sentenciaSQL = conexion.createStatement();

							sql = "SELECT * FROM farmaceutica";

							rsFarmaceuticaEliminar = sentenciaSQL.executeQuery(sql);
							while (rsFarmaceuticaEliminar.next()) {

								System.out.println(" Nombre: " + rsFarmaceuticaEliminar.getString("nombre"));
							}

							id = miTrasformador.borrar();

							sql = "DELETE FROM farmaceutica where id = " + id;
							System.out.println(sql);

							resultado = sentenciaSQL.executeUpdate(sql);

							if (resultado >= 1) {
								System.out.println("Se ha BORRADO bien.");
							}

							break;

						default:
							break;
						}

						break;

					case 2:

						// La opción "2" esta dedicada a la gestión de los medicamentos

						System.out.println("Elija una opción");
						System.out.println("a.- Crear nueva medicamento");
						System.out.println("b.- Modificar medicamento");
						System.out.println("c.- Ver datos medicamento");
						System.out.println("d.- Eliminar medicamento");
						opcion2 = lector.next();

						switch (opcion2) {
						case "a":

							// CREO UN NUEVO MEDICAMENTO
							ArrayList<Modelo.Medicamento> medicamentos = miRecogidaDatosMedicamento.datosMedicamento();
							for (Modelo.Medicamento medicamento : medicamentos) {
								sql = "INSERT INTO medicamento (NOMBRE, COMPOSICION, PRECIO) VALUES ('"
										+ medicamento.getNombre() + "', '" + medicamento.getComposicion() + "', '"
										+ medicamento.getPrecio() + "' )";
								System.out.println(sql);

								resultado = sentenciaSQL.executeUpdate(sql);

								if (resultado >= 1) {
									System.out.println("Se ha INSERTADO bien.");
								}
							}

							break;

						// MODIFICO EL MEDICAMENTO JUNTO A UN SELECT PARA IDENTIFICAR EL NOMBRE DEL
						// MEDICAMENTO

						case "b":

							ResultSet rsMedicamento;
							sentenciaSQL = conexion.createStatement();

							sql = "SELECT * FROM medicamento";

							rsMedicamento = sentenciaSQL.executeQuery(sql);
							while (rsMedicamento.next()) {

								System.out.println(" Nombre: " + rsMedicamento.getString("nombre"));
							}

							Modelo.Medicamento medicamento = miTrasformador.updatemedicamento();
							sql = "UPDATE medicamento SET NOMBRE='" + medicamento.getNombre() + "'," + " COMPOSICION='"
									+ medicamento.getComposicion() + "', PRECIO	= " + medicamento.getPrecio()
									+ " WHERE id =" + medicamento.getId();

							System.out.println(sql);
							resultado = sentenciaSQL.executeUpdate(sql);

							if (resultado >= 1) {
								System.out.println("Se ha MODIFICADO bien.");
							}

							break;

						case "c":

							// VEO DATOS DEL MEDICAMENTO
							ResultSet rs;
							sentenciaSQL = conexion.createStatement();

							sql = "SELECT * FROM medicamento";

							rs = sentenciaSQL.executeQuery(sql);

							System.out.println("*****************Resultado*******************");
							System.out.println("");

							while (rs.next()) {

								System.out.println("id: " + rs.getInt("id") + " || Nombre: " + rs.getString("nombre")
										+ " || Composición: " + rs.getString("composicion") + " || Precio: "
										+ rs.getInt("precio"));
							}

							break;

						case "d":

							// ELIMINO EL MEDICAMENTO QUE PUEDO CONSULTAR GRACIAS AL SELECT

							ResultSet rsMedicamentoEliminar;
							sentenciaSQL = conexion.createStatement();

							sql = "SELECT * FROM medicamento";

							rsMedicamentoEliminar = sentenciaSQL.executeQuery(sql);
							while (rsMedicamentoEliminar.next()) {

								System.out.println(" Nombre: " + rsMedicamentoEliminar.getString("nombre"));
							}

							id = miTrasformador.borrar();

							sql = "DELETE FROM m where id = " + id;
							System.out.println(sql);

							resultado = sentenciaSQL.executeUpdate(sql);

							if (resultado >= 1) {
								System.out.println("Se ha BORRADO bien.");
							}

							break;

						default:
							break;
						}

						break;
					case 3:

						// OPCION 3 PARA PODER RELACCIONAR EL MEDICAMENTO CON LA FARMACEUTICA QUE LO
						// FABRICA
						String farmaceutica;
						String medicamento;
						int stock;
						ResultSet rsFarmaceutica;
						ResultSet rsMedicamentoAnadir;
						ResultSet rsMedicamento;
						int idFarmaceutica = 0;
						int idMedicamento = 0;

						sentenciaSQL = conexion.createStatement();

						do {

							System.out.println("¿A que farmaceutica quiere agregar medicamentos?");
							sql = "SELECT * FROM farmaceutica";

							rsFarmaceutica = sentenciaSQL.executeQuery(sql);
							while (rsFarmaceutica.next()) {

								System.out.println(" Nombre: " + rsFarmaceutica.getString("nombre"));
							}

							farmaceutica = lector.next();

							System.out.println("¿Qué medicamento quiere agregar a la farmaceutica " + farmaceutica + "?");

							sql = "SELECT * FROM medicamento";

							rsMedicamentoAnadir = sentenciaSQL.executeQuery(sql);
							while (rsMedicamentoAnadir.next()) {

								System.out.println(" Nombre: " + rsMedicamentoAnadir.getString("nombre"));
							}

							medicamento = lector.next();

							System.out.println("¿Cuál es el stock disponible del medicamento" + medicamento + "?");
							stock = lector.nextInt();
							lector.nextLine();

							// NECESITAMOS ID DE LA FARMACEUTICA CON UN SELECT LO CONSIGO GRACIAS AL NOMBRE
							// DEL FARMACEUTICA

							sql = "SELECT ID FROM farmaceutica where nombre = '" + farmaceutica + "'";
							rsFarmaceutica = sentenciaSQL.executeQuery(sql);

							if (rsFarmaceutica.next()) {
								// Si hay resultados obtengo el valor.
								idFarmaceutica = rsFarmaceutica.getInt(1);
							}

							// NECESITAMOS ID DEL MEDICAMENTO CON UN SELECT LO CONSIGO GRACIAS AL NOMBRE DEL
							// MEDICAMENTO

							sql = "SELECT ID FROM medicamento where nombre = '" + medicamento + "'";
							rsMedicamento = sentenciaSQL.executeQuery(sql);

							if (rsMedicamento.next()) {
								// Si hay resultados obtengo el valor.
								idMedicamento = rsMedicamento.getInt(1);
							}

							// METO EN LA TABLA VINCULANTE EL ID DE LA FARMACIA, EL ID DEL MEDICAMENTO Y EL
							// STOCK

							sql = "INSERT INTO farmaceutica_medicamento (FARMACEUTICA_ID, MEDICAMENTO_ID, STOCK) VALUES ('"
									+ idFarmaceutica + "', '" + idMedicamento + "', '" + stock + "' )";
							System.out.println(sql);

							resultado = sentenciaSQL.executeUpdate(sql);

							if (resultado >= 1) {
								System.out.println("Se ha INSERTADO bien farmaceutica " + farmaceutica
										+ ", medicamento " + medicamento + " y el stock " + stock + ".");
							}

							System.out.println("Escriba una S para salir");
							salir = lector.next();

						} while (!salir.equals("s"));

						break;

					case 4:

						// OCION 4 RELACCIONO LA TABLA MEDICAMENTO Y FARMACEUTICA PARA IMPRIMIR QUE
						// FARMACEUTICAS ELABORAN QUE MEDICAMENTO
						// USO DOS INNER CON LA TABLA VINCULANTE POR MEDIO
						String nombreFarmaceutica;
						ResultSet rsFarmaceutica2;
						ResultSet rs2;
						int idFarmaceutica2 = 0;
						ResultSet rsFarmaceutica4;

						// QUE FARMACIA QUIERO CONSULTAR

						System.out.println("¿De que farmaceutica quiere conocer los medicamentos?");

						sql = "SELECT * FROM farmaceutica";

						rsFarmaceutica4 = sentenciaSQL.executeQuery(sql);

						while (rsFarmaceutica4.next()) {

							System.out.println(rsFarmaceutica4.getString("nombre"));
						}

						nombreFarmaceutica = lector.next();

						// CONSIGO EL ID DE LA FARMACEUTICA

						sql = "SELECT ID FROM farmaceutica where nombre = '" + nombreFarmaceutica + "'";
						rsFarmaceutica2 = sentenciaSQL.executeQuery(sql);

						if (rsFarmaceutica2.next()) {
							// Si hay resultados obtengo el valor.
							idFarmaceutica2 = rsFarmaceutica2.getInt(1);
						}

						// HAGO LA QUERY PARA RELACCIONAR LAS TABLAS Y MOSTRAR EL NOMBRE DE LA
						// FARMACEUTICA CON SUS MEDICAMENTOS SIEMPRE QUE EL F.ID = IDFARMACEUTICA

						sql = "select f.nombre as Farmaceutica, m.nombre as Medicamento" + " from farmaceutica f"
								+ " join farmaceutica_medicamento r on f.id = r.farmaceutica_id"
								+ " join medicamento m on m.id = r.medicamento_id" + " where f.id=" + idFarmaceutica2;

						rs2 = sentenciaSQL.executeQuery(sql);

						while (rs2.next()) {
							// Si hay resultados obtengo el valor.
							System.out.println("*****************Resultado*******************");
							System.out.println("");

							System.out.println("La farmaceutica: " + rs2.getString("Farmaceutica") + " produce: "
									+ rs2.getString("Medicamento"));
						}
						break;
					case 5:

						// OPCION 5 TENIENDO EN CUENTA EL MEDICAMENTO, PUEDO CONSULTAR CUAL/ES ES LA
						// FARMACIA QUE LO FABRICA
						String nombreMedicamento;
						ResultSet rsFarmaceutica3;
						ResultSet rs3;
						int idMedicamento2 = 0;
						ResultSet rsMedicamentos;

						// IDENTIFICO EL MEDICAMENTO

						System.out.println("¿De cual medicamente desea la información?");
						sql = "SELECT * FROM medicamento";

						rsMedicamentos = sentenciaSQL.executeQuery(sql);

						while (rsMedicamentos.next()) {

							System.out.println(rsMedicamentos.getString("nombre"));
						}
						nombreMedicamento = lector.next();

						// AVERIGUO EL ID DEL MEDICAMENTO

						sql = "SELECT ID FROM medicamento where nombre = '" + nombreMedicamento + "'";
						rsFarmaceutica3 = sentenciaSQL.executeQuery(sql);

						if (rsFarmaceutica3.next()) {
							// Si hay resultados obtengo el valor.
							idMedicamento2 = rsFarmaceutica3.getInt(1);
						}

						// RELACIONO LAS TABLAS Y MUESTRO EL NOMBRE DEL MEDICAMENTO Y DE LA FARMACEUTICA

						sql = "select f.nombre as Farmaceutica, m.nombre as Medicamento" + " from farmaceutica f"
								+ " join farmaceutica_medicamento r on f.id = r.farmaceutica_id"
								+ " join medicamento m on m.id = r.medicamento_id" + " where m.id=" + idMedicamento2;

						rs3 = sentenciaSQL.executeQuery(sql);

						while (rs3.next()) {
							// Si hay resultados obtengo el valor.

							System.out.println("*****************Resultado*******************");
							System.out.println("");

							System.out.println("El medicamento: " + rs3.getString("Medicamento") + " se produce en: "
									+ rs3.getString("Farmaceutica"));
						}

						break;
					case 6:

						// OPCION 6 CUANTOS MEDICAMENTOS HAY EN TOTAL
						// Cuantos medicamentos hay.
						int numero = 0;

						try {
							// conectar con la base de datos
							Class.forName("com.mysql.jdbc.Driver");
							conexion = DriverManager.getConnection("jdbc:mysql://localhost/laboratorios", "root", "");
							// creamos sentencias ejecutables sobre esa conexión
							sentenciaSQL = conexion.createStatement();
							// almaceno el resultado de la sql en un resulset (conjunto de registros)
							ResultSet rs = sentenciaSQL.executeQuery("SELECT count(*) FROM medicamento");
							// chequeo que el result set no sea vacío, moviendo el cursor a la
							// primer fila. (El cursor inicia antes de la primer fila)
							if (rs.next()) {
								// Si hay resultados obtengo el valor.
								numero = rs.getInt(1);

								System.out.println("*****************Resultado*******************");
								System.out.println("");
								System.out.println("Existen " + numero + " medicamentos");
							}

						} catch (SQLException ex) {
							ex.printStackTrace();
							// System.out.println("Error");
						} finally {
							conexion.close();

						}

						System.out.println("Conectado/desconectado");

						break;
					case 7:
						// OPCION 7 CUAL ES EL MEDICAMENTO MAS CARO

						ResultSet rs;

						try {

							Class.forName("com.mysql.jdbc.Driver");
							conexion = DriverManager.getConnection("jdbc:mysql://localhost/laboratorios", "root", "");

							sentenciaSQL = conexion.createStatement();

							sql = "select nombre, precio from medicamento order by precio desc limit 1";

							rs = sentenciaSQL.executeQuery(sql);

							while (rs.next()) {
								// Si hay resultados obtengo el valor.

								System.out.println("*****************Resultado*******************");
								System.out.println("");

								System.out.println("El medicamento más caro es: " + rs.getString("nombre")
										+ " y su precio es de: " + rs.getInt("precio") + "€");
							}

						} catch (SQLException ex) {
							ex.printStackTrace();
							// System.out.println("Error");
						} finally {
							conexion.close();

						}

						System.out.println("Conectado/desconectado");

						break;
					case 8:
						// CONSULTO DONDE SE ENCUENTRA EL MAYOR STOCK DE UN MEDICAMENTO

						ResultSet rs1;
						String nombreMedicamentoStock;
						// CUAL FARMACEUTICA TIENE MAS STOCK DE UN MEDICAMENTO
						ResultSet rsFarmaceuticaMasStock;
						sentenciaSQL = conexion.createStatement();

						// IDENTIFICO EL MEDICAMENTO

						System.out.println("¿Escriba el nombre del medicamento?");

						// UN SELECT PARA MOSTRAR LA LISTA DE MEDICAMENTOS

						sql = "SELECT * FROM medicamento";

						rsFarmaceuticaMasStock = sentenciaSQL.executeQuery(sql);
						while (rsFarmaceuticaMasStock.next()) {

							System.out.println(" Nombre: " + rsFarmaceuticaMasStock.getString("nombre"));
						}

						nombreMedicamentoStock = lector.next();

						try {

							Class.forName("com.mysql.jdbc.Driver");
							conexion = DriverManager.getConnection("jdbc:mysql://localhost/laboratorios", "root", "");

							sentenciaSQL = conexion.createStatement();

							// UNA QUERY PARA MOSTRAR EN NOMBRE DE LA FARMACIA Y EL NOMBRE DEL MEDICAMENTO

							sql = "select farmaceutica.nombre as Farmaceutica, medicamento.nombre as Medicamento, stock"
									+ " from farmaceutica"
									+ " join farmaceutica_medicamento on farmaceutica_medicamento.farmaceutica_id = farmaceutica.id"
									+ " join medicamento on medicamento.id = farmaceutica_medicamento.medicamento_id"
									+ " where medicamento.nombre = '" + nombreMedicamentoStock + "'"
									+ " order by stock desc limit 1";

							rs1 = sentenciaSQL.executeQuery(sql);

							while (rs1.next()) {
								// Si hay resultados obtengo el valor.

								System.out.println("*****************Resultado*******************");
								System.out.println("");

								System.out.println(
										"La farmaceutica: " + rs1.getString("Farmaceutica") + " tiene un stock de "
												+ rs1.getInt("stock") + " unidades de " + rs1.getString("Medicamento"));

								System.out.println("");

							}

						} catch (SQLException ex) {
							ex.printStackTrace();
							// System.out.println("Error");
						} finally {
							conexion.close();

						}

						System.out.println("Conectado/desconectado");

						break;
					case 9:

						// OPCION 9 PARA ABANDONAR EL PROGRAMA

						System.out.println("Gracias por utilizar nuestros servicios");

						opcionSalir = lector.next();

						break;
					}

				} catch (Exception e) {

					System.out.println("Ha ocurriodo algún error al introducir los datos");

				}

				conexion.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
				// System.out.println("Error");
			}

			System.out.println("Conectado/desconectado");

		} while (!opcionSalir.equals("s"));

	}

}
