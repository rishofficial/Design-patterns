package FactoryPatternPractice;

public class Client {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();
        Notification myNotification = factory.createNotification("Email");
        myNotification.notifyUser();
    }
}
