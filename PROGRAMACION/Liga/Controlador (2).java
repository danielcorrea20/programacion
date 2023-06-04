
import java.util.ArrayList;
import java.util.Scanner;

public class Controlador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numEquipos;
		int opcion = 0;
		int opcion2;
		int opcion3;
		int opcion4;
		int opcion5;
		int opcion6;
		int despidoD;
		int modificarD;
		int nuevoDorsal;
		
		String nuevoNombre;
		String nuevaPosicion;
		String despidoN;

		ArrayList<Jugador> plantilla = new ArrayList<Jugador>();

		Jugador baseDeDatosJugadores = new Jugador();
		
		Liga JapanLeague = new Liga();

		Equipo RMadrid = new Equipo("Real Madrid CF", "Madrid");

		Equipo FCBarcelona = new Equipo("FC Barcelona", "Barcelona");

		Equipo MamboCF = new Equipo("Mambo CF", "Osaka");

		Equipo NewTeam = new Equipo("New Team FC", "Kyoto");

		Equipo SanFrancis = new Equipo("San Francis AD", "Tokyo");

		Equipo MapedFC = new Equipo("Maped FC", "Fukushima");

		Equipo jugadores = new Equipo("", "");

		Jugador Oliver = new Jugador("Oliver Atom", "Delantero", 10, NewTeam);
		Jugador Tom = new Jugador("Tom Baker", "Medio", 7, NewTeam);
		Jugador Bruce = new Jugador("Bruce Harper", "Defensa", 2, NewTeam);
		Jugador Benji = new Jugador("Benji Price", "Portero", 1, NewTeam);
		Jugador Nakamura = new Jugador("Ken Nakamura", "Delantero", 11, NewTeam);

		Jugador Julian = new Jugador("Julian Ross", "Delantero", 10, MamboCF);
		Jugador Marc = new Jugador("Marc Ruud", "Medio", 8, MamboCF);
		Jugador Robbie = new Jugador("Robbie Price", "Defensa", 3, MamboCF);
		Jugador Louise = new Jugador("Louise Ben", "Portero", 1, MamboCF);
		Jugador Carlos = new Jugador("Carlos Rufiangel", "Delantero", 9, MamboCF);

		Jugador Robert = new Jugador("Robert Lewandoski", "Delantero", 9, FCBarcelona);
		Jugador Pedri = new Jugador("Pedri Gonzalez", "Medio", 8, FCBarcelona);
		Jugador Gavi = new Jugador("Pablo Gavi", "Medio", 6, FCBarcelona);
		Jugador Kounde = new Jugador("Jules Kounde", "Defensa", 2, FCBarcelona);
		Jugador Ter = new Jugador("Andres Ter Stegen", "Portero", 1, FCBarcelona);

		Jugador Benzema = new Jugador("Karim Benzema", "Delantero", 9, RMadrid);
		Jugador Kross = new Jugador("Toni Kross", "Medio", 8, RMadrid);
		Jugador Militao = new Jugador("Eder Militao", "Defensa", 3, RMadrid);
		Jugador Courtois = new Jugador("Thibauts Courtois", "Portero", 1, RMadrid);
		Jugador Rodrigo = new Jugador("Rodrygo Goes", "Delantero", 11, RMadrid);

		Jugador Mellow = new Jugador("Daniel Mellow", "Delantero", 9, MapedFC);
		Jugador Ed = new Jugador("Ed Warner", "Portero", 1, MapedFC);
		Jugador Victor = new Jugador("Victor Torrevieja", "Defensa", 2, MapedFC);
		Jugador Andres = new Jugador("Andres Iniesta", "Medio", 8, MapedFC);
		Jugador Lenders = new Jugador("Mark Lenders", "Delantero", 10, MapedFC);

		Jugador Hiroshi = new Jugador("Hiroshi Kubo", "Delantero", 9, SanFrancis);
		Jugador Clauss = new Jugador("Clauss White", "Medio", 10, SanFrancis);
		Jugador Vic = new Jugador("William Vic", "Defensa", 2, SanFrancis);
		Jugador Cork = new Jugador("Constance Cork", "Portero", 1, SanFrancis);
		Jugador Green = new Jugador("Sam Green", "Delantero", 11, SanFrancis);

		NewTeam.addJugador(Oliver);
		NewTeam.addJugador(Tom);
		NewTeam.addJugador(Bruce);
		NewTeam.addJugador(Benji);
		NewTeam.addJugador(Nakamura);

		MamboCF.addJugador(Julian);
		MamboCF.addJugador(Robbie);
		MamboCF.addJugador(Marc);
		MamboCF.addJugador(Carlos);
		MamboCF.addJugador(Louise);

		FCBarcelona.addJugador(Ter);
		FCBarcelona.addJugador(Pedri);
		FCBarcelona.addJugador(Gavi);
		FCBarcelona.addJugador(Kounde);
		FCBarcelona.addJugador(Robert);

		RMadrid.addJugador(Rodrigo);
		RMadrid.addJugador(Courtois);
		RMadrid.addJugador(Benzema);
		RMadrid.addJugador(Kross);
		RMadrid.addJugador(Militao);

		MapedFC.addJugador(Mellow);
		MapedFC.addJugador(Victor);
		MapedFC.addJugador(Ed);
		MapedFC.addJugador(Andres);
		MapedFC.addJugador(Lenders);

		SanFrancis.addJugador(Hiroshi);
		SanFrancis.addJugador(Clauss);
		SanFrancis.addJugador(Vic);
		SanFrancis.addJugador(Cork);
		SanFrancis.addJugador(Green);
		
		JapanLeague.addEquipos(NewTeam);
		JapanLeague.addEquipos(MapedFC);
		JapanLeague.addEquipos(SanFrancis);
		JapanLeague.addEquipos(MamboCF);
		JapanLeague.addEquipos(FCBarcelona);
		JapanLeague.addEquipos(RMadrid);
		
		Scanner lector = new Scanner(System.in);

		while (opcion != 6) {

			// podría sacarlo del while, para que no se repita abajo. De este modo
			// recuerdo las opciones al usuario

			System.out.println("");
			System.out.println("Introduce una opcion:");
			System.out.println("1.- Fichar jugador");
			System.out.println("2.- Despedir jugador");
			System.out.println("3.- Modificar jugador");
			System.out.println("4.- Mostrar plantilla");
			System.out.println("5.- Crea las jornadas");
			System.out.println("6.- Salir");
			System.out.println("");
			opcion = lector.nextInt();
			lector.nextLine();

			// uso un switch al ser una comparativa con los iguales.

			switch (opcion) {
			case 1:

				// En el primer caso llamo al metodo anadirJugador para fichar.
				// Seteo los atributos con los string e int que paso por consola.
				// Creo un objeto fichaje para poder utilizar los métodos.
				Jugador fichaje = new Jugador();

				System.out.println("Escribe el nombre del jugador");
				fichaje.setNombre(lector.next());
				System.out.println("Escribe la posición del jugador");
				fichaje.setPosicion(lector.next());
				System.out.println("Escribe el dorsal del jugador");
				fichaje.setDorsal(lector.nextInt());
				lector.nextLine();
				System.out.println("¿Cual es el equipo que ficha?");
				System.out.println("1. New Team");
				System.out.println("2. Mambo CF");
				System.out.println("3. FC Barcelona");
				System.out.println("4. Real Madrid");
				System.out.println("5. Maped FC");
				System.out.println("6. San Francis");
				opcion3 = lector.nextInt();
				lector.nextLine();
				// Añado el fichaje al equipo seleccionado
				
				jugadores.setPlantilla(jugadores.anadirJugador(plantilla, fichaje));

				switch (opcion3) {
				case 1: {
					NewTeam.addJugador(fichaje);
					fichaje.setEquipo(NewTeam);
					NewTeam.mostrarPlantilla(NewTeam);
					System.out.println(" ");
					System.out.println("Jugador fichado");
					break;
				}
				case 2: {
					MamboCF.addJugador(fichaje);
					fichaje.setEquipo(MamboCF);
					MamboCF.mostrarPlantilla(MamboCF);
					System.out.println(" ");
					System.out.println("Jugador fichado");
					break;
				}
				case 3: {
					FCBarcelona.addJugador(fichaje);
					fichaje.setEquipo(FCBarcelona);
					FCBarcelona.mostrarPlantilla(FCBarcelona);
					System.out.println(" ");
					System.out.println("Jugador fichado");
					break;
				}
				case 4: {
					RMadrid.addJugador(fichaje);
					fichaje.setEquipo(RMadrid);
					RMadrid.mostrarPlantilla(RMadrid);
					System.out.println(" ");
					System.out.println("Jugador fichado");
					break;
				}
				case 5: {
					MapedFC.addJugador(fichaje);
					fichaje.setEquipo(MapedFC);
					MapedFC.mostrarPlantilla(MapedFC);
					System.out.println(" ");
					System.out.println("Jugador fichado");
					break;
				}
				case 6: {
					SanFrancis.addJugador(fichaje);
					fichaje.setEquipo(SanFrancis);
					SanFrancis.mostrarPlantilla(SanFrancis);
					System.out.println(" ");
					System.out.println("Jugador fichado");
					break;
				}
				default:
					System.out.println("No existe");
					break;
				}
				break;
			case 2:
				System.out.println("¿Donde está el jugador que quieres despedir?");
				System.out.println("1. Real Madrid");
				System.out.println("2. FC Barcelona");
				System.out.println("3. Mambo CF");
				System.out.println("4. New Team");
				System.out.println("5. San Francis");
				System.out.println("6. Maped CF");
				opcion4 = lector.nextInt();
				lector.nextLine();
				switch (opcion4) {
				case 1: {
					RMadrid.mostrarPlantilla(RMadrid);
					System.out.println(" ");
					System.out.println("1. Eliminarlo por dorsal");
					System.out.println("2. Eliminarlo por nombre");
					opcion5 = lector.nextInt();
					lector.nextLine();
					switch (opcion5) {
					case 1: {
						System.out.println("¿Qué dorsal utiliza?");
						despidoD = lector.nextInt();
						lector.nextLine();
						RMadrid.despedirJugadorEquipoDorsal(RMadrid, despidoD);
						System.out.println("Jugador eliminado");
					}
					case 2: {
						System.out.println("¿Qué nombre tiene?");
						despidoN = lector.nextLine();
						RMadrid.despedirJugadorEquipoNombre(RMadrid, despidoN);
						System.out.println("Jugador eliminado");
					}
					}

				}
				break;
				case 2: {
					FCBarcelona.mostrarPlantilla(FCBarcelona);
					System.out.println(" ");
					System.out.println("1. Eliminarlo por dorsal");
					System.out.println("2. Eliminarlo por nombre");
					opcion5 = lector.nextInt();
					lector.nextLine();
					switch (opcion5) {
					case 1: {
						System.out.println("¿Qué dorsal utiliza?");
						despidoD = lector.nextInt();
						lector.nextLine();
						FCBarcelona.despedirJugadorEquipoDorsal(FCBarcelona, despidoD);
						System.out.println("Jugador eliminado");
					}
					case 2: {
						System.out.println("¿Qué nombre tiene?");
						despidoN = lector.nextLine();
						FCBarcelona.despedirJugadorEquipoNombre(FCBarcelona, despidoN);
						System.out.println("Jugador eliminado");
					}
					}

				}
				break;
				case 3: {
					MamboCF.mostrarPlantilla(MamboCF);
					System.out.println(" ");
					System.out.println("1. Eliminarlo por dorsal");
					System.out.println("2. Eliminarlo por nombre");
					opcion5 = lector.nextInt();
					lector.nextLine();
					switch (opcion5) {
					case 1: {
						System.out.println("¿Qué dorsal utiliza?");
						despidoD = lector.nextInt();
						lector.nextLine();
						MamboCF.despedirJugadorEquipoDorsal(MamboCF, despidoD);
						System.out.println("Jugador eliminado");
					}
					case 2: {
						System.out.println("¿Qué nombre tiene?");
						despidoN = lector.nextLine();
						MamboCF.despedirJugadorEquipoNombre(MamboCF, despidoN);
						System.out.println("Jugador eliminado");
					}
					}

				}
				break;
				case 4: {
					NewTeam.mostrarPlantilla(NewTeam);
					System.out.println(" ");
					System.out.println("1. Eliminarlo por dorsal");
					System.out.println("2. Eliminarlo por nombre");
					opcion5 = lector.nextInt();
					lector.nextLine();
					switch (opcion5) {
					case 1: {
						System.out.println("¿Qué dorsal utiliza?");
						despidoD = lector.nextInt();
						lector.nextLine();
						NewTeam.despedirJugadorEquipoDorsal(NewTeam, despidoD);
						System.out.println("Jugador eliminado");
					}
					case 2: {
						System.out.println("¿Qué nombre tiene?");
						despidoN = lector.nextLine();
						NewTeam.despedirJugadorEquipoNombre(NewTeam, despidoN);
						System.out.println("Jugador eliminado");
					}
					}

				}
				break;
				case 5: {
					SanFrancis.mostrarPlantilla(SanFrancis);
					System.out.println(" ");
					System.out.println("1. Eliminarlo por dorsal");
					System.out.println("2. Eliminarlo por nombre");
					opcion5 = lector.nextInt();
					lector.nextLine();
					switch (opcion5) {
					case 1: {
						System.out.println("¿Qué dorsal utiliza?");
						despidoD = lector.nextInt();
						lector.nextLine();
						SanFrancis.despedirJugadorEquipoDorsal(SanFrancis, despidoD);
						System.out.println("Jugador eliminado");
					}
					case 2: {
						System.out.println("¿Qué nombre tiene?");
						despidoN = lector.nextLine();
						SanFrancis.despedirJugadorEquipoNombre(SanFrancis, despidoN);
						System.out.println("Jugador eliminado");
					}
					}

				}
				break;
				case 6: {
					MapedFC.mostrarPlantilla(MapedFC);
					System.out.println(" ");
					System.out.println("1. Eliminarlo por dorsal");
					System.out.println("2. Eliminarlo por nombre");
					opcion5 = lector.nextInt();
					lector.nextLine();
					switch (opcion5) {
					case 1: {
						System.out.println("¿Qué dorsal utiliza?");
						despidoD = lector.nextInt();
						lector.nextLine();
						MapedFC.despedirJugadorEquipoDorsal(MapedFC, despidoD);
						System.out.println("Jugador eliminado");
					}
					case 2: {
						System.out.println("¿Qué nombre tiene?");
						despidoN = lector.nextLine();
						MapedFC.despedirJugadorEquipoNombre(MapedFC, despidoN);
						System.out.println("Jugador eliminado");
					}
					}

				}
				break;
				}

				break;
			case 3:
				System.out.println("¿En qué equipo está el jugador que quieres modificar?");
				System.out.println("1. New Team");
				System.out.println("2. Mambo CF");
				System.out.println("3. FC Barcelona");
				System.out.println("4. Real Madrid");
				System.out.println("5. Maped FC");
				System.out.println("6. San Francis");
				opcion6 = lector.nextInt();
				lector.nextLine();
				System.out.println("¿Qué dolsal utiliza el jugador que quieres modificar?");
				modificarD = lector.nextInt();
				lector.nextLine();
				System.out.println("Escribe el nuevo nombre");
				nuevoNombre = lector.nextLine();
				System.out.println("Escribe la nueva posicion");
				nuevaPosicion = lector.nextLine();
				System.out.println("Escribe el nuevo dorsal");
				nuevoDorsal = lector.nextInt();
				lector.nextLine();
				switch (opcion6) {
				case 1: 
					
					NewTeam.modificarJugador(NewTeam, modificarD, nuevoDorsal, nuevoNombre, nuevaPosicion);
					for(Jugador elemento: NewTeam.getPlantilla()) {
						if(elemento.getDorsal() == nuevoDorsal) {
							System.out.println(elemento.toString());
							System.out.println(" ");
						}
					}
					System.out.println("Jugador modificado");
					System.out.println(" ");
					
				break;
				
				case 2:
					
					MamboCF.modificarJugador(MamboCF, modificarD, nuevoDorsal, nuevoNombre, nuevaPosicion);
					for(Jugador elemento: MamboCF.getPlantilla()) {
						if(elemento.getDorsal() == nuevoDorsal) {
							System.out.println(elemento.toString());
							System.out.println(" ");
						}
					}
					System.out.println("Jugador modificado");
					System.out.println(" ");
					
				break;
				
				case 3:

					FCBarcelona.modificarJugador(FCBarcelona, modificarD, nuevoDorsal, nuevoNombre, nuevaPosicion);
					for(Jugador elemento: FCBarcelona.getPlantilla()) {
						if(elemento.getDorsal() == nuevoDorsal) {
							System.out.println(elemento.toString());
							System.out.println(" ");
						}
					}
					System.out.println("Jugador modificado");
					System.out.println(" ");
					
				break;
				
				case 4:

					RMadrid.modificarJugador(RMadrid, modificarD, nuevoDorsal, nuevoNombre, nuevaPosicion);
					for(Jugador elemento: RMadrid.getPlantilla()) {
						if(elemento.getDorsal() == nuevoDorsal) {
							System.out.println(elemento.toString());
							System.out.println(" ");
						}
					}
					System.out.println("Jugador modificado");
					System.out.println(" ");
					
				break;
				
				case 5:
					
					MapedFC.modificarJugador(MapedFC, modificarD, nuevoDorsal, nuevoNombre, nuevaPosicion);
					for(Jugador elemento: MapedFC.getPlantilla()) {
						if(elemento.getDorsal() == nuevoDorsal) {
							System.out.println(elemento.toString());
							System.out.println(" ");
						}
					}
					System.out.println("Jugador modificado");
					System.out.println(" ");
					
				break;
				
				case 6:

					SanFrancis.modificarJugador(SanFrancis, modificarD, nuevoDorsal, nuevoNombre, nuevaPosicion);
					for(Jugador elemento: SanFrancis.getPlantilla()) {
						if(elemento.getDorsal() == nuevoDorsal) {
							System.out.println(elemento.toString());
							System.out.println(" ");
						}
					}
					System.out.println("Jugador modificado");
					System.out.println(" ");
					
				break;
				}

			case 4:
				// Esta cuarta opción muestra la plantilla
				System.out.println("¿De que equipo quiere ver la plantilla?");
				System.out.println("1. New Team");
				System.out.println("2. Mambo CF");
				System.out.println("3. FC Barcelona");
				System.out.println("4. Real Madrid");
				System.out.println("5. Maped FC");
				System.out.println("6. San Francis");
				opcion2 = lector.nextInt();
				lector.nextLine();
				switch (opcion2) {
				case 1: {
					NewTeam.mostrarPlantilla(NewTeam);
				}
					break;
				case 2: {
					MamboCF.mostrarPlantilla(MamboCF);
				}
					break;
				case 3: {
					FCBarcelona.mostrarPlantilla(FCBarcelona);
				}
					break;
				case 4: {
					RMadrid.mostrarPlantilla(RMadrid);
				}
					break;
				case 5: {
					MapedFC.mostrarPlantilla(MapedFC);
				}
					break;
				case 6: {
					SanFrancis.mostrarPlantilla(SanFrancis);
				}
					break;
				default: {
					System.out.println("Equipo no válido");
				}
					break;
				}
				break;
			case 5:
				// Para hacer las jornadas
				do {
					System.out.println("¿De cuantos equipos será la liga?");
					numEquipos = lector.nextInt();
					lector.nextLine();
				} while (numEquipos < 2 || numEquipos > 22);
				Liga miJornada = new Liga();
				miJornada.jornada(numEquipos);
				break;
			case 6:
				// La quinta opción sale del programa
				System.out.println("Hasta la próxima");
				break;
			default:
				// Opción incorrecta
				System.out.println("Opción incorrecta");
				break;
			}
		}

		lector.close();

	}

}