package no.hvl.dat102;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BS_Tre<T extends Comparable<? super T>> implements SoektreInterface<T> {

	private BinaerTreNode<T> rot;
	// Kunne hatt med
	// private int antall;

	public BS_Tre() {
		rot = null;
	}

	public BS_Tre(T element) {
		rot = new BinaerTreNode<>(element);
	}

	public int finnHoyde() {
		int              sum  = -1;
		BinaerTreNode<T> node = rot;
		if (node == null) {
			return sum;
		}
		sum += finnHoyde(node);
		return sum;
	}

	private int finnHoyde(BinaerTreNode<T> node) {
		if (node == null) {
			return 0;
		}
		int              sum      = 1;
		BinaerTreNode<T> v        = node.getVenstre();
		boolean          fantbarn = false;
		int              vh       = 0;
		int              hh       = 0;
		if (v != null) {
			vh       = finnHoyde(v);
			fantbarn = true;
		}

		BinaerTreNode<T> h = node.getHogre();
		if (h != null) {
			hh       = finnHoyde(h);
			fantbarn = true;
		}
		if (fantbarn) {
			sum += Math.max(vh, hh);
		}

		return sum;
	}

	/**
	 * Søker etter et gitt element i treet.
	 *
	 * @param element elementet vi søker etter.
	 *
	 * @return true om elementet finst, false elles.
	 */
	public boolean inneholder(T element) {
		return false;

		// Kan kalle finn-metoden nedanfor. Prøv sjølv.
	}

	/**
	 * Henter et element i treet.
	 *
	 * @param element elementet vi leiter etter.
	 *
	 * @return Elementet dersom det finst, elles null.
	 */
	public T finn(T element) {

		return finn(element, rot);
	}


	private T finn(T element, BinaerTreNode<T> p) {

		T svar = null;

		// basis: p == null -> tomt undertre, elementet finst ikkje

		if (p != null) {
			int sml = element.compareTo(p.getElement());
			if (sml == 0) {  // basistilfelle
				svar = p.getElement();
			}
			if (sml < 0) {
				svar = finn(element, p.getVenstre());
			} else {
				svar = finn(element, p.getHogre());
			}
		}

		return svar;
	}

	/**
	 * Legg eit element til treet dersom det ikkje finst frå før. Elles
	 * blir det gamle elementet erstatta med det nye.
	 *
	 * @param nyElement elementet som skal leggast til
	 *
	 * @return Elementet som vart erstatta, null om det ikkje finst frå før
	 */
	public T leggTil(T nyElement) {
		T resultat = null;
		if (rot == null) {
			rot = new BinaerTreNode<>(nyElement);
		} else {
			resultat = leggTil(nyElement, rot);
		}
		return resultat;
	}

	private T leggTil(T nyttElement, BinaerTreNode<T> p) {

		// p er ulik null

		T   resultat = null;
		int sml      = nyttElement.compareTo(p.getElement());

		if (sml == 0) {  // elementet finst frå før
			resultat = p.getElement();   // tek vare på gamal verdi
			p.setElement(nyttElement);
		} else if (sml < 0) {
			if (p.getVenstre() != null) {  // p har venstrebarn
				resultat = leggTil(nyttElement, p.getVenstre());
			} else {
				p.setVenstre(new BinaerTreNode<>(nyttElement));
			}
		} else {
			if (p.getHogre() != null) {  // p har høgrebarn
				resultat = leggTil(nyttElement, p.getHogre());
			} else {
				p.setHogre(new BinaerTreNode<>(nyttElement));
			}
		}

		return resultat;
	}

	/**
	 * Fjernar eit element frå treet.
	 *
	 * @param element elementet som skal fjernast.
	 *
	 * @return elementet som vart fjerna eller null om det ikkje finst.
	 */
	public T fjern(T element) {
		// Er ikkje pensum å kunne skrive denne
		// Men de må kunne forklare korleis vi slettar
		// Sjå lyskark

		return null;
	}

	/**
	 * Lagar ein iterator som går gjennom alle element i treet i inorden.
	 *
	 * @return ein iterator som elementa i sortert rekkefølge.
	 */
	public Iterator<T> getInordenIterator() {
		return null;
	}

	public int antallBlad() {
		return antallBladRek(rot);
	}

	private int antallBladRek(BinaerTreNode<T> p) {
		if (p == null) {
			return 0;
		}
		int blad = 0;
		blad += antallBladRek(p.getVenstre());
		blad += antallBladRek(p.getHogre());
		if (blad == 0) {
			// denne er et blad
			blad++;
		}
		return blad;
	}

	private void skrivUtMedLinjer(BinaerTreNode<T> node, String prefiks, boolean erSiste) {
		if (node == null) {
			return;
		}

		System.out.print(prefiks);
		System.out.print(erSiste ? "└── " : "├── ");
		System.out.println(node.getElement());

		String nyttPrefiks = prefiks + (erSiste ? "    " : "│   ");

		skrivUtMedLinjer(node.getVenstre(), nyttPrefiks, node.getHogre() == null);
		skrivUtMedLinjer(node.getHogre(), nyttPrefiks, true);
	}

	public void skrivUtMedLinjer() {
		skrivUtMedLinjer(rot, "", true);
	}

	public int hoyde() {
		int resultat = -1;

		resultat = hoydeRek(rot);

		return resultat;
	}

	private int hoydeRek(BinaerTreNode<T> p) {
		BinaerTreNode<T> vb = p.getVenstre();
		BinaerTreNode<T> hb = p.getHogre();
		int              vh = 0;
		int              hh = 0;
		if (vb != null) {
			vh++;
			vh += hoydeRek(vb);
		}
		if (hb != null) {
			hh++;
			hh += hoydeRek(hb);
		}
		return Math.max(vh, hh);
	}

	public int hoydeCBT() {
		return hoydeRekCBT(rot);
	}

	private int hoydeRekCBT(BinaerTreNode<T> p) {
		if (p == null) {
			// Høyden til et tomt tre er -1
			return -1;
		} else {
			// Finner høyden til venstre og høyre undertrær
			int hoydeVenstre = hoydeRek(p.getVenstre());
			int hoydeHoyre   = hoydeRek(p.getHogre());

			// Returnerer den største høyden, pluss 1 for å inkludere rotnoden
			return Math.max(hoydeVenstre, hoydeHoyre) + 1;
		}
	}

	public int hoydeFasit() {
		return hoydeRekFasit(rot);
	}

	private int hoydeRekFasit(BinaerTreNode<T> p) {
		int resultat = -1;
		if (p != null) {
			int venstreHoyde = hoydeRek(p.getVenstre());
			int hoyreHoyde   = hoydeRek(p.getHogre());
			if (venstreHoyde > hoyreHoyde) {
				resultat = 1 + venstreHoyde;
			} else {
				resultat = 1 + hoyreHoyde;
			}
			// alt: resultat = Math.max(venstreHoyde, hoyreHoyde) + 1;
		}
		return resultat;
	}

}
