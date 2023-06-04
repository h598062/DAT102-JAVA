/*
a)
  i)  venstre barn til 35
 ii)  høyre barn til 70
iii)  45 eller 55

b)
  i)  et binært tre er balansert når det ikke er mer enn en nodehøyde i forskjell mellom laveste og høyeste blad-node.
  Grunnen til at det er viktig at binær trær er balansert er fordi det er mye kjappere å utføre operasjoner på et balansert tre enn et ubalansert tre.

 ii)  1) O(n)
 	  2) O(log n)

iii) 10 blir rotnode, 20 blir høyrebarn til 10,  15 blir venstrebarn til 20

 iv) 7 blir rotnode, 5 blir venstrebarn til 7, 6 blir høyrebarn til 5

*/

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T> {
    private int antall;
    private BinaerTreNode<T> rot;
    /******************************************************************
    * Oppretter et tomt binært søketre.
    ******************************************************************/
    public KjedetBSTre() {
        antall = 0;
        rot = null;
    }
    /******************************************************************
    * Oppretter et binært søketre med en node..
    ******************************************************************/
    public KjedetBSTre(T element) {
        antall = 1;
        rot = new BinaerTreNode<T>(element);
    }
    /*******************************************************************
    * Returnerer sann hvis bs-treet er tomt, elles usann.
    *******************************************************************/
    public boolean erTom() {
        return (antall == 0);
    }
    /*******************************************************************
    * Returnerer det minste elementet fra bs-treet.
    *******************************************************************/
    public T finnMin() {
        BinaerTreNode<T> n = rot;
        if (n == null) {
        	return null;
        }
        while(n.getVenstre() != null) {
        	n = n.getVenstre();
        }
        return n.getElement();
    }
    /*******************************************************************
    * finner antall elementer mindre enn elmenentet gitt som parameter
    *******************************************************************/
    public int antallMindreEnn(T element) {
        return antallMindre(rot, element);
    }
    private int antallMindre(BinaerTreNode<T> n, T e) {
    	if (n == null) {
    		return 0;
    	}
    	if (e.compareTo(n.getElement()) < 0) {
    		return antallMindre(n.getVenstre(), e);
    	} else {
    		int i = 1;
    		i += antallMindre(n.getVenstre(), e);
    		i += antallMindre(n.getHogre(), e);
    		return i;
    	}
    }

    
   
}