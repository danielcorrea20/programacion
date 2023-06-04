package Modelo;
import java.util.ArrayList;

public class Farmaceutica {
	private int id;
	private String nombre;
	private String CIF;
	private String ciudad;
	private ArrayList<Medicamento> medicamentosList;

	public Farmaceutica(int id, String nombre, String CIF, String ciudad, ArrayList<Medicamento> medicamentosList) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.CIF = CIF;
		this.ciudad = ciudad;

		this.medicamentosList = medicamentosList;
	}

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String cIF) {
		CIF = cIF;
	}

	public ArrayList<Medicamento> getMedicamentosList() {
		return medicamentosList;
	}

	public void setMedicamentosList(ArrayList<Medicamento> medicamentosList) {
		this.medicamentosList = medicamentosList;
	}

	public Farmaceutica() {
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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

}
