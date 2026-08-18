package BuilderPattenPractice;

public class Bicycle{
    private String frame;
    private String gearSystem;
    private String tireType;

    public void setFrame(String frame){
        this.frame = frame;
    }
    public void setGearSystem(String GearSystem){
        this.gearSystem = GearSystem;
    }
    public void setTireType(String TireType){
        this.tireType = TireType;
    }

    public void showSpecs(){
        System.out.println("Frame: " + frame);
        System.out.println("Gear System: " + gearSystem);
        System.out.println("Tire Type: " + tireType);
    }
}