package øving1b.oppg2;

import øving1b.oppg1.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Oppg2 {
	public static void main(String[] args) {
		List<NettStudent> liste = new ArrayList<>();
		liste.add(new NettStudent(950, "Alf", "Alfesen", "Bergen", "Bergen"));
		liste.add(new NettStudent(461, "Per", "Glovfds", "Bergen", "Bergen"));
		liste.add(new NettStudent(816, "Pål", "Greptg", "Førde", "Førde"));
		liste.add(new NettStudent(538, "Jon", "irdewtf", "Førde", "Førde"));
		liste.add(new NettStudent(430, "Gard", "Alfesen", "Bergen", "Oslo"));

		Set<String> hjemsteder = new HashSet<>();
		for (NettStudent ns : liste) {
			hjemsteder.add(ns.getHjemsted());
		}
		System.out.println(hjemsteder);

		// ja, kan legge til nettstudent i student liste
		List<Student> sl = new ArrayList<>();
		sl.add(liste.get(0));
		// nei, kan ikke legge til student i nettstudent liste
		//liste.add(new Student(1, "d", "s", "s"));
	}
}
