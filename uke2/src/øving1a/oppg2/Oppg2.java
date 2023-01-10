package øving1a.oppg2;

import java.util.ArrayList;
import java.util.List;

public class Oppg2 {
	public static void main(String[] args) {
		// a
		List<Integer> heltallListe = new ArrayList<>();
		heltallListe.add(3);
		heltallListe.add(4);
		heltallListe.add(5);
		heltallListe.add(3);
		heltallListe.add(1);
		System.out.println("pos 4: " + heltallListe.get(3));
		System.out.println("pos 5: " + heltallListe.get(4));

		// b
		System.out.println("antall elementer: " + heltallListe.size());
		System.out.println(heltallListe);
		heltallListe.add(2, 6);
		System.out.println(heltallListe);

		// c
		if (heltallListe.contains(3)) {
			System.out.println("Fant 3");
		} else {
			System.out.println("Fant ikke 3");
		}
		if (heltallListe.contains(7)) {
			System.out.println("Fant 7");
		} else {
			System.out.println("Fant ikke 7");
		}

		// d
		System.out.println("Første posisjon med 3: " + heltallListe.indexOf(3));
		System.out.println("Siste posisjon med 3: " + heltallListe.lastIndexOf(3));

		// e
		System.out.println(heltallListe);
		heltallListe.clear();
		System.out.println(heltallListe);
	}
}
