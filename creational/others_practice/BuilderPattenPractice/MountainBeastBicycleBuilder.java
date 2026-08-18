package BuilderPattenPractice;

public class MountainBeastBicycleBuilder implements BicycleBuilder{
    Bicycle bicycle = new Bicycle();
    public void buildFrame(){
        bicycle.setFrame("Carbon Fiber Frame");
    }
    public void buildGearSystem(){
        bicycle.setGearSystem("12-Speed Gear");
    }
    public void buildTireType(){
        bicycle.setTireType("Off-road Grip Tires");
    }

    public Bicycle getBicycle(){
        return bicycle;
    }
}
