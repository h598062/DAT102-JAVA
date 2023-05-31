public class KjedetOrdnetListe<T extends Comparable<T>>
    implements OrdnetListeADT<T> {
    private int antall;
    private LinearNode<T> foerste;
    private LinearNode<T> siste;

    public void snu() {
    	
    }

    public boolean erLike(KjedetOrdnetListe<T> denAndre) {
        if (antall == denAndre.antall) {
            return erLikRek(foerste, denAndre.foerste);
        } else {
            return false;
        }
    }
    
    private boolean erLikRek(LinearNode<T> p1, LinearNode<T> p2) {

    } 


}