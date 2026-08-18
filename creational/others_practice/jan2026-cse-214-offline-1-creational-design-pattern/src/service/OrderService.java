package service;

import model.DeliveryType;
import model.MenuItem;
import model.Order;
import model.OrderItem;
import model.PaymentMethod;
import model.Size;
import model.OrderBuilder;
import model.ConcreteOrderBuilder;
import model.OrderItemBuilder;
import model.ConcreteOrderItemBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Coordinates order creation.
 *
 * Several methods below repeat long Order constructor calls with many optional
 * parameters. That is intentional assignment material for refactoring.
 */
public class OrderService {
    private int nextNumber = 1001;

    public OrderItem createOrderItem(MenuItem item, int quantity, Size size, boolean extraCheese, boolean spicy, String note) {
        OrderItemBuilder builder = new ConcreteOrderItemBuilder();
        builder.setMenuItem(item);
        builder.setQuantity(quantity);
        builder.setSize(size);
        builder.setExtraCheese(extraCheese);
        builder.setSpicy(spicy);
        builder.setNote(note);
        return builder.getProduct();
    }

    public Order createDeliveryOrder(String customerName,
                                     String phone,
                                     String address,
                                     List<OrderItem> items,
                                     String couponCode,
                                     boolean rushOrder,
                                     String specialInstructions) {
        OrderBuilder builder = new ConcreteOrderBuilder();
        builder.setOrderId(nextOrderId());
        builder.setCustomerInfo(customerName, phone);
        builder.setDeliveryType(DeliveryType.DELIVERY);
        builder.setDeliveryAddress(address);
        builder.setCouponCode(couponCode);
        builder.setRushOrder(rushOrder);
        builder.setItems(items);
        builder.setSpecialInstructions(specialInstructions);
        return builder.getProduct();
    }

    public Order createPickupOrder(String customerName, String phone, List<OrderItem> items) {
        OrderBuilder builder = new ConcreteOrderBuilder();
        builder.setOrderId(nextOrderId());
        builder.setCustomerInfo(customerName, phone);
        builder.setDeliveryType(DeliveryType.PICKUP);
        builder.setItems(items);

        return builder.getProduct();
    }

    public Order createScheduledGiftOrder(String customerName,
                                          String phone,
                                          String address,
                                          List<OrderItem> items,
                                          LocalDateTime scheduledTime) {
        /*nextOrderId(), customerName, phone,
                DeliveryType.DELIVERY,
                address,
                PaymentMethod.CARD,
                scheduledTime,
                "WELCOME10",
                true,
                false,
                25,
                false,
                items,
                "Please call before delivery");*/

        OrderBuilder builder = new ConcreteOrderBuilder();
        builder.setOrderId(nextOrderId());
        builder.setCustomerInfo(customerName, phone);
        builder.setDeliveryType(DeliveryType.DELIVERY);
        builder.setDeliveryAddress(address);
        builder.setPaymentMethod(PaymentMethod.CARD);
        builder.setScheduledTime(scheduledTime);
        builder.setCouponCode("WELCOME10");
        builder.setGiftWrap(true);
        builder.setCutleryRequired(false);
        builder.setLoyaltyPointsToRedeem(25);
        builder.setRushOrder(false);
        builder.setItems(items);
        builder.setSpecialInstructions("Please call before delivery");
        return builder.getProduct();
    }

    public Order createSampleFamilyOrder(MenuCatalog catalog) {
        List<OrderItem> items = new ArrayList<>();
        items.add(this.createOrderItem(catalog.findByCode("P01"), 2, Size.LARGE, true, false, "half spicy"));
        items.add(this.createOrderItem(catalog.findByCode("B02"), 3, Size.MEDIUM, true, true, ""));
        items.add(this.createOrderItem(catalog.findByCode("D02"), 4, Size.MEDIUM, false, false, "less sugar"));
        items.add(this.createOrderItem(catalog.findByCode("S02"), 2, Size.LARGE, false, true, ""));

        /*  Order(nextOrderId(),
                "Sample Family",
                "01711111111",
                DeliveryType.DELIVERY,
                "House 25, Road 4, Dhanmondi",
                PaymentMethod.MOBILE_BANKING,
                null,
                "FAMILY15",
                false,
                true,
                50,
                true,
                items,
                "Deliver together");*/

        OrderBuilder builder = new ConcreteOrderBuilder();
        builder.setOrderId(nextOrderId());
        builder.setCustomerInfo("Sample Family", "01711111111");
        builder.setDeliveryType(DeliveryType.DELIVERY);
        builder.setDeliveryAddress("House 25, Road 4, Dhanmondi");
        builder.setPaymentMethod(PaymentMethod.MOBILE_BANKING);
        builder.setCouponCode("FAMILY15");
        builder.setGiftWrap(false);
        builder.setCutleryRequired(true);
        builder.setLoyaltyPointsToRedeem(50);
        builder.setRushOrder(true);
        builder.setItems(items);
        builder.setSpecialInstructions("Deliver together");
        return builder.getProduct();
    }

    private String nextOrderId() {
        return "FF-" + nextNumber++;
    }
}

