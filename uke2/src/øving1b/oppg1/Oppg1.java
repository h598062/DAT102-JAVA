package øving1b.oppg1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Oppg1 {
	public static void main(String[] args) {
		List<Student> liste = new ArrayList<>();
		liste.add(new Student(9068, "bloaerthb", "bntrs", "thsr"));
		liste.add(new Student(5463, "ahdgf", "aerh", "ztxd"));
		liste.add(new Student(1234, "blob", "bar", "bye"));
		liste.add(new Student(5624, "aetrjh", "aehjtr", "byzdthe"));
		liste.add(new Student(5487, "jtare", "sgfd", "hrdst"));

		System.out.println(liste);
		Collections.sort(liste);
		System.out.println(liste);
	}
}
