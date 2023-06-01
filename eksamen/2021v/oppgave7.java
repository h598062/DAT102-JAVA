public class KjedetOrdnetListe<T extends Comparable<T>>
    implements OrdnetListeADT<T> {
    private int antall;
    private LinearNode<T> foerste;
    private LinearNode<T> siste;

    public void snu() {
        LinearNode<T>[] tmpArr = new LinearNode<>[antall + 2];
        LinearNode<T> node = foerste;
        int i = 0;
        // legg til alle noder i en tom array
        while(node != null) {
            tmpArr[i] = node;
            i++;
            node = node.getNeste();
        }
        // gå gjennom array baklengs og ordne node relasjon
        for (int j = tmpArr.length - 1; j > 0; j--) {
            node = tmpArr[j];
            node.setNeste(tmpArr[j - 1]);
        }
        // sett opp første og siste node på nytt
        foerste = tmpArr[tmpArr.length - 1];
        siste = tmpArr[0];
        siste.setNeste(null);
    }

    public boolean erLike(KjedetOrdnetListe<T> denAndre) {
        if (antall == denAndre.antall) {
            return erLikRek(foerste, denAndre.foerste);
        } else {
            return false;
        }
    }

    private boolean erLikRek(LinearNode<T> p1, LinearNode<T> p2) {
        // p1 og p2 er noder fra to foskjellige lister
        if (p1 == null && p2 == null) {
            return true;
        } else if (p1 == null || p2 == null) {
            return false;
        }
        if (p1.getElement().equals(p2.getElement())) {
            return erLikRek(p1.getNeste(), p2.getNeste());
        } else {
            return false;
        }
    }


}