package no.hvl.dat102;

public class Main {

	static int maks(int[] tab, int start, int slutt) { // Parametre?
		if (start == slutt) {
			return tab[start];
		}

		int midten = (start + slutt) / 2;
		int mV     = maks(tab, start, midten);
		int mH     = maks(tab, midten + 1, slutt);

		return mV >= mH ? mV : mH;

		/*
		 * Alternativ if (mV >= mH) {
		 *   return mV;
		 * } else {
		 *   return mH; }
		 */
	}

	static int sum(LinearNode<Integer> p) { // Parametre?
		if (p == null) { // basistilfelle
			return 0;
		}

		int sumResten = sum(p.getNeste());

		return sumResten + p.getElement();

		// kunne kombinert alle dei tre siste setningane til ein
	}

	static int fakultet(int n) { // Paremeter?
		if (n == 1) { // basis
			return 1;
		}

		return n * fakultet(n - 1);

		/*
		 * alt int resten = fakultet(n-1); return n * resten;
		 */
	}

	static int sum1tilN(int n) { // Parameter
		if (n == 1) {  // basis
			return 1;
		}

		int sumResten = sum1tilN(n - 1);

		return n + sumResten;
	}

	public static void main(String[] args) {

		int[] tab = {17, 1, 5, 2, 10, -1, 8, 2, 16};

		// Bruke maks
		System.out.println(maks(tab, 0, tab.length - 1));

		LinearNode<Integer> a     = new LinearNode<>(1);
		LinearNode<Integer> b     = new LinearNode<>(2);
		LinearNode<Integer> c     = new LinearNode<>(3);
		LinearNode<Integer> start = a;

		a.setNeste(b);
		b.setNeste(c);

		// Bruke sum
		System.out.println(sum(start));

		// Bruke fakultet for å finne 4!
		System.out.println(fakultet(4));

		// Sum 1 + ... + n
		System.out.println(sum1tilN(4));

	}

}
