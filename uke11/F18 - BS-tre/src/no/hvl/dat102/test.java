package no.hvl.dat102;

import java.util.Random;

public class test {
	public static void main(String[] args) {
		BS_Tre<Integer> tre = new BS_Tre<>();
		Random          r   = new Random(69);
		for (int i = 0; i < 10; i++) {
			Integer x = r.nextInt(99);
			tre.leggTil(x);
			System.out.print(x + " ");
		}
		System.out.println();
		tre.skrivUtMedLinjer();
		System.out.println("blad: " + tre.antallBlad());
	}
}
