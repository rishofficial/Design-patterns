package BuilderPattenPractice;

public interface BicycleBuilder {
    void buildFrame();
    void buildGearSystem();
    void buildTireType();

    Bicycle getBicycle();
}
