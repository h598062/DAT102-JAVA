package no.hvl.dat102;

/*******************************************************************/
public class BinaerTreNode<T> {
	private T                element;
	private BinaerTreNode<T> venstre, hoyre;

	/*****************************************************************
	 Oppretter et nytt tre med spesifisert data.
	 *****************************************************************/
	BinaerTreNode(T el) {
		element = el;
		venstre = null;
		hoyre   = null;
	}
	/******************************************************************/
	// get- og setmetoder

	/******************************************************************/
	public BinaerTreNode<T> getVenstre() {
		return venstre;
	}

	public BinaerTreNode<T> getHoyre() {
		return hoyre;
	}

	public void setVenstre(BinaerTreNode<T> ny) {
		venstre = ny;
	}

	public void setHoyre(BinaerTreNode<T> ny) {
		hoyre = ny;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T el) {
		element = el;
	}
}// class
