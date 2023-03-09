package no.hvl.dat102;

public class Main {

	// Flettar saman to sorterte kjedar til ein. Lagar ikkje nye nodar
	public static LinearNode<Integer> flett(LinearNode<Integer> p, LinearNode <Integer> q){
		
		// to basistilfelle
		if (p == null) {
			return q;
		} else if (q == null) {
			return p;
		}
		
		LinearNode<Integer> forste;
		LinearNode<Integer> resten;
		if (p.getElement().compareTo(q.getElement()) <= 0) {
			forste = p;
			resten = flett(p.getNeste(), q);
		} else {
			forste = q;
			resten = flett(p, q.getNeste());
		}
		
		forste.setNeste(resten);
		
		return forste;
	}
	
	public static void visKjede(LinearNode<Integer> kjede) {
		if (kjede == null) {
			System.out.println("Kjeden er tom");
		}
		
		LinearNode<Integer> p = kjede;
		while (p != null) {
			System.out.print(p.getElement() + " ");
			p = p.getNeste();
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		// Lagar to sorterte kjedar
		LinearNode<Integer> a = new LinearNode<>(1);
		LinearNode<Integer> n2 = new LinearNode<>(3);
		a.setNeste(n2);
		
		LinearNode<Integer> b = new LinearNode<>(2);
		LinearNode<Integer> n4 = new LinearNode<>(4);
		b.setNeste(n4);
		
		visKjede(a);
		visKjede(b);
		
		// Flett og vis resultat
		
		LinearNode<Integer> heile = flett(a, b);
		a = null;
		b = null;
		visKjede(heile);
		
		// System.out.println(a.getElement());
		
		System.out.println(Math.floor(-4.1));
		
	}

}
