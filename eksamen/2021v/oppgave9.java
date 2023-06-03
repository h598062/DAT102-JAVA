public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T> {
    private int antall;
    private BinaerTreNode<T> rot;
    public KjedetBSTre() {
        antall = 0;
        rot = null;
    }
    // … get- og set metoder kan du anta
    public T finnMinste() {
        BinaerTreNode<T> n = rot;
        while(n.getVenstre() != null) {
            n = n.getVenstre();
        }
        return n.getElement();
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
    // … andre metoder
}