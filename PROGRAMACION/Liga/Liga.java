import java.util.ArrayList;
import java.util.Scanner;

public class Liga {

	private ArrayList<Equipo> JapanLeague = new ArrayList<Equipo>();

	public Liga() {
		super();
	}

	public ArrayList<Equipo> getJapanLeague() {
		return JapanLeague;
	}

	public void setJapanLeague(ArrayList<Equipo> japanLeague) {
		JapanLeague = japanLeague;
	}

	@Override
	public String toString() {
		return "Liga [JapanLeague=" + JapanLeague + "]";
	}

	public void addEquipos(Equipo item) {

		JapanLeague.add(item);
	}

	public static class Partido {
		public int local = -1;
		public int visitante = -1;

	}

	public void jornada(int numEquipos) {

		int numRondas;
		int numPartidosPorRonda;
		int equipoMasAlto;
		int equipoImparMasAlto;
		boolean esImpar = false;
		int descanso;

		// Scanner lector = new Scanner(System.in);

		// System.out.println("¿Cuantos equipos habrá en la liga?");
		// numEquipos = lector.nextInt();
		// lector.nextLine();

		/*
		if (Math.floorMod(numEquipos, 2) == 1) {
			numEquipos++;
			esImpar = true;
		}
		*/

		numRondas = numEquipos - 1;
		numPartidosPorRonda = numEquipos / 2;

		Partido[][] rondas = new Partido[numRondas][numPartidosPorRonda];

		for (int i = 0, k = 0; i < numRondas; i++) {
			for (int j = 0; j < numPartidosPorRonda; j++) {
				rondas[i][j] = new Partido();
				rondas[i][j].local = k;
				k++;
				if (k == numRondas)
					k = 0;
			}
		}

		for (int i = 0; i < numRondas; i++) {
			if (i % 2 == 0) {
				rondas[i][0].visitante = numEquipos - 1;
			} else {
				rondas[i][0].visitante = rondas[i][0].local;
				rondas[i][0].local = numEquipos - 1;
			}
		}

		equipoMasAlto = numEquipos - 1;
		equipoImparMasAlto = equipoMasAlto - 1;

		for (int i = 0, k = equipoImparMasAlto; i < numRondas; i++) {
			for (int j = 1; j < numPartidosPorRonda; j++) {
				rondas[i][j].visitante = k;
				k--;
				if (k == -1)
					k = equipoImparMasAlto;
			}
		}

		System.out.println("----");

		for (int i = 0; i < rondas.length; i++) {
			System.out.print("Ronda " + (i + 1) + ": ");

			for (int j = 0; j < rondas[i].length; j++) {
				if (esImpar && (1 + rondas[i][j].local == numEquipos || 1 + rondas[i][j].visitante == numEquipos)) {
					if (1 + rondas[i][j].local == numEquipos) {
						descanso = 1 + rondas[i][j].visitante;
					} else {
						descanso = 1 + rondas[i][j].local;
					}
					System.out.print(" Descanso: " + descanso);

				} else {
					System.out.print("   " + (1 + rondas[i][j].local) + "-" + (1 + rondas[i][j].visitante));

				}
			}

			System.out.println();
		}

		// lector.close();

	}

}
