package øving1b.oppg3;

public class Rektangel implements Figur {
	private double h;
	private double b;

	public Rektangel(double h, double b) {
		this.h = h;
		this.b = b;
	}

	@Override
	public double areal() {
		return h*b;
	}

	@Override
	public void tegn() {
		for (int i = 0; i < this.h; i++) {
			System.out.println("*".repeat((int) b));
		}
	}
}
