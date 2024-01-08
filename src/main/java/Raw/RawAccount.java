package Raw;

public class RawAccount {
    private final String username;
    private final String password;

    public RawAccount(String username,
                      String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "RawAccount{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
