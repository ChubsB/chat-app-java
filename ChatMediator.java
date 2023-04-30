import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatMediator implements Mediator {
    private List<User> users;
    private Map<String, Group> groups;

    public ChatMediator() {
        users = new ArrayList<>();
        groups = new HashMap<>();
    }

    @Override
    public void sendMessage(String message, User user, Group group) {
        group.sendMessage(message, user);
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void createGroup(String groupName, AdminUser admin) {
        if (!groups.containsKey(groupName)) {
            Group newGroup = new Group(groupName);
            groups.put(groupName, newGroup);
            admin.joinGroup(newGroup);
        } else {
            System.out.println("Group already exists");
        }
    }

    @Override
    public void deleteGroup(String groupName, AdminUser admin) {
        if (groups.containsKey(groupName)) {
            groups.get(groupName).removeAllUsers();
            groups.remove(groupName);
        } else {
            System.out.println("Group does not exist");
        }
    }

    @Override
    public void joinGroup(User user, String groupName) {
        if (groups.containsKey(groupName)) {
            groups.get(groupName).addUser(user);
        } else {
            System.out.println("Group does not exist");
        }
    }

    @Override
    public void leaveGroup(User user, String groupName) {
        if (groups.containsKey(groupName)) {
            groups.get(groupName).removeUser(user);
        } else {
            System.out.println("Group does not exist");
        }
    }

    @Override
    public Group getGroupByName(String groupName) {
        return groups.get(groupName);
    }
}