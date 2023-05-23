package utilsExceptions;

public class IOException extends Exception {
	public IOException(String message) {
	    super(message);
	    System.out.println(message);
	    message = "IO no encontrado...";
	}
}