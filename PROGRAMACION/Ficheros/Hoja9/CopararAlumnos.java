package Hoja9;

import java.util.Comparator;

public class CopararAlumnos implements Comparator<Persona> {

	@Override
	public int compare(Persona e1, Persona e2) {
		if (e1.getFecha().isAfter(e2.getFecha())) {
			return -1;
		} else if (e1.getFecha().isAfter(e2.getFecha())) {
			return 0;

		} else {
			return 1;
		}

	}

}
