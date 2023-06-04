public class TabellHaug<T extends Comparable<T>> implements HaugADT<T> {
    private T[] data;
    private int antall;// antall elementer
    private static final int STDK = 100;
    public TabellHaug() {
        data = (T[]) new Comparable[STDK];
        antall = 0;
    }
    public boolean erTom() {
        return antall == 0;
    }
    @Override
    public void leggTilElement(T el) {
        if (antall == data.length) {
            utvidTabell();
        }
        data[antall] = el; // Plasser den nye helt sist
        antall++;
        if (antall > 1) {
            reparerOpp(); // Bytt om oppover hvis nødvendig
        }
    }
    private void reparerOpp() {
        int indeks = antall - 1;
        boolean ferdig = false;
        while(!ferdig) {
            int forelder = indeks / 2;
            if (data[indeks].compareTo(data[forelder]) > 0) {
                T tmp = data[indeks];
                data[indeks] = data[forelder];
                data[forelder] = tmp;
                indeks = forelder;
            } else {
                ferdig = true;
            }
        }
    }
    public boolean erHaug(T data[]) {
        return erHaug(data, 0, antall - 1);
    }
    private boolean erHaug(T data[], int r, int m) {
        
    }
    private void utvidTabell() {

    }
}