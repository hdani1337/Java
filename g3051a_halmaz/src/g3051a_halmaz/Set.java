package g3051a_halmaz;

public class Set<T extends Comparable<T>> {
	private Item<T> head;//Lista feje
	private Item<T> tail;//Lista vége
	
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
				
				T tempData = temp.getData();//aktuális adat
				T tempNextData;//következõ adat				
				
				/* amíg van következõ adat, és az kisebb mint a beszúrandó, addig megyünk
				 * ha kilép a ciklus, akkor a temp elem elõtt vagy után lesz az új elem helye*/
				while(temp.getNext() != null && (tempNextData = temp.getNext().getData()).compareTo(newItem) < 0) {	
					temp = temp.getNext();		
					tempData = temp.getData();	
				}
			
				//ha a beszúrandó adat nagyobb
				if(tempData.compareTo(newItem) < 0) {
					//Utána szúrjuk be
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
				//ha a beszúrandó adat kisebb
				else {
					//Elé szúrjuk be
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
					int tempData = Integer.valueOf(temp.getData().toString());//aktuális adat
					int tempNextData;//következõ adat
					int newData = Integer.valueOf(newItem.toString());//beszúrandó adat
					
					/* amíg van következõ adat, és az kisebb mint a beszúrandó, addig megyünk
					 * ha kilép a ciklus, akkor a temp elem elõtt vagy után lesz az új elem helye
					while(temp.getNext() != null && (tempNextData = Integer.valueOf(temp.getNext().getData().toString())) < newData) {	
						temp = temp.getNext();		
						tempData = Integer.valueOf(temp.getData().toString());	
					}
				
					//ha a beszúrandó adat nagyobb
					if(tempData < newData) {
						//Utána szúrjuk be
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
					//ha a beszúrandó adat kisebb
					else {
						//Elé szúrjuk be
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
					//Nem szám típusú elemek vannak a halmazban, tegye a végére
					this.tail.setNext(tempNew);		
					this.tail = tempNew;
				}*/
				/*if(newItem.compareTo(head.getData()) == -1) {
					//kisebb, elõre szúrjuk
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
