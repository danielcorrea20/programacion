package Hoja9;
 

import java.security.KeyStore.TrustedCertificateEntry;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Persona{

	private String nombre;
	private LocalDate fecha;
	private String curso;

	public Persona(String nombre, LocalDate fecha, String curso) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.curso = curso;
	}

	public Persona() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return nombre + " " + fecha + " " + curso;
	}

	public static String[] split(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFecha(String next) {
		// TODO Auto-generated method stub

	}



}
