package øving1b.oppg3;

public class Trekant implements Figur{
	private double sideLengde;

	public Trekant(double sideLengde) {
		this.sideLengde = sideLengde;
	}

	@Override
	public double areal() {
		return sideLengde*sideLengde/2;
	}

	@Override
	public void tegn() {
		for (int i = 0; i < this.sideLengde; i++) {
			System.out.println("*".repeat(i+1));
		}
	}
}
