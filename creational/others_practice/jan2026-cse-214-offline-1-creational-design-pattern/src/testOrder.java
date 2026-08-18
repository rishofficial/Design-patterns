import model.*;

public class testOrder {
    public static void main(String[] args) {
        ConcreteOrderBuilder builder = new ConcreteOrderBuilder();
        
        //builder.getProduct();

        ConcreteOrderItemBuilder itemBuilder = new ConcreteOrderItemBuilder();
        itemBuilder.getProduct();
    }
}
