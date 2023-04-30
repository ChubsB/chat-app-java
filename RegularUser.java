public class RegularUser extends User {
    public RegularUser(Mediator mediator, String name) {
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
}