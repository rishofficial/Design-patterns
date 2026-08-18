package SingletonPractice;

public class Logger {
    private static Logger instance = null;
    private Logger(){
        System.out.println("Single Instance created");
    }
    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public void message(String msg){
        System.out.println(msg);
    }
}
