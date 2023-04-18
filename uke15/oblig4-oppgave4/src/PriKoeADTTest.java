import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PriKoeADTTest {
	// Referanse til kø (prioritetskø)
	private              PriKoeADT<Integer> koe;
	// Standardkapasitet
	private static final int                STDK = 5;
	// Testdata
	private final        Integer            e0   = 1;
	private final        Integer            e1   = 2;
	private final        Integer            e2   = 3;
	private final        Integer            e3   = 4;
	private final        Integer            e4   = 5;

	/**
	 * Hent en ny kø for hver test.
	 */
	@BeforeEach
	public void setup() {
		koe = new PriKoe<Integer>(STDK);
	}

	@Test
	public void nyKoeErTom() {
		assertTrue(koe.erTom());
	}

	@Test
	public void settInnFjerneErTom() {
		try {
			koe.settInn(e0);
			koe.fjern();
			assertTrue(koe.erTom());
		} catch (EmptyCollectionException e) {
			fail("utkoe feilet uventet " + e.getMessage());
		}
	}

	// Test på settInn and fjern.
	@Test
	public void setteInnOgFjerne() {
		koe.settInn(5);
		koe.settInn(4);
		koe.settInn(2);
		koe.settInn(7);
		assertEquals(2, koe.fjern());
		assertEquals(4, koe.fjern());
		assertEquals(5, koe.fjern());
		assertEquals(7, koe.fjern());
	}

	@Test
	public void fjernFromEmptyIsUnderflowed() {
		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			koe.fjern();
		});
	}
}// class