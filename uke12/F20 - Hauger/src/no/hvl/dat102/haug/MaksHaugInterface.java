package no.hvl.dat102.haug;

public interface MaksHaugInterface<T extends Comparable<? super T>> {
	void leggTil(T nyttElement);

	T fjernMaks();

	T finnMaks();

	boolean erTom();

	int getAntall();

	void toem();
}

