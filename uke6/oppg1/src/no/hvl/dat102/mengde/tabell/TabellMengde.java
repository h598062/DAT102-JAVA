package no.hvl.dat102.mengde.tabell;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.MengdeADT;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/**
 * ADT-en Mengde implementert som tabell
 *
 * @param <T> Elementtype som skal lagres
 */
public class TabellMengde<T> implements MengdeADT<T> {
	private static final Random tilf = new Random();
	private static final int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.iterator();
		while (teller.hasNext()) {leggTil(teller.next());}
	}

	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom()) {throw new EmptyCollectionException("mengde");}

		int indeks = tilf.nextInt(antall);
		T svar = tab[indeks];
		tab[indeks] = tab[antall - 1];
		tab[antall - 1] = null;
		antall--;

		return svar;
	}

	@Override
	public T fjern(T element) {

		// Søker etter og fjerner element. Returnerer null-ref ved ikke-funn

		if (erTom()) {throw new EmptyCollectionException("mengde");}

		boolean funnet = false;
		T svar = null;
		for (int i = 0; (i < antall && !funnet); i++) {
			if (tab[i].equals(element)) {
				svar = tab[i];
				tab[i] = tab[antall - 1];
				// tab[antall-1] = null;
				antall--;
				funnet = true;

			}
		}
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		for (int i = 0; i < antall && !funnet; i++) {
			if (tab[i].equals(element)) {
				funnet = true;
			}
		}
		return (funnet);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + antall;
		result = prime * result + Arrays.deepHashCode(tab);
		return result;
	}

	@Override
	public boolean equals(Object ny) {
		if (this == ny) {
			return true;
		}
		if (ny == null) {
			return false;
		}
		if (getClass() != ny.getClass()) {
			return false;
		}
		boolean likeMengder = true;
		MengdeADT<T> m2 = (TabellMengde<T>) ny;
		if (this.antall != m2.antall()) {
			likeMengder = false;
		} else {
			Iterator<T> teller = m2.iterator();
			while (teller.hasNext() && likeMengder) {
				T element = teller.next();
				if (!this.inneholder(element)) {
					likeMengder = false;
				}
			}
		}
		return likeMengder;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2
	) { // Denne metoden erstattes med en mer effektiv, se KladdeoppgaveNr3
		TabellMengde<T> begge = new TabellMengde<>();
		for (int i = 0; i < antall; i++) {
			begge.leggTil(tab[i]);
		}
		Iterator<T> teller = m2.iterator();

		while (teller.hasNext()) {
			begge.leggTil(teller.next());
		}
		return (MengdeADT<T>) begge;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new TabellMengde<>();
		T element = null;
		/*
		 * ...Fyll ut senere
		 */
		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new TabellMengde<>();
		T element;
		/*
		 * Fyll ut senere
		 *
		 * if (!m2.inneholder(element)) ((TabellMengde<T>) differensM).settInn(element);
		 */

		return differensM;
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		// ...Fyll ut senere
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new TabellIterator<>(tab, antall);
	}

	/**
	 * Akkurat det samme som leggTil???
	 *
	 * @param element element som skal legges til
	 */
	private void settInn(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}

}
