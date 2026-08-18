package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConcreteOrderBuilder implements OrderBuilder{
    private String orderId;
    private String customerName;
    private String phone;
    private DeliveryType deliveryType;
    private String deliveryAddress;
    private PaymentMethod paymentMethod;
    private LocalDateTime scheduledTime;
    private String couponCode;
    private boolean giftWrap;
    private boolean cutleryRequired;
    private int loyaltyPointsToRedeem;
    private boolean rushOrder;
    private List<OrderItem> items;
    private String specialInstructions;

    public ConcreteOrderBuilder() {
        reset();
    }

    @Override
    public void reset() {
        orderId = null;
        customerName = null;
        phone = null;
        deliveryType = DeliveryType.PICKUP;
        deliveryAddress = "";
        paymentMethod = PaymentMethod.CASH;
        scheduledTime = null;
        couponCode = "";
        giftWrap = false;
        cutleryRequired = true;
        loyaltyPointsToRedeem = 0;
        rushOrder = false;
        items = new ArrayList<OrderItem>();
        specialInstructions = "";
    }

    @Override
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public void setCustomerInfo(String customerName, String phone) {
        this.customerName = customerName;
        this.phone = phone;
    }

    @Override
    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    @Override
    public void setDeliveryAddress(String address) {    
        this.deliveryAddress = address;
    }   

    @Override
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public void setScheduledTime(LocalDateTime time) {
        this.scheduledTime = time;
    }

    @Override
    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }   

    @Override
    public void setGiftWrap(boolean giftWrap) {
        this.giftWrap = giftWrap;
    }

    @Override
    public void setCutleryRequired(boolean cutlery) {
        this.cutleryRequired = cutlery;
    }

    @Override
    public void setLoyaltyPointsToRedeem(int loyaltyPoints) {  
        this.loyaltyPointsToRedeem = loyaltyPoints;
    }

    @Override
    public void setRushOrder(boolean rushOrder) {
        this.rushOrder = rushOrder;
    }

    @Override
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    @Override
    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public Order getProduct() {
        Order product = new Order(orderId, customerName, phone, deliveryType, deliveryAddress, paymentMethod,
                scheduledTime, couponCode, giftWrap, cutleryRequired, loyaltyPointsToRedeem,
                rushOrder, items, specialInstructions);
        reset();
        return product;
    }
}
