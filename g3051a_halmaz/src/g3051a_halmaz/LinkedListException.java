package g3051a_halmaz;

public class LinkedListException extends Exception {

	public LinkedListException() {
		super("A megadott indexen nincs elem a listában!");
	}

	public LinkedListException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
