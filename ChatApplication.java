public class ChatApplication {
    private static ChatApplication instance;
    private ChatMediator mediator;

    private ChatApplication() {
        mediator = new ChatMediator();
    }

    public static ChatApplication getInstance() {
        if (instance == null) {
            instance = new ChatApplication();
        }
        return instance;
    }
}