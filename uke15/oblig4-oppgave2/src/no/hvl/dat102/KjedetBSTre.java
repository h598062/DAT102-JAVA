package no.hvl.dat102;

public class KjedetBSTre<T extends Comparable<T>> /* implements BSTreADT<T> */ {
	private int              antall;
	private BinaerTreNode<T> rot;

	public KjedetBSTre() {
		antall = 0;
		rot    = null;
	}

	//..andre metoder
	public void visPostorden() {
		visRekPostorden(rot);
		System.out.println();
	}

	private void visRekPostorden(BinaerTreNode<T> p) {
		visRekPostorden(p.getVenstre());
		visRekPostorden(p.getHoyre());
		System.out.println(p);
	}

	public T finn(T element) {
		return finnRek(element, rot);
	}

	private T finnRek(T element, BinaerTreNode<T> p) {
		if (element == null || p == null) {
			return null;
		}
		if (element.equals(p.getElement())) {
			return p.getElement();
		}

		if (element.compareTo(p.getElement()) < 1) {
			return finnRek(element, p.getVenstre());
		} else {
			return finnRek(element, p.getHoyre());
		}
	}

	public boolean erIdentisk(KjedetBSTre<T> t) {
		return erIdentiskRek(rot, t.rot);
	}

	private boolean erIdentiskRek(BinaerTreNode<T> t1, BinaerTreNode<T> t2) {
		if (t1 == null && t2 == null) {
			return true;
		}
		if (t1 == null || t2 == null) {
			return false;
		}
		if (t1.getElement() == null && t2.getElement() == null) {
			return true;
		}
		if (t1.getElement() == null || t2.getElement() == null) {
			return false;
		}

		if (!t1.getElement()
		       .equals(t2.getElement())) {
			return false;
		}
		return erIdentiskRek(t1.getVenstre(), t2.getVenstre()) && erIdentiskRek(t1.getHoyre(), t2.getHoyre());
	}
}
