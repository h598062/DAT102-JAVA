public class DobbelKjedetOrdnetListe<T extends Comparable <T>>
    implements DobbelKjedetOrdnetListeADT<T> {
    private DobbelNode<T> foerste;
    private DobbelNode<T> siste;
    private int antall;

    public DobbelKjedetOrdnetListe(T minVerdi, T maksVerdi) {
        this.foerste = new DobbelNode<>(minVerdi);
        this.siste = new DobbelNode<>(maksVerdi);
        this.foerste.setNeste(siste);
        this.siste.setForrige(foerste);
        this.antall = 0;
    }

    public void leggTil(T el) {
        DobbelNode<T> n = foerste;
        while(n != null && el.compareTo(n.getElement()) < 0) {
            n = n.getNeste();
        }
        if (n != null) {
            DobbelNode<T> ny = new DobbelNode<>(el);
            ny.setForrige(n.getForrige());
            ny.setNeste(n);
            n.getForrige().setNeste(ny);
            n.setForrige(ny);
            antall++;
        }
    }
}