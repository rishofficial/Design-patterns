package FactoryPatternPracticeB;

public interface Transport {
    public void deliver();
}

class Truck implements Transport{
    public void deliver(){
        System.out.println("Truck Delivery");
    }
}

class Ship implements Transport{
    public void deliver(){
        System.out.println("Ship Delivery");
    }
}

class TransportFactory{
    public Transport createTransport(String trans){
        Transport transport = null;
        if("Sea".equalsIgnoreCase(trans)){
            transport = new Ship();
        }
        else if("Road".equalsIgnoreCase(trans)){
            transport = new Truck();
        }
        return transport;
    }
}

class Client{
    public static void main(String[] args) {
        TransportFactory factory = new TransportFactory();

        Transport myTruck = factory.createTransport("Road");
        Transport myShip = factory.createTransport("Sea");

        myTruck.deliver();
        myShip.deliver();
    }
}