import java.util.HashMap;
import java.util.Map;

public class ProfileManager {
    private Map<String, UserProfile> profiles;

    public ProfileManager() {
        profiles = new HashMap<>();
    }

    // Add or update a user profile
    public void addProfile(String username, UserProfile profile) {
        profiles.put(username, profile);
    }

    // Get a user profile
    public UserProfile getProfile(String username) {
        return profiles.get(username);
    }

    // Check if a profile exists
    public boolean profileExists(String username) {
        return profiles.containsKey(username);
    }
}
