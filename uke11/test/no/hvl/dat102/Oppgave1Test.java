package no.hvl.dat102;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Oppgave1Test {

	@Test
	void testLinearSoekMotEttTall() {
		boolean result = Oppgave1.linearSoek(new int[]{0}, 0);
		Assertions.assertTrue(result);
	}

	@Test
	void testBinaerSoekMotEttTall() {
		boolean result = Oppgave1.binearSoek(new int[]{0}, 0);
		Assertions.assertTrue(result);
	}

	@Test
	void testLinearSoekMotUordnetTabell() {
		int[] a = {324, 436, 3, 547, 382, 294, 4357, 234, 342};
		Assertions.assertTrue(Oppgave1.linearSoek(a, 3));
		Assertions.assertFalse(Oppgave1.linearSoek(a, 5));
	}

	@Test
	void testLinearSoekMotOrdnetTabell() {
		int[] a = {1, 2, 3, 4, 8, 9, 20, 34, 200};
		Assertions.assertTrue(Oppgave1.linearSoek(a, 3));
		Assertions.assertFalse(Oppgave1.linearSoek(a, 5));
	}

	@Test
	void testBinearSoekMotOrdnetTabell() {
		int[] a = {1, 2, 3, 4, 8, 9, 20, 34, 200};
		Assertions.assertTrue(Oppgave1.binearSoek(a, 3));
		Assertions.assertFalse(Oppgave1.binearSoek(a, 5));
	}

	@Test
	void testBinearSoekMotOrdnetTabellPartallOgOddetallLengde() {
		int[] a = {1, 2, 3, 4, 8, 9, 20, 34, 200};
		int[] b = {1, 2, 3, 4, 8, 9, 20, 34};
		Assertions.assertTrue(Oppgave1.binearSoek(a, 3));
		Assertions.assertTrue(Oppgave1.binearSoek(b, 3));
	}

	@Test
	void testLinearSoekMotNullpeker() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Oppgave1.linearSoek(null, 3);
		});
	}

	@Test
	void testBinearSoekMotNullpeker() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Oppgave1.binearSoek(null, 3);
		});
	}
}