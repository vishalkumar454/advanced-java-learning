package exception;

public class EngineNotFoundException extends RuntimeException {
	
	public EngineNotFoundException(String massage) {
		super(massage);
	}
}
