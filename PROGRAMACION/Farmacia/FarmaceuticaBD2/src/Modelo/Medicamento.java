package Modelo;
import java.util.ArrayList;

public class Medicamento {

	private int id;
	private String nombre;
	private String composicion;
	private float precio;
	private ArrayList<Farmaceutica> farmaceuticasList;

	public Medicamento(int id, String nombre, String composicion, float precio,
			ArrayList<Farmaceutica> farmaceuticasList) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.composicion = composicion;
		this.precio = precio;
		this.farmaceuticasList = farmaceuticasList;
	}

	public Medicamento() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getComposicion() {
		return composicion;
	}

	public void setComposicion(String composicion) {
		this.composicion = composicion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public ArrayList<Farmaceutica> getFarmaceuticasList() {
		return farmaceuticasList;
	}

	public void setFarmaceuticasList(ArrayList<Farmaceutica> farmaceuticasList) {
		this.farmaceuticasList = farmaceuticasList;
	}

	@Override
	public String toString() {
		return "Medicamento [nombre=" + nombre + ", composicion=" + composicion + ", precio=" + precio + "]";
	}

}
