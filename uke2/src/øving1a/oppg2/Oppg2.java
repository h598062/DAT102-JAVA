package øving1a.oppg2;

import java.util.ArrayList;
import java.util.List;

public class Oppg2 {
	public static void main(String[] args) {
		List<Integer> heltallListe = new ArrayList<>();
		heltallListe.add(3);
		heltallListe.add(3);
		heltallListe.add(4);
		heltallListe.add(5);
		heltallListe.add(1);

		System.out.println("pos 4: " + heltallListe.get(3));
		System.out.println("pos 5: " + heltallListe.get(4));
		System.out.println("antall elementer: " + heltallListe.size());

		System.out.println(heltallListe);
		heltallListe.add(2, 6);
		System.out.println(heltallListe);
	}
}
