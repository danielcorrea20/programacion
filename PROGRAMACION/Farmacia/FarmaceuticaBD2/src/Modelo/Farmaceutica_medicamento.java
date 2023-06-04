package Modelo;

public class Farmaceutica_medicamento {

	private Medicamento medicamento;
	private Farmaceutica farmaceutica;
	private int stock;

	public Farmaceutica_medicamento(Medicamento medicamento, Farmaceutica farmaceutica, int stock) {
		super();
		this.medicamento = medicamento;
		this.farmaceutica = farmaceutica;
		this.stock = stock;
	}

	public Farmaceutica_medicamento() {
		super();
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Farmaceutica getFarmaceutica() {
		return farmaceutica;
	}

	public void setFarmaceutica(Farmaceutica farmaceutica) {
		this.farmaceutica = farmaceutica;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
