public interface Mediator {
    void sendMessage(String message, User user, Group group);
    void addUser(User user);
    void createGroup(String groupName, AdminUser admin);
    void deleteGroup(String groupName, AdminUser admin);
    void joinGroup(User user, String groupName);
    void leaveGroup(User user, String groupName);
    Group getGroupByName(String groupName);
}