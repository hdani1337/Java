package g3051a_halmaz;

public class Set<T extends Comparable<T>> {
	private Item<T> head;//Lista feje
	private Item<T> tail;//Lista v�ge
	
	private int count;
	
	public Set() {
		this.head = null;
		this.tail = null;
		this.count = 0;
	}
	
	public Set(T firstData) {
		Item<T> temp = new Item<T>(firstData);
		this.head = this.tail = temp;
		this.count = 1;
	}
	
	public Set(Set<T> other) {
		for(int i = 0; i < other.count; i++) {
			T temp = other.get(i);
			addItem(temp);
		}
	}
	
	public void addItem(T newItem) {
		if(!isElement(newItem)) {
			Item<T> tempNew = new Item<T>(newItem);
			if(isEmpty()) {
				this.head = this.tail = tempNew;
			}else {
				Item<T> temp = this.head;
				
				T tempData = temp.getData();//aktu�lis adat
				T tempNextData;//k�vetkez� adat				
				
				/* am�g van k�vetkez� adat, �s az kisebb mint a besz�rand�, addig megy�nk
				 * ha kil�p a ciklus, akkor a temp elem el�tt vagy ut�n lesz az �j elem helye*/
				while(temp.getNext() != null && (tempNextData = temp.getNext().getData()).compareTo(newItem) < 0) {	
					temp = temp.getNext();		
					tempData = temp.getData();	
				}
			
				//ha a besz�rand� adat nagyobb
				if(tempData.compareTo(newItem) < 0) {
					//Ut�na sz�rjuk be
					if(temp == head) {
						temp.setNext(tempNew);
						tail = tempNew;
					}else if(temp == tail) {
						temp.setNext(tempNew);
						tail = tempNew;
					}else {
						tempNew.setNext(temp.getNext());
						temp.setNext(tempNew);
					}
				}
				//ha a besz�rand� adat kisebb
				else {
					//El� sz�rjuk be
					if(temp == head) {
						tempNew.setNext(temp);
						head = tempNew;
					}else if(temp == tail) {
						temp.setNext(tempNew);
						tail = tempNew;
					}else {
						tempNew.setNext(temp);
					}
				}
				
				/*Item<T> temp = this.head;
				try {
					int tempData = Integer.valueOf(temp.getData().toString());//aktu�lis adat
					int tempNextData;//k�vetkez� adat
					int newData = Integer.valueOf(newItem.toString());//besz�rand� adat
					
					/* am�g van k�vetkez� adat, �s az kisebb mint a besz�rand�, addig megy�nk
					 * ha kil�p a ciklus, akkor a temp elem el�tt vagy ut�n lesz az �j elem helye
					while(temp.getNext() != null && (tempNextData = Integer.valueOf(temp.getNext().getData().toString())) < newData) {	
						temp = temp.getNext();		
						tempData = Integer.valueOf(temp.getData().toString());	
					}
				
					//ha a besz�rand� adat nagyobb
					if(tempData < newData) {
						//Ut�na sz�rjuk be
						if(temp == head) {
							temp.setNext(tempNew);
							tail = tempNew;
						}else if(temp == tail) {
							temp.setNext(tempNew);
							tail = tempNew;
						}else {
							tempNew.setNext(temp.getNext());
							temp.setNext(tempNew);
						}
					}
					//ha a besz�rand� adat kisebb
					else {
						//El� sz�rjuk be
						if(temp == head) {
							tempNew.setNext(temp);
							head = tempNew;
						}else if(temp == tail) {
							temp.setNext(tempNew);
							tail = tempNew;
						}else {
							tempNew.setNext(temp);
						}
					}
					
				}catch(NumberFormatException e) {
					//Nem sz�m t�pus� elemek vannak a halmazban, tegye a v�g�re
					this.tail.setNext(tempNew);		
					this.tail = tempNew;
				}*/
				/*if(newItem.compareTo(head.getData()) == -1) {
					//kisebb, el�re sz�rjuk
					tempNew.setNext(this.head);
					this.head = tempNew;
				}else if(newItem.compareTo(head.getData()) == 1) {
					this.tail.setNext(tempNew);		
					this.tail = tempNew;
				}*/
			}
			this.count++;
		}
	}
	
	public boolean isEmpty() {
		return this.count == 0;
	}
	
	public boolean isElement(T data) {
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
		return "{" + out.substring(0,out.length()-2) + "}";
	}
	
	public Set<T> union(Set<T> other) {
		Set<T> temp = new Set<T>();
		
		Item<T> tempItem = this.head;
		while(tempItem != null) {
			temp.addItem(tempItem.getData());
			tempItem = tempItem.getNext();
		}
		
		tempItem = other.head;
		while(tempItem != null) {
			temp.addItem(tempItem.getData());
			tempItem = tempItem.getNext();
		}
		
		return temp;
	}
	
	public Set<T> intersection(Set<T> other) {
		Set<T> temp = new Set<T>();
		
		Item<T> tempItem = this.head;
		while(tempItem != null) {
			if(other.isElement(tempItem.getData()))
				temp.addItem(tempItem.getData());
			tempItem = tempItem.getNext();
		}
		
		return temp;
	}
	
}
