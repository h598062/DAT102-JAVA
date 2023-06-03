package no.hvl.dat102;

import java.util.Random;

public class test {
	public static void main(String[] args) {
		var tre = new BS_Tre<Integer>();
		var          r   = new Random(69);
		for (var i = 0; i < 10; i++) {
			Integer x = r.nextInt(99);
			tre.leggTil(x);
			System.out.print(x + " ");
		}
		System.out.println();
		tre.skrivUtMedLinjer();
		System.out.println("blad: " + tre.antallBlad());

		System.out.println("høyde: " + tre.hoyde());
		System.out.println("høydeCBT: " + tre.hoydeCBT());
		System.out.println("høydeFasit: " + tre.hoydeFasit());
	}
}
