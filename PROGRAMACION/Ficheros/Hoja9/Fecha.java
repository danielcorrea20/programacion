package Hoja9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Fecha {

	public static LocalDate transformadorFecha(String fecha) {

		// PASAR DE STRING A LOCALDATE

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		return LocalDate.parse(fecha, formatter);
	}

}
