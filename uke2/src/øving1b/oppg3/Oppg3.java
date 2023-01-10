package øving1b.oppg3;

import java.util.ArrayList;
import java.util.List;

public class Oppg3 {
	public static void main(String[] args) {
		List<Figur> liste = new ArrayList<>();
		liste.add(new Trekant(3));
		liste.add(new Trekant(4));
		liste.add(new Trekant(5));
		liste.add(new Rektangel(2, 4));
		liste.add(new Rektangel(3, 6));
		liste.add(new Rektangel(5, 3));
		double areal = 0;
		for (Figur f : liste) {
			areal += f.areal();
			f.tegn();
			System.out.println();
		}
		System.out.println("Samlet areal: " + areal);
	}
}
