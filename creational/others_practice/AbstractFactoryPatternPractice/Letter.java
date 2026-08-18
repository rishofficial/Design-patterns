package AbstractFactoryPatternPractice;

public interface Letter {
    public void printLetter();
}

class FormalLetter implements Letter{
    public void printLetter(){
        System.out.println("this is a formal letter");
    }
}

class InformalLetter implements Letter{
    public void printLetter(){
        System.out.println("this is a informal letter");
    }
}


interface Resume{
    public void printResume();
}

class FormalResume implements Resume{
    public void printResume(){
        System.out.println("this is a formal resume");
    }
}

class InformalResume implements Resume{
    public void printResume(){
        System.out.println("this is a informal resume");
    }
}

interface DocFactory{
    Letter createLetter();
    Resume createResume();
}

class FormalDocFactory implements DocFactory{
    public Letter createLetter(){
        return new FormalLetter();
    }
    public Resume createResume(){
        return new FormalResume();
    }
}

class InformalDocFactory implements DocFactory{
    public Letter createLetter(){
        return new InformalLetter();
    }
    public Resume createResume(){
        return new InformalResume();
    }
}

class Client{
    public static void main(String[] args) {
        // 1. Client chooses the mode/family
        DocumentFactory factory;
        if ("formal".equals("formal")) {
            factory = new FormalDocFactory();
        } else {
            factory = new InformalDocFactory();
        }

        // 2. Client uses the factory cleanly without worrying about the style anymore
        Letter myLetter = factory.createLetter();
        Resume myResume = factory.createResume();
    }
}