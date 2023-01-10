package øving1a.oppg4;

import java.util.*;

public class Oppg4 {
	public static void main(String[] args) {

		// a
		List<String>         liste    = new ArrayList<>(List.of("er", "det", "alle", "er", "det", "det"));
		Map<String, Integer> frekvens = new HashMap<>();
		for (String s : liste) {
			frekvens.put(s, frekvens.getOrDefault(s, 0) + 1);
		}
		System.out.println(liste);
		System.out.println(frekvens);

		// b
		Scanner scanner = new Scanner(System.in);
		System.out.print("Skriv inn en tekststreng for å sjekke frekvens: ");
		String  input   = scanner.nextLine();
		Integer i       = frekvens.get(input);
		System.out.println(i != null ? i : 0);
	}
}
