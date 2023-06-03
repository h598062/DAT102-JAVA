/*
	a)
	i)
	preorden:  10 11 14 15 12  8  4
	inorden:   14 11 15 10  8  4 12
	postorden: 14 15 11  4  8 12 10

	b)
	Et binært søketre er et binær tre hvor elementer blir sortert når de legges inn. Hver node sitt venstre barn skal være mindre enn seg selv, og høyre barn skal være større. Dette gjør det enkelt å finne verdier i treet.

	c)
        37
      /    \
   10       68
    \      /  \
    15    39   70
      \    \
       30   42

	d)
        15
      /    \
   10       68
           /  \
          39   70
           \
           42

*/

public class BinaerTre<T> implements BinaerTreADT<T> {
    private BinaerTreNode<T> rot;
    private int antall;
    public BinaerTre() {
        rot = null;
        antall = 0;
    }
    public BinaerTre(T element) {
        rot = new BinaerTreNode<T>(element);
        antall = 1;
    }
    public BinaerTre(T element, BinaerTre<T> vt, BinaerTre<T> ht) {
        // Lager et binært tre av to eksisterende binære trær, vt og ht
        // og en ny rot med gitt data
        this.rot = new BinaerTreNode<>(element);
        this.antall = 1;
        this.rot.setVenstre(vt.getRot());
        antall += vt.antall();
        this.rot.setHoyre(ht.getRot());
        antall += ht.antall();
    }
    public BinaerTreNode<T> getRot() {
        return rot;
    }
    public int antall() {
        return antall;
    }
    public int hoyde() {
        int resultat = -1;
        if (!erTom()) {
            resultat = hoydeRek(rot);
        }
        return resultat;
    }
    private int hoydeRek(BinaerTreNode<T> p) {
        BinaerTreNode<T> vb = p.getVenstre();
        BinaerTreNode<T> hb = p.getHoyre();
        int vh = 0;
        int hh = 0;
        if (vb != null) {
            vh++;
            vh += hoydeRek(vb);
        }
        if (hb != null) {
            hh++;
            hh += hoydeRek(hb);
        }
        return Math.max(vh, hh);
    }
}

public class KjedetBSTre<T extends Comparable<T>> implements
    BSTreADT<T> {
    private int antall;
    private BinaerTreNode<T> rot;
    public KjedetBSTre() {
        antall = 0;
        rot = null;
    }
    public KjedetBSTre(T element) {
        antall = 1;
        rot = new BinaerTreNode<T>(element);
    }
    public int antall() {
        return antall;
    }
    public T finnMin() {
    	if (rot = null) {
    		return null;
    	}
    	BinaerTreNode<T> n = rot;
    	while(n.getVenstre() != null) {
    		n = n.getVenstre();
    	}
    	return n.getElement();
    }
}

public class BinaerTreNode<T> {
    private T element;
    private BinaerTreNode<T> venstre;
    private BinaerTreNode<T> hoyre;
    public BinaerTreNode(T el) {
        element = el;
        venstre = null;
        hoyre = null;
    }
    public BinaerTreNode(T element, BinaerTreNode<T> venstre,
                         BinaerTreNode<T> hoyre) {
        this.element = element;
        this.venstre = venstre;
        this.hoyre = hoyre;
    }
    public BinaerTreNode<T> getVenstre() {
        return venstre;
    }
    public BinaerTreNode<T> getHoyre() {
        return hoyre;
    }
    public void setVenstre(BinaerTreNode<T> ny) {
        venstre = ny;
    }
    public void setHoyre(BinaerTreNode<T> ny) {
        hoyre = ny;
    }
    public T getElement() {
        return element;
    }
    public void setElement(T el) {
        element = el;
    }
}