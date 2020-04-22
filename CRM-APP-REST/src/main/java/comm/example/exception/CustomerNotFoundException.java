package comm.example.exception;

public class CustomerNotFoundException extends Throwable {
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CustomerNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "CustomerNotFoundException [message=" + message + "]";
	}
	

}
