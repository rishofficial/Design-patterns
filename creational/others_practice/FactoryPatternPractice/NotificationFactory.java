package FactoryPatternPractice;

public class NotificationFactory {
    public Notification createNotification(String type){
        Notification notification = null;
        if(type.equals("SMS")){
            notification = new SMSNotification();
        }
        else if(type.equals("Email")){
            notification = new EmailNotification();
        }
        return notification;
    }
}
