package no.hvl.dat102.labyrint;

public class Stifinner {
	private final Labyrint labyrint;

	public Stifinner(Labyrint labyrint) {
		this.labyrint = labyrint;
	}

	public boolean finnSti(int r, int k) {
		boolean ferdig = false;

		// basis?
		// gjer ingenting

		if (labyrint.lovlegPosisjon(r, k)) {
			labyrint.provPosijon(r, k);
			if (r == labyrint.getRekker() - 1 && k == labyrint.getKolonner() - 1) {
				ferdig = true;
				labyrint.markerSti(r, k);
			} else {
				// Rekursive kall
				ferdig = finnSti(r, k + 1); // høgre

				if (!ferdig) { // ned
					ferdig = finnSti(r + 1, k);
				}

				if (!ferdig) { // venstre
					ferdig = finnSti(r, k - 1);
				}

				if (!ferdig) { // opp
					ferdig = finnSti(r - 1, k);
				}

				if (ferdig) {
					labyrint.markerSti(r, k);
				}
			}
		}
		return ferdig;
	}
}
