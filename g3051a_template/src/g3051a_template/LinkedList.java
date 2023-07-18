package g3051a_template;

public class LinkedList<T> {
	
	private Item<T> head;//Lista feje
	private Item<T> tail;//Lista vége
	
	private int count;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.count = 0;
	}
	
	public LinkedList(T firstData) {
		Item<T> temp = new Item<T>(firstData);
		this.head = this.tail = temp;
		this.count = 1;
	}
	
	public LinkedList(LinkedList<T> other) {
		for(int i = 0; i < other.count; i++) {
			T temp = other.get(i);
			addItem(temp);
		}
	}
	
	public void addItem(T newItem) {
		Item<T> temp = new Item<T>(newItem);
		if(this.count == 0) {
			this.head = this.tail = temp;
		}else {
			this.tail.setNext(temp);
			this.tail = temp;
		}
		this.count++;
	}
	
	public void addItemBefore(T newItem) {
		Item<T> temp = new Item<T>(newItem);
		temp.setNext(this.head);
		this.head = temp;
		this.count++;
	}
	
	public boolean isEmpty() {
		return this.count == 0;
	}
	
	public boolean contains(T data) {
		Item<T> temp = this.head;
		while(temp != null && temp.getData() != data) 
			temp = temp.getNext();
		return temp != null;
	}
	
	public int getCount() {
		return count;
	}

	public T get(int index) {
		try {
			if(index >= count)
				throw new LinkedListException();
			Item<T> temp = this.head;
			int tempIndex = 0;
			while(tempIndex < index) {
				temp = temp.getNext();
				tempIndex++;
			}
			return temp.getData();
		}catch(LinkedListException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public void print() {
		Item<T> temp = this.head;
		while(temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}

	@Override
	public String toString() {
		String out = "";
		Item<T> temp = this.head;
		while(temp != null) {
			out = out + temp.getData() + ", ";
			temp = temp.getNext();
		}
		return "[" + out.substring(0,out.length()-2) + "]";
	}
	
}
