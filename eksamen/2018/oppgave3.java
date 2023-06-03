/*
a)

	kø er en lineær datastruktur som bruker FIFO prinsippet for legge til og fjerne fra datastrukturen. Elementer legges til sist i køen, og fjernes fra først i køen.  


e)
	 i) O(n). fordi det er en for-løkke som looper gjennom antall elementer n
	 
	ii) Dette er fordi en sirkulær kø ikke flytter på elementer når noe fjernes. Den lagrer posisjon i tabell for første og siste element, og "looper" rundt til indeks 0 når den kommer til siste posisjon. Hvis tabellen blir full så utvides den på vanlig måte. 

*/



public class TabellKoe<T> implements KoeADT<T> {
    private final static int STDK = 100;
    private int bak;
    private T[] koe;
    public tabellKoe() {
        this(STDK);
    }
    public TabellKoe (int startKapasitet) {
        bak = 0;
        koe = (T[])(new Object[startKapasitet]);
    }
    public void innKoe(T element) {
        if (bak == koe.length -1) {
        	utvid();
        }
        koe[bak] = element;
        bak++;
    }
    public T utKoe() throws EmptyCollectionException {
        if (erTom()) {
        	throw new EmptyCollectionException("køen");
        }
        T ut = koe[0];
        for (int i = 1; i < bak; i++) {
        	koe[i-1] = koe[i];
        }
        bak--;
        return ut;
    }
    public T foerste() throws EmptyCollectionException {
        if (erTom()) {
        	throw new EmptyCollectionException("køen");
        }
        return koe[0];
    }
    private void utvid() {
        // Denne metoden utvider tabellområdet ved å lage en
        // større tabell og kopierer referansene
        // Du antar at denne metoden eksisteter
    }
    public boolean erTom() {
        return (antall == 0);
    }
    public int antall() {
        return antall;
    }
}