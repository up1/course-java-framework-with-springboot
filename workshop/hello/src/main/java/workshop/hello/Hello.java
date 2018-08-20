package workshop.hello;

public class Hello {

    private String message;

    public Hello() {
    }

    Hello(String name) {
        this.message = "Hello, " + name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

