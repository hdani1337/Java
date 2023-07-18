package g3051a_verem;

public class Elem<T> {
	private T adat;
	private Elem<T> next;
	private Elem<T> prev;
	
	public Elem(T adat) {
		this.adat = adat;
		this.next = null;
		this.prev = null;
	}

	public T getAdat() {
		return adat;
	}

	public void setAdat(T adat) {
		this.adat = adat;
	}

	public Elem<T> getNext() {
		return next;
	}

	public void setNext(Elem<T> next) {
		this.next = next;
	}

	public Elem<T> getPrev() {
		return prev;
	}

	public void setPrev(Elem<T> prev) {
		this.prev = prev;
	}
}
