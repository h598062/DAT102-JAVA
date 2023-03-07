package no.hvl.dat102.stiar;

public class Stiar {

	static int antallStiar(int startX, int startY, int sluttX, int sluttY) {
		if (startX == sluttX || startY == sluttY) {
			return 1;
		}

		int stiarHogre = antallStiar(startX + 1, startY, sluttX, sluttY);
		int stiarNed   = antallStiar(startX, startY + 1, sluttX, sluttY);

		return stiarHogre + stiarNed;
	}

	public static void main(String[] args) {
		int rekker   = 4;
		int kolonner = 3;

		// antal stiar frå (1,1) til (4,3)
		System.out.println("Antall stidar: " + antallStiar(3, 2, 4, 3));

	}

}
