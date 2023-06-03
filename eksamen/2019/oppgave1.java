public class KjedetStabel<T> implements StabelADT<T> {
    private LinearNode<T> topp;
    private int antall;
    public KjedetStabel() {
        topp = null;
        antall = 0;
    }
    @Override
    public boolean erTom() {
        return (antall == 0);
    }

    @Override
    public void push(T el) {
    	LinearNode<T> ny = new LinearNode<>(el);
    	ny.setNeste(topp);
    	topp = ny;
    	antall++;
    }

    @Override
    public T pop() {
    	if (antall == 0) {
    		throw new EmptyCollectionException();
    	}
    	T el = top.getElement();
    	top = top.getNeste();
    	antall--;
    }

    @Override
    public T peek() {
    	if (antall == 0) {
    		throw new EmptyCollectionException();
    	}
    	return top.getElement();
    }
}