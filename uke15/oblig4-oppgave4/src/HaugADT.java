public interface HaugADT<T extends Comparable<T>> {
	/**
	 * @param el Elementet som skal legges til haugen
	 */
	void leggTilElement(T el);

	/**
	 * Fjerner det minste elementet fra haugen
	 *
	 * @return elementet med lavest verdi
	 *
	 * @throws EmptyCollectionException unntak som kastes hvis haugen er tom
	 */
	T fjernMinste();

	/**
	 * Finner det minste elementet i haugen
	 *
	 * @return Elementet med lavest verdi
	 *
	 * @throws EmptyCollectionException unntak som kastes hvis haugen er tom
	 */
	T finnMinste();

	/**
	 * Avgjør om haugen er tom
	 *
	 * @return true hvis haugen er tom, false ellers
	 */
	boolean erTom();

	/**
	 * @return returnerer antall
	 */
	int antall();
}// interface