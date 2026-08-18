package BuilderPattenPractice;

public class BikeShopRunner {
    public static void main(String[] args) {
        BicycleBuilder commuteBicycleBuilder = new CommuterBicycleBuilder();
        BicycleDirector director1 = new BicycleDirector(commuteBicycleBuilder);

        director1.buildBicycle();
        Bicycle commuterBike = commuteBicycleBuilder.getBicycle();
        System.out.println("First cycle: ");
        commuterBike.showSpecs();

        BicycleBuilder mountainBicycleBuilder = new MountainBeastBicycleBuilder();
        BicycleDirector director2 = new BicycleDirector(mountainBicycleBuilder);
        director2.buildBicycle();
        Bicycle mountainBike = mountainBicycleBuilder.getBicycle();
        System.out.println("Second cycle: ");
        mountainBike.showSpecs();
    }
}
