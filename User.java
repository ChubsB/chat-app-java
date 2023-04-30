import java.util.ArrayList;
import java.util.List;

public abstract class User {
    protected Mediator mediator;
    protected String name;
    protected List<Group> groups;

    public User(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        this.groups = new ArrayList<>();
        mediator.addUser(this);
    }

    public abstract void sendMessage(String message, Group group);
    public abstract void receiveMessage(String message, Group group);

    public void joinGroup(Group group) {
        if (!groups.contains(group)) {
            groups.add(group);
            group.addUser(this);
        } else {
            System.out.println(name + " is already a member of the group");
        }
    }

    public void leaveGroup(Group group) {
        if (groups.contains(group)) {
            groups.remove(group);
            group.removeUser(this);
        } else {
            System.out.println(name + " is not a member of the group");
        }
    }
}