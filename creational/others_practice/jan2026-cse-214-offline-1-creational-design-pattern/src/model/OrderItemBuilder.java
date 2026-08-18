package model;

public interface OrderItemBuilder {
    void setMenuItem(MenuItem menuItem);
    void setQuantity(int quantity);
    void setSize(Size size);
    void setExtraCheese(boolean extraCheese);
    void setSpicy(boolean spicy);
    void setNote(String note);
    OrderItem getProduct();
}
