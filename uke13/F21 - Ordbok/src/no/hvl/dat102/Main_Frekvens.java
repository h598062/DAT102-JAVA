package no.hvl.dat102;

import java.util.Iterator;

public class Main_Frekvens {
	public static void main(String[] args) {
		String[] ord = {"er", "det", "finn", "er", "finn", "er"};
		
		// Lag ordbok
		OrdbokInterface<String, Integer> frekvenser = new Ordbok<>();
		
		// Tell opp
		for (String s : ord) {
			if (frekvenser.inneholder(s)) {
				int f = frekvenser.getVerdi(s);
				frekvenser.leggTil(s, f + 1);
			} else {
				frekvenser.leggTil(s, 1);
			}
		}
		
		// Skriv ut frekvensoversikt
		Iterator<String> ordit = frekvenser.getNokkelIterator();
		Iterator<Integer> frekvensit = frekvenser.getVerdiIterator();
		
		while (ordit.hasNext()) {
			System.out.println(ordit.next() + ": " + frekvensit.next());
		}
		
	}

}
