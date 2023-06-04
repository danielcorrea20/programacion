import java.util.ArrayList;

public class Equipo {

	private String nombre;
	private String Localidad;
	private ArrayList<Jugador> plantilla = new ArrayList<Jugador>();

	public Equipo() {
		super();
	}

	public Equipo(String nombre, String localidad) {
		super();
		this.nombre = nombre;
		Localidad = localidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}

	public ArrayList<Jugador> getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(ArrayList<Jugador> plantilla) {
		this.plantilla = plantilla;
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", Localidad=" + Localidad + "]";
	}

	// Método mostrar plantilla
	public void mostrarPlantilla(Equipo equipo) {
		System.out.println("******" + equipo.getNombre() + "******");
		// Recorro la lista con un for
		for (Jugador jugador : equipo.getPlantilla()) {
			// hago un getter para mostra el nombre, la posición y el dorsal de cada
			// jugador.
			System.out.println("Nombre: " + jugador.getNombre() + " | " + "Posicion: " + jugador.getPosicion() + " | " + "Dorsal: " + jugador.getDorsal());
		}
	}
	
	/*Añadir fichaje a un equipo especifico*/

	public ArrayList<Jugador> anadirJugador(ArrayList<Jugador> plantilla, Jugador jugador) {
		plantilla.add(jugador);
		return plantilla;
	}
	
	/*Añadir jugadores a su equipo*/
	public void addJugador(Jugador item) {
		plantilla.add(item);
	}

	// Metodo para despedir el jugador, le llevo la lista y un string que leeré con
	// el lector.

	public void despedirJugador(ArrayList<Jugador> plantilla, String nombreJugadorDespedido) {
		// recorro la lista con un for.
		for (int i = 0; i < plantilla.size(); i++) {
			// Si el string nombreJugadorDespedido coincide con uno de los nombre de la
			// lista lo elimino.
			if (plantilla.get(i).getNombre().equals(nombreJugadorDespedido)) {
				plantilla.remove(i);
			}
		}
	};

	// Método para modificar un jugador. Le paso la plantilla, el nombre del jugador
	// que quiero modificar y las modificaciones.
		public Equipo modificarJugador(Equipo equipo, int dorsalJugador, int nuevoDorsal, String nuevoNombre, String nuevaPosicion) {
			// recorro la lista con un for.        
			for (int i = 0; i < equipo.getPlantilla().size(); i++) {
				if (equipo.getPlantilla().get(i).getDorsal() == dorsalJugador) {
					equipo.getPlantilla().get(i).setDorsal(nuevoDorsal);
					equipo.getPlantilla().get(i).setNombre(nuevoNombre);
					equipo.getPlantilla().get(i).setPosicion(nuevaPosicion);
					}
			}
			return equipo;
		}
		
	public void removeJugador(int dorsalD) {
		for(int i = 0; i < 5; i++) {
			if(plantilla.get(i).getDorsal() == dorsalD) {
				plantilla.remove(plantilla.get(i));
			}
		}
		
	}
	
	public Equipo despedirJugadorEquipoNombre(Equipo equipo, String nombreJugadorDespedido) {
		// recorro la lista con un for.        
		for (int i = 0; i < equipo.getPlantilla().size(); i++) {
			// Si el string nombreJugadorDespedido coincide con uno de los nombre de la lista lo elimino.            
			if (equipo.getPlantilla().get(i).getNombre().equals(nombreJugadorDespedido)) {
				equipo.getPlantilla().remove(i);
				}
		}
		return equipo;
	}
	
	public Equipo despedirJugadorEquipoDorsal(Equipo equipo, int dorsalJugadorDespedido) {
		// recorro la lista con un for.        
		for (int i = 0; i < equipo.getPlantilla().size(); i++) {
			// Si el string nombreJugadorDespedido coincide con uno de los nombre de la lista lo elimino.            
			if (equipo.getPlantilla().get(i).getDorsal() == dorsalJugadorDespedido) {
				equipo.getPlantilla().remove(i);
				}
		}
		return equipo;
	}
	


}