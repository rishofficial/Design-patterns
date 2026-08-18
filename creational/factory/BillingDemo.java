/**
 * Case Study 3: Electricity Billing Plan Factory
 * Reference: Slides 9, 10, and 11 in slide.md
 * 
 * Demonstrates the Factory Method pattern for electricity billing calculations across different plan types.
 */

// Abstract Product
abstract class Plan {
    protected double rate;

    abstract void getRate();

    public void calculateBill(int units) {
        System.out.println("Bill Amount: $" + String.format("%.2f", (units * rate)));
    }
}

// Concrete Product 1: Domestic Plan
class DomesticPlan extends Plan {
    @Override
    public void getRate() {
        rate = 3.50;
    }
}

// Concrete Product 2: Commercial Plan
class CommercialPlan extends Plan {
    @Override
    public void getRate() {
        rate = 7.50;
    }
}

// Concrete Product 3: Institutional Plan
class InstitutionalPlan extends Plan {
    @Override
    public void getRate() {
        rate = 5.50;
    }
}

// Factory Class
class GetPlanFactory {

    // Use getPlan method to get object of type Plan
    public Plan getPlan(String planType) {
        if (planType == null) {
            return null;
        }
        if (planType.equalsIgnoreCase("DOMESTICPLAN")) {
            return new DomesticPlan();
        } else if (planType.equalsIgnoreCase("COMMERCIALPLAN")) {
            return new CommercialPlan();
        } else if (planType.equalsIgnoreCase("INSTITUTIONALPLAN")) {
            return new InstitutionalPlan();
        }
        return null;
    }
}

// Client Demo Class (GenerateBill)
public class BillingDemo {

    public static void main(String[] args) {
        GetPlanFactory planFactory = new GetPlanFactory();

        System.out.println("=== Electricity Billing Factory Demo ===");

        // Test Domestic Plan
        String planName1 = "DOMESTICPLAN";
        int units1 = 150;
        Plan p1 = planFactory.getPlan(planName1);
        System.out.print("Bill for " + planName1 + " (" + units1 + " units): ");
        p1.getRate();
        p1.calculateBill(units1);

        // Test Commercial Plan
        String planName2 = "COMMERCIALPLAN";
        int units2 = 500;
        Plan p2 = planFactory.getPlan(planName2);
        System.out.print("Bill for " + planName2 + " (" + units2 + " units): ");
        p2.getRate();
        p2.calculateBill(units2);

        // Test Institutional Plan
        String planName3 = "INSTITUTIONALPLAN";
        int units3 = 300;
        Plan p3 = planFactory.getPlan(planName3);
        System.out.print("Bill for " + planName3 + " (" + units3 + " units): ");
        p3.getRate();
        p3.calculateBill(units3);
    }
}
