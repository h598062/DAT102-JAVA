public class UordnetKjedetListe<T> implements
    UordnetKjedetListeADT<T> {
    private int antall;
    private LinearNode<T> foerste, siste;
    public UordnetKjedetListe () {
        antall = 0;
        foerste = null;
        siste = null;
    }

    public int antallLike(T el) {
        int telle = 0;
        LinearNode<T> n = foerste;
        while (n != null) {
            if (n.getElement().equals(el)) {
                telle++;
            }
            n = n.getNeste();
        }
        return telle;
    }

    public T minste() {
        T minste = null;
        LinearNode<T> n = foerste;
        while (n != null) {
            if (minste == null) {
                minste = n.getElement();
            }
            if (n.getElement().compareTo(minste) < 0) {
                minste = n.getElement();
            }
            n = n.getNeste();
        }
        return minste;
    }

    public boolean inneholder(T element) {
        return inneholderRek(foerste, element);
    }


    private boolean inneholderRek(LinearNode<T> denne, T element) {
    	if (denne == null) {
    		return false;
    	}
    	if (denne.getElement().equals(element)) {
    		return true;
    	} else {
    		return inneholderRek(denne.getNeste(), element);
    	}
    }
}

public class LinearNode<T> {
    private LinearNode<T> neste;
    private T element;
    public LinearNode() {
        neste = null;
        element = null;
    }
    public LinearNode(T elem) {
        neste = null;
        element = elem;
    }
    public LinearNode<T> getNeste() {
        return neste;
    }
    public void setNeste(LinearNode<T> node) {
        neste = node;
    }
    public T getElement() {
        return element;
    }
    public void setElement(T elem) {
        element = elem;
    }
}