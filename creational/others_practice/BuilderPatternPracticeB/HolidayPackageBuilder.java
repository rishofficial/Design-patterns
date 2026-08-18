package BuilderPatternPracticeB;

public interface HolidayPackageBuilder {
    public void buildFlight();
    public void buildHotel();
    public void buildDailyActivity();

    public HolidayPackage getPackage();
}


class RelaxationPackageBuilder implements HolidayPackageBuilder{
    HolidayPackage holidayPackage = new HolidayPackage();

    public void buildFlight(){
        holidayPackage.setFlight("Business Class Flight");
    }
    public void buildHotel(){
        holidayPackage.setHotel("5-Star Resort");
    }
    public void buildDailyActivity(){
        holidayPackage.setDailyActivity("Spa Treatment");
    }

    public HolidayPackage getPackage(){return holidayPackage;}
}

class AdventurePackageBuilder implements HolidayPackageBuilder{
    HolidayPackage holidayPackage = new HolidayPackage();

    public void buildFlight(){
        holidayPackage.setFlight("Economy Flight");
    }
    public void buildHotel(){
        holidayPackage.setHotel("Mountain Cabin");
    }
    public void buildDailyActivity(){
        holidayPackage.setDailyActivity("Hiking Tour");
    }

    public HolidayPackage getPackage(){return holidayPackage;}
}

class PackageDirector{
    HolidayPackageBuilder builder;
    public PackageDirector(HolidayPackageBuilder builder){
        this.builder = builder;
    }

    HolidayPackage buildPackage(){
        builder.buildDailyActivity();
        builder.buildFlight();
        builder.buildHotel();

        return builder.getPackage();
    }
}