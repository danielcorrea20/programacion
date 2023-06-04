package Hoja9;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import fecha1.fecha1;

public class Aula {

	private ArrayList<Persona> alumnos;

	public Aula(ArrayList<Persona> alumnos) {
		super();
		this.alumnos = alumnos;
	}

	public Aula() {
		super();
	}

	public ArrayList<Persona> getLista() {
		return alumnos;
	}

	public void setLista(ArrayList<Persona> alumnos) {
		this.alumnos = alumnos;
	}

	@Override
	public String toString() {
		return "Aula [alumnos=" + alumnos + "]";
	}

	public ArrayList<Persona> anadir(ArrayList<Persona> alumnos, Persona persona) {

		alumnos.add(persona);
		return alumnos;

	}

	public void mostrar(ArrayList<Persona> alumnos) {

		for (Persona persona : alumnos) {
			System.out.println(persona);
		}

	}

	public ArrayList<Persona> nacidosMes(int mes, ArrayList<String> alumnos) {
		ArrayList<Persona> cumpleMes = new ArrayList<Persona>();

		for (String persona : alumnos) {

			String[] cadenas = persona.split(" ");

			LocalDate fecha = Fecha.transformadorFecha(cadenas[1]);

			if (fecha.getMonthValue() == mes) {
				Persona persona2 = new Persona();
				persona2.setNombre(cadenas[0]);
				persona2.setFecha(fecha);
				persona2.setCurso(cadenas[2]);
				cumpleMes.add(persona2);
			}

		}
		return cumpleMes;
	}

	public void mayorMenor(ArrayList<String> alumnos) {

		LocalDate mayor;
		LocalDate menor;
		String mayorPersona;
		String menorPersona;

		String primero = alumnos.get(0);
		String[] primeroCortado = primero.split(" ");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaPrimero = LocalDate.parse(primeroCortado[1], formatter);
		mayor = fechaPrimero;
		menor = fechaPrimero;
		mayorPersona = primeroCortado[0];
		menorPersona = primeroCortado[0];

		for (String persona : alumnos) {
			String[] cadenas = persona.split(" ");
			LocalDate fecha = LocalDate.parse(cadenas[1], formatter);
			if (fecha.isAfter(menor)) {
				menor = fecha;
				menorPersona = cadenas[0];
			}

			if (fecha.isBefore(mayor)) {
				mayor = fecha;
				mayorPersona = cadenas[0];
			}
		}

		System.out.println("El mayor es " + mayorPersona);
		System.out.println("El menor es " + menorPersona);

	}

	public void edad1825(ArrayList<String> alumnos) {

		LocalDate fechaInicio = LocalDate.now().minusYears(25);
		LocalDate fechaFinal = LocalDate.now().minusYears(18);

		ArrayList<String> periodo = new ArrayList<String>();

		for (String persona : alumnos) {
			String[] cadenas = persona.split(" ");

			LocalDate fecha = Fecha.transformadorFecha(cadenas[1]);

			if (fecha.isAfter(fechaInicio) && fecha.isBefore(fechaFinal)) {
				periodo.add(cadenas[0]);
			}
		}
		System.out.println("Los alumnos comprendidos entre 18 y 25 años son " + periodo);

	}

	public void horoscopo(ArrayList<String> alumnos) {

		// cronounit

		LocalDate fecha = LocalDate.of(2000, 1, 1);
		LocalDate InicioCapricornio = fecha.minusDays(8);
		LocalDate finalCapricornio = fecha.plusDays(20);
		LocalDate inicioAcuario = fecha.plusDays(21);// +29
		LocalDate finalAcuario = fecha.plusDays(50);
		LocalDate inicioPiscis = fecha.plusDays(51);// +28
		LocalDate finalPiscis = fecha.plusDays(79);
		LocalDate inicioAries = fecha.plusDays(80);// +29
		LocalDate finalAries = fecha.plusDays(109);
		LocalDate inicioTauro = fecha.plusDays(110);// 31
		LocalDate finaTauro = fecha.plusDays(140);
		LocalDate inicioGeminis = fecha.plusDays(141);// +30
		LocalDate finaGeminis = fecha.plusDays(171);
		LocalDate inicioCancer = fecha.plusDays(172);
		LocalDate finaCancer = fecha.plusDays(202);
		LocalDate inicioLeo = fecha.plusDays(203);
		LocalDate finaLeo = fecha.plusDays(236);
		LocalDate inicioVirgo = fecha.plusDays(237);
		LocalDate finaVirgo = fecha.plusDays(267);
		LocalDate inicioLibra = fecha.plusDays(268);
		LocalDate finaLibra = fecha.plusDays(298);
		LocalDate inicioEscorpio = fecha.plusDays(299);
		LocalDate finaEscorpio = fecha.plusDays(329);
		LocalDate inicioSagitario = fecha.plusDays(330);
		LocalDate finaSagitario = fecha.plusDays(360);

		ArrayList<String> tuHoroscopoCapricornio = new ArrayList<String>();
		ArrayList<String> tuHoroscopoAcuario = new ArrayList<String>();
		ArrayList<String> tuHoroscopoPiscis = new ArrayList<String>();
		ArrayList<String> tuHoroscopoAries = new ArrayList<String>();
		ArrayList<String> tuHoroscopoTauro = new ArrayList<String>();
		ArrayList<String> tuHoroscopoGeminis = new ArrayList<String>();
		ArrayList<String> tuHoroscopoCancer = new ArrayList<String>();
		ArrayList<String> tuHoroscopoLeo = new ArrayList<String>();
		ArrayList<String> tuHoroscopoVirgo = new ArrayList<String>();
		ArrayList<String> tuHoroscopoLibra = new ArrayList<String>();
		ArrayList<String> tuHoroscopoEscorpio = new ArrayList<String>();
		ArrayList<String> tuHoroscopoSagitario = new ArrayList<String>();

		for (String persona : alumnos) {

			String[] cadenas = persona.split(" ");

			LocalDate fecha1 = Fecha.transformadorFecha(cadenas[1]);
			LocalDate fechaModificada = LocalDate.of(2000, fecha1.getMonthValue(), fecha.getDayOfMonth());

			// esta bien pero no entra por el año. Habria que eliminar el año para la
			// comparacion

			if (fechaModificada.isAfter(InicioCapricornio) && fechaModificada.isBefore(finalCapricornio)) {
				tuHoroscopoCapricornio.add(cadenas[0]);
			}
			if (fechaModificada.isAfter(inicioAcuario) && fechaModificada.isBefore(finalAcuario)) {
				tuHoroscopoAcuario.add(cadenas[0]);
			}
			if (fechaModificada.isAfter(inicioPiscis) && fechaModificada.isBefore(finalPiscis)) {
				tuHoroscopoPiscis.add(cadenas[0]);
			}
			if (fechaModificada.isAfter(inicioAries) && fechaModificada.isBefore(finalAries)) {
				tuHoroscopoAries.add(cadenas[0]);
			}
			if (fechaModificada.isAfter(inicioTauro) && fechaModificada.isBefore(finaTauro)) {
				tuHoroscopoTauro.add(cadenas[0]);
			}
			if (fechaModificada.isAfter(inicioGeminis) && fechaModificada.isBefore(finaGeminis)) {
				tuHoroscopoGeminis.add(cadenas[0]);
			}
			if (fechaModificada.isAfter(inicioCancer) && fechaModificada.isBefore(finaCancer)) {
				tuHoroscopoCancer.add(cadenas[0]);
			}
			if (fechaModificada.isAfter(inicioLeo) && fechaModificada.isBefore(finaLeo)) {
				tuHoroscopoLeo.add(cadenas[0]);
			}
			if (fechaModificada.isAfter(inicioVirgo) && fechaModificada.isBefore(finaVirgo)) {
				tuHoroscopoVirgo.add(cadenas[0]);
			}
			if (fechaModificada.isAfter(inicioLibra) && fechaModificada.isBefore(finaLibra)) {
				tuHoroscopoLibra.add(cadenas[0]);
			}
			if (fechaModificada.isAfter(inicioEscorpio) && fechaModificada.isBefore(finaEscorpio)) {
				tuHoroscopoEscorpio.add(cadenas[0]);
			}
			if (fechaModificada.isAfter(inicioSagitario) && fechaModificada.isBefore(finaSagitario)) {
				tuHoroscopoSagitario.add(cadenas[0]);
			}

		}
		System.out.println("Los alumnos con zodíaco capricornio son  " + tuHoroscopoCapricornio);
		System.out.println("Los alumnos con zodíaco acuario son  " + tuHoroscopoAcuario);
		System.out.println("Los alumnos con zodíaco piscis son  " + tuHoroscopoCapricornio);
		System.out.println("Los alumnos con zodíaco aries son  " + tuHoroscopoAries);
		System.out.println("Los alumnos con zodíaco tauro son  " + tuHoroscopoTauro);
		System.out.println("Los alumnos con zodíaco geminis son  " + tuHoroscopoGeminis);
		System.out.println("Los alumnos con zodíaco cáncer son  " + tuHoroscopoCancer);
		System.out.println("Los alumnos con zodíaco leo son  " + tuHoroscopoLeo);
		System.out.println("Los alumnos con zodíaco virgo son  " + tuHoroscopoVirgo);
		System.out.println("Los alumnos con zodíaco libra son  " + tuHoroscopoLibra);
		System.out.println("Los alumnos con zodíaco escorpio son  " + tuHoroscopoEscorpio);
		System.out.println("Los alumnos con zodíaco sagitario son  " + tuHoroscopoSagitario);

	}

	public void edadMedia(ArrayList<String> alumnos) {

		float edadMedia = 0;
		int total = 0;
		int edad;
		LocalDate hoy = LocalDate.now();

		for (String persona : alumnos) {
			String[] cadenas = persona.split(" ");

			LocalDate fecha = Fecha.transformadorFecha(cadenas[1]);

			// calcular la edad de cada alumno
			// como llego a la fecha de nacimiento???

			edad = (int) ChronoUnit.YEARS.between(fecha, hoy);
			total = total + edad;

		}
		edadMedia = total / alumnos.size();
		System.out.println("La edad media es " + edadMedia);

	}

	public void orden(ArrayList<String> alumnos) {

		int edad;
		LocalDate hoy = LocalDate.now();

		for (String persona : alumnos) {
			String[] cadenas = persona.split(" ");
			LocalDate fechaPrimero = Fecha.transformadorFecha(cadenas[1]);

		}
		Collections.sort(alumnos);

		System.out.print(alumnos);
	}

}
