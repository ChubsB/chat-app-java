public class ChatDemo {
    public static void main(String[] args) {
        // Create an instance of the chat application
        ChatApplication chatApp = ChatApplication.getInstance();

        // Create the mediator
        Mediator chatMediator = new ChatMediator();

        // Create users and register them with the mediator
        AdminUser alice = new AdminUser(chatMediator, "Alice");
        RegularUser bob = new RegularUser(chatMediator, "Bob");
        RegularUser charlie = new RegularUser(chatMediator, "Charlie");

        // Admin user creates a group
        alice.createGroup("General");

        // Regular users join the group
        bob.joinGroup(chatMediator.getGroupByName("General"));
        charlie.joinGroup(chatMediator.getGroupByName("General"));

        // Users send messages in the group
        alice.sendMessage("Hi, everyone!", chatMediator.getGroupByName("General"));
        bob.sendMessage("Hello, Alice!", chatMediator.getGroupByName("General"));
        charlie.sendMessage("Hey, guys!", chatMediator.getGroupByName("General"));

        // Admin user creates another group
        alice.createGroup("Developers");

        // Admin user adds users to the new group
        alice.joinGroup(chatMediator.getGroupByName("Developers"));
        bob.joinGroup(chatMediator.getGroupByName("Developers"));

        // Users send messages in the new group
        alice.sendMessage("Welcome to the Developers group!", chatMediator.getGroupByName("Developers"));
        bob.sendMessage("Thanks, Alice!", chatMediator.getGroupByName("Developers"));

        // Admin user deletes the first group
        alice.deleteGroup("General");
    }
}