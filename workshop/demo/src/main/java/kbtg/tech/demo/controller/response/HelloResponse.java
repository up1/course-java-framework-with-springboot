package kbtg.tech.demo.controller.response;

public class HelloResponse {
	
	private String message;

	public HelloResponse(String name) { 
		setMessage(name); 
	}

	public HelloResponse() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
