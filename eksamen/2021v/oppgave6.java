public class KjedetOrdnetListe<T extends Comparable<T>>
    implements OrdnetListeADT<T> {
    private int antall;
    private LinearNode<T> foerste;
    private LinearNode<T> siste;

    public KjedetOrdnetListe(T minVerdi, T maksVerdi) {
        this.foerste = new LinearNode(minVerdi);
        this.siste = new LinearNode(maksVerdi);
        this.foerste.setNeste(siste);
        this.antall = 0;
    }

    public T finnMaks() {
        if (erTom())
            throw new EmptyCollectionException("ordnet liste tom");

        T maks = foerste.getElement();
        LinearNode<T> denne = foerste;
        for (int i = 0; i < antall; i++) {
            denne = denne.getNeste();
            if (denne == null) {
                return maks;
            }
            T el = denne.getElement();
            if (maks.compareTo(el) < 0) {
                maks = el;
            }
        }
        return maks;
    }

    public boolean fjernAlle(T el) {
        if (erTom())
            throw new EmptyCollectionException("tom ordnet liste");

        LinearNode<T> forrige = foerste;
        boolean harFjernet = false;
        while (forrige.getNeste() != siste) {
        	LinearNode<T> denne = forrige.getNeste();
        	if (denne.getElement().compareTo(el) > 0) {
        		return harFjernet;
        	}
        	if (denne.getElement().equals(el)) {
        		forrige.setNeste(denne.getNeste());
        		antall--;
        		harFjernet = true;
        	}
        	forrige = denne;
        }
        return harFjernet;
    }

    // get – og set-metoder kan du anta
    public int antall() {
        return antall;
    }
    public boolean erTom() {
        return antall == 0;
    }
    //… andre metoder
}