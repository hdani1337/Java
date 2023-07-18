package g3051a_template;

public class Item<T> {

	private T data;//T�rolt adat
	private Item<T> next;//L�ncolt lista k�vetkez� eleme
	
	public Item(T data) {
		this.data = data;
		this.next = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Item<T> getNext() {
		return next;
	}

	public void setNext(Item<T> next) {
		this.next = next;
	}
	
}
