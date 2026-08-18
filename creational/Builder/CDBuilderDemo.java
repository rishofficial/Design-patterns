import java.util.ArrayList;
import java.util.List;

// Packing interface
interface Packing {
    public String pack();
    public int price();
}

// Create an abstract class CD which will implement Packing interface.
abstract class CD implements Packing {
    public abstract String pack();
}

// Create an abstract class Company extending CD
abstract class Company extends CD {
    public abstract int price();
}

// Concrete class Sony
class Sony extends Company {
    @Override
    public int price() {
        return 20;
    }

    @Override
    public String pack() {
        return "Sony CD";
    }
}

// Concrete class Samsung
class Samsung extends Company {
    @Override
    public int price() {
        return 15;
    }

    @Override
    public String pack() {
        return "Samsung CD";
    }
}

// CDType class
class CDType {
    private List<Packing> items = new ArrayList<Packing>();

    public void addItem(Packing packs) {
        items.add(packs);
    }

    public void getCost() {
        for (Packing packs : items) {
            packs.price();
        }
    }

    public void showItems() {
        for (Packing packing : items) {
            System.out.print("CD name : " + packing.pack());
            System.out.println(", Price : " + packing.price());
        }
    }
}

// CDBuilder class
class CDBuilder {
    public CDType buildSonyCD() {
        CDType cds = new CDType();
        cds.addItem(new Sony());
        return cds;
    }

    public CDType buildSamsungCD() {
        CDType cds = new CDType();
        cds.addItem(new Samsung());
        return cds;
    }
}

// Runnable Client Wrapper Class matching slide 47 BuilderDemo exact implementation
public class CDBuilderDemo {
    public static void main(String args[]) {
        CDBuilder cdBuilder = new CDBuilder();

        CDType cdType1 = cdBuilder.buildSonyCD();
        cdType1.showItems();

        CDType cdType2 = cdBuilder.buildSamsungCD();
        cdType2.showItems();
    }
}
