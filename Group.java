import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private List<User> users;

    public Group(String name) {
        this.name = name;
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void removeAllUsers() {
        users.clear();
    }

    public void sendMessage(String message, User sender) {
        for (User user : users) {
            if (user != sender) {
                user.receiveMessage(message, this);
            }
        }
    }

    public String getName() {
        return name;
    }
}