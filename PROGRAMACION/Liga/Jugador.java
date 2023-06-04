
public class Jugador {

	private String nombre;
	private String posicion;
	private int dorsal;
	private Equipo equipo;

	public Jugador() {
		super();
	}

	public Jugador(String nombre, String posicion, int dorsal, Equipo equipo) {
		super();
		this.nombre = nombre;
		this.posicion = posicion;
		this.dorsal = dorsal;
		this.equipo = equipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", posicion=" + posicion + ", dorsal=" + dorsal + ", equipo=" + equipo
				+ "]";
	}

}
