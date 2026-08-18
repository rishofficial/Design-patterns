package SingletonPractice;

class Client1{
    Logger logger;
    public void clientMessage(){
        logger = Logger.getInstance();
        logger.message("Client1");
    }
}

class Client2{
    Logger logger;
    public void clientMessage(){
        logger = Logger.getInstance();
        logger.message("Client2");
    }
}

public class Demo{
    public static void main(String[] args) {
        Client1 c1 = new Client1();
        Client2 c2 = new Client2();
        c1.clientMessage();
        c2.clientMessage();
        if(c1.logger == c2.logger){
            System.out.println("same instance used");
        }
        else{
            System.out.println("different instances used");
        }
    }
}