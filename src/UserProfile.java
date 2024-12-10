public class UserProfile {
    private String username;
    private String name;
    private String email;

    // Constructor
    public UserProfile(String username, String name, String email) {
        this.username = username;
        this.name = name;
        this.email = email;
    }

    // Getter methods for user profile attributes
    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Username: " + username + ", Name: " + name + ", Email: " + email;
    }
}
