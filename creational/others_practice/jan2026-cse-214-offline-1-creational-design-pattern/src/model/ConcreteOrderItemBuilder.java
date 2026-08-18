package model;

public class ConcreteOrderItemBuilder implements OrderItemBuilder {
    private MenuItem menuItem;
    private int quantity;
    private Size size;
    private boolean extraCheese;
    private boolean spicy;
    private String note;
    void reset(){
        menuItem = null;
        quantity = -1;
        size = Size.MEDIUM;
        extraCheese = false;
        spicy = false;
        note = "";
    }

    public ConcreteOrderItemBuilder() {
        reset();
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public OrderItem getProduct() {
        OrderItem product = new OrderItem(menuItem, quantity, size, extraCheese, spicy, note);
        reset();
        return product;
    }
}
