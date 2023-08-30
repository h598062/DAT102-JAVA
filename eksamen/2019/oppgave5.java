public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
    private int antall; // antall elementer
    private LinearNode<T> foerste, siste;
    /**
    * Lager en ny tom liste.
    */
    public KjedetOrdnetListe() {
        antall = 0;
        foerste = null;
        siste = null;
    }
    public int finnAntallMindre(T element) {
        LinearNode<T> n = foerste;
        int antMindre = 0;
        while(n != null && n.getElement().compareTo(element) < 0) {
            antMindre++;
            n = n.getNeste();
        }
        return antMindre;
    }
    public void fjernDuplikater() {
        if (foerste == null) {
            return;
        }
        LinearNode<T> denne = foerste;
        LinearNode<T> neste = foerste.getNeste();
        while(denne != null) {
            while(neste != null && denne.getElement().equals(neste.getElement())) {
                neste = neste.getNeste();
                antall--;
            }
            denne.setNeste(neste);
            denne = denne.getNeste();
        }
    }
}