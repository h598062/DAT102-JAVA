public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int           antall;
	private LinearNode<T> første;

	// Konstruktør
	public KjedetOrdnetListe() {
		antall = 0;
		første = null;
	}

	//… get- og set-metoder som kan du anta hvis nødvendig
	// Andre metoder
	public boolean inneholder(T element) {
		LinearNode node = første;
		while (node != null) {
			if (node.getElement()
			        .equals(element)) {
				return true;
			}
			node = node.getNeste();
		}
		return false;
	}

	public void settInn(T element) {
		LinearNode node = første;
		if (node.getElement()
		        .compareTo(element) < 1) {
			LinearNode ny = new LinearNode(element);
			ny.settNeste(første);
			første = ny;
			return;
		} else {
			node = node.getNeste();
		}
		if (node == null) {
			LinearNode ny = new LinearNode(element);
		}
		while (node != null) {
			if (node.getElement()
			        .compareTo() < 1) {

			}
			node = node.getNeste();
		}
	}
}// class