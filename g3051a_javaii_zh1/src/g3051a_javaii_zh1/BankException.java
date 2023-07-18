package g3051a_javaii_zh1;

public class BankException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public BankException() {
		super("!!!BankException!!!");
		this.printStackTrace();
	}

	public BankException(String message) {
		super("BankException(" + message + ")");
		// TODO Auto-generated constructor stub
	}
}
