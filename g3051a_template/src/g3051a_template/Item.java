package g3051a_template;

public class Item<T> {

	private T data;//Tárolt adat
	private Item<T> next;//Láncolt lista következõ eleme
	
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
