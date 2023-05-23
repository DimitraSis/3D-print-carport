public class Stolpe {

    private int stolpeId;
    private String stolpeName;
    private double length;
    private int price;
    private int quantity;

    public Stolpe(int stolpeId, String stolpeName, double length, int price, int quantity) {
        this.stolpeId = stolpeId;
        this.stolpeName = stolpeName;
        this.length = length;
        this.price = price;
        this.quantity = quantity;
    }
    public Stolpe() {

    }

    public int getStolpeId() {
        return stolpeId;
    }

    public String getStolpeName() {
        return stolpeName;
    }

    public double getLength() {
        return length;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
