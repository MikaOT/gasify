package utilsExceptions;

public class FileNotFoundException extends Exception {
	public FileNotFoundException(String message) {
        super(message);
        System.out.println(message);
        message = "Archivo no encontrado...";
    }
}