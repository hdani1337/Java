package g3051a_verem;

public class Verem<T> {
	private Elem<T> head;
	private int size;
	
	public Verem() {
		this.head = null;
		size = 0;
	}
	
	public void push(T adat) {
		Elem<T> temp = new Elem<T>(adat);
		
		if(this.size == 0) {
			this.head = temp;
		}else {
			temp.setNext(this.head);
			this.head.setPrev(temp);
			this.head = temp;
		}
		
		size++;
	}
	
	public T pop() throws UresVeremException {	
		if(!isEmpty()) {
			Elem<T> temp = this.head;
			this.head = this.head.getNext();
			this.size--;
			return temp.getAdat();
		}else throw new UresVeremException();
	}

	public T peek() {
		return this.head.getAdat();
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public int search(T adat) {
		Elem<T> temp = this.head;
		int pos = 1;
		while(temp != null && temp.getAdat() != adat) {
			temp = temp.getNext();
			pos++;
		}
		return (temp == null) ? -1 : pos;
	}

	@Override
	public String toString() {
		String txt = "";
		Elem<T> temp = this.head;
		while(temp != null) {
			txt += temp.getAdat() + " <--> ";
			temp = temp.getNext();
		}
		return (this.size > 0) ? "[" + txt.substring(0,txt.length()-6) + " --> null](size: " + this.size + ")" : "[null](size: 0)";
	}
	
}
