package Raw;

public class Token {
    private final String token;
    private final String state;

    public Token(String token,
                 String state) {
        this.token = token;
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public String getToken() {
        return token;
    }
}
