package BuilderPattenPractice;

public class CommuterBicycleBuilder implements BicycleBuilder{
    Bicycle bicycle = new Bicycle();
    public void buildFrame(){
        bicycle.setFrame("Aluminum Frame");
    }
    public void buildGearSystem(){
        bicycle.setGearSystem("Single Speed Gear");
    }
    public void buildTireType(){
        bicycle.setTireType("Road Tires");
    }

    public Bicycle getBicycle(){
        return bicycle;
    }
}
