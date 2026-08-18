package BuilderPattenPractice;

public class BicycleDirector {
    private BicycleBuilder builder;

    public BicycleDirector(BicycleBuilder builder){
        this.builder = builder;
    }

    public void buildBicycle(){
        builder.buildFrame();
        builder.buildGearSystem();
        builder.buildTireType();

    }
}
