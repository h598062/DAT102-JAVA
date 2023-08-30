public class KjedetUordnetListe<T extends Comparable<T>> implements
    UordnetListeADT<T> {
    private int antall;
    private LinearNode<T> foerste;
    public KjedetUordnetListe() {
        antall = 0;
        foerste = null;
    }
    //… get- og set-metoder kan du anta
    //… Andre metoder

    public String toString() {
        return toString(foerste);
    }
    private String toString(LinearNode<T> p) {
        String s = p.getElement().toString();
        if (p.getNeste() != null) {
            s += "\n" + toString(p.getNeste());
        }
        return s;
    }


    public void settInn(T el) {
        LinearNode<T> ny = new LinearNode<>(el);
        ny.setNeste(foerste);
        foerste = ny;
        antall++;
    }

    public void flyttFoersteTilSiste() {
        siste.setNeste(foerste);
        LinearNode<T> n = foerste.getNeste();
        foerste.setNeste(null);
        siste = foerste;
        foerste = n;
    }

    public T finnNestMinste() {
        if (antall < 2) {
            return null;
        }
        LinearNode<T> n = foerste.getNeste();
        T minst = foerste.getElement();
        T nestMinst = null;

        while(n != null) {
            if (n.getElement().compareTo(minst) < 0) {
                nestMinst = minst;
                minst = n.getElement();
            } else if (n.getElement().compareTo(nestMinst) < 0) {
            	nestMinst = n.getElement();
            }
            n = n.getNeste();
        }
        return nestMinst;
    }

}