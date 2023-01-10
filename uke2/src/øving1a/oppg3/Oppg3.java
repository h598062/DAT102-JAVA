package øving1a.oppg3;

import java.util.HashSet;
import java.util.Set;

public class Oppg3 {
	public static void main(String[] args) {

		// a
		Set<String> s1 = new HashSet<>();
		Set<String> s2 = new HashSet<>();

		s1.add("fZX8J2y");
		s1.add("c2g1Db67");
		s1.add("WfF");
		s1.add("OY5n");

		s2.add("oPtQ4pz");
		s2.add("6We");
		s2.add("WfF");
		s2.add("OY5n");

		System.out.println("s1:");
		for (String s : s1) {
			System.out.println(s);
		}
		System.out.println("s2:");
		for (String s : s2) {
			System.out.println(s);
		}
		// b
		Set<String> s3 = new HashSet<>(s1);
		s1.retainAll(s2);
		System.out.println(s1);

		// c
		s2.addAll(s3);
		System.out.println(s2);
	}
}
