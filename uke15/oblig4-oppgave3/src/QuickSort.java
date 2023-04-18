public class QuickSort {
	// ingen spørsmål knyttet til denne metoden
	public static <T extends Comparable<T>> void quickSort(T[] data) {
		quickSort(data, 0, data.length - 1);
	}

	private static <T extends Comparable<T>> void quickSort(T[] data, int min, int maks) {
		if (min < maks) { // sjekk at vi ikke er ferdig med å sortere
			int midindeks = partition(data, min, maks); // få den nye midt posisjonen
			quickSort(data, min, midindeks-1); // sorter venstre halvdel
			quickSort(data, midindeks, maks); // sorter høyre halvdel
		}
	}

	private static <T extends Comparable<T>> int partition(T[] data, int min, int maks) {
		// metoden skal bare forklares
		/*
		Denne metoden skal ta inn en tabell, en minimum indeks og maks indeks,
		og deretter sortere den biten.
		Først må vi finne en "pivot" verdi, en verdi vi skal sammenligne med.
		Dette blir vanligvis siste element i den oppgitte delen av tabellen, altså element på maks indeks.
		Så itererer vi gjennom alle elementer og plasserer alle som er mindre til venstre for pivot,
		og alle elementer som er større til høyre, deretter returnerer indeks til pivot elementet.
		 */
		return 0; // for å fjerne feilmelding ved skriving
	}
}
