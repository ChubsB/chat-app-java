public class AdminUser extends User {
    public AdminUser(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void sendMessage(String message, Group group) {
        if (groups.contains(group)) {
            mediator.sendMessage(message, this, group);
        } else {
            System.out.println(name + " is not a member of the group");
        }
    }

    @Override
    public void receiveMessage(String message, Group group) {
        System.out.println(name + " received in " + group.getName() + ": " + message);
    }

    public void createGroup(String groupName) {
        mediator.createGroup(groupName, this);
    }

    public void deleteGroup(String groupName) {
        mediator.deleteGroup(groupName, this);
    }
}