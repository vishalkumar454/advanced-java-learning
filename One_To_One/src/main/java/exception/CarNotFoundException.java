package exception;

public class CarNotFoundException extends RuntimeException{
	
	public CarNotFoundException(String massage) {
		super(massage);
	}
}
