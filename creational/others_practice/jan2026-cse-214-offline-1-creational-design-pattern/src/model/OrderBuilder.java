package model;

import java.time.LocalDateTime;
import java.util.*;
public interface OrderBuilder {
    void reset();

    void setOrderId(String orderId);

    void setCustomerInfo(String customerName, String phone);

    void setDeliveryType(DeliveryType deliveryType);

    void setDeliveryAddress(String address);

    void setPaymentMethod(PaymentMethod paymentMethod);

    void setScheduledTime(LocalDateTime time);

    void setCouponCode(String couponCode);
    void setGiftWrap(boolean giftWrap);
    void setCutleryRequired(boolean cutlery);
    void setLoyaltyPointsToRedeem(int loyaltyPoints);
    void setRushOrder(boolean rushOrder);
    void setItems(List<OrderItem> items);
    void setSpecialInstructions(String specialInstructions);

    Order getProduct();
}