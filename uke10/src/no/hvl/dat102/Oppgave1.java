package no.hvl.dat102;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Oppgave1 {

	/**
	 * Sortering ved innsetting (Insertion sort)
	 */
	public static <T extends Comparable<? super T>> void sorteringVedInssetting(T[] a, int n) {
		sorteringVedInssetting(a, 0, n - 1);
	}

	public static <T extends Comparable<? super T>> void sorteringMedSnarvei(T[] a, int n) {

		int pos   = n - 1;
		T   minst = a[n - 1];
		for (int i = n - 1; i > 0; i--) {
			T elem = a[i];
			if (elem.compareTo(a[i - 1]) < 0) {
				minst = elem;
				pos   = i;
			}
		}
		a[pos] = a[0];
		a[0]   = minst;

		sorteringVedInssetting(a, 0, n - 1);
	}

	/**
	 * Sorterer ein del av tabellen, start ... slutt (begge grensene er med)
	 */
	public static <T extends Comparable<? super T>> void sorteringVedInssetting(T[] a, int start, int slutt) {
		for (int i = start + 1; i <= slutt; i++) {
			T       tmp    = a[i];
			int     j      = i - 1;  // siste i sortert del
			boolean ferdig = false;

			while (!ferdig && j >= 0) {
				if (tmp.compareTo(a[j]) < 0) {
					a[j + 1] = a[j];
					j--;
				} else {
					ferdig = true;
				}
			}

			a[j + 1] = tmp;
		}
	}

	public static void main(String[] args) {
		int  gjIterasjoner = 5;
		long totalTid1     = 0;
		int  antallnumre   = 50000;
		int[] randomseeds = {12345, 67890, 13579, 24680, 69420};
		for (int i = 0; i < gjIterasjoner; i++) {
			Integer[] tabell    = new Integer[antallnumre];
			Random    tilfeldig = new Random(randomseeds[i]);

			for (int j = 0; j < antallnumre; j++) {
				tabell[j] = tilfeldig.nextInt();
			}
			Instant start = Instant.now();

			sorteringVedInssetting(tabell, tabell.length);
			Instant finish = Instant.now();
			long tid = Duration.between(start, finish)
			                   .toMillis();
			totalTid1 += tid;
			System.out.println("Iterasjon " + i + ": " + tid);
		}
		long gjennomsnitt1 = totalTid1 / gjIterasjoner;
		System.out.println("Gjennomsnitt 1: " + gjennomsnitt1);

		long totalTid2 = 0;
		for (int i = 0; i < gjIterasjoner; i++) {
			Integer[] tabell    = new Integer[antallnumre];
			Random    tilfeldig = new Random(randomseeds[i]);

			for (int j = 0; j < antallnumre; j++) {
				tabell[j] = tilfeldig.nextInt();
			}
			Instant start = Instant.now();

			sorteringMedSnarvei(tabell, tabell.length);
			Instant finish = Instant.now();
			long tid = Duration.between(start, finish)
			                   .toMillis();
			totalTid2 += tid;
			System.out.println("Iterasjon " + i + ": " + tid);
		}
		long gjennomsnitt2 = totalTid2 / gjIterasjoner;
		System.out.println("Gjennomsnitt 2: " + gjennomsnitt2);
		System.out.println("Gjennomsnitt 1: " + gjennomsnitt1);
		// vi har observert at metoden med å finne minst og sette den på posisjon 0 er raskere enn den vanlige metoden
	}
}
