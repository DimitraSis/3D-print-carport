public class Spaer {

    private int spaerId;
    private String spaerName;
    private double length;
    private int price;
    private int quantity;

    public Spaer(int spaerId, String spaerName, double length, int price, int quantity) {
        this.spaerId = spaerId;
        this.spaerName = spaerName;
        this.length = length;
        this.price = price;
        this.quantity = quantity;
    }

    public Spaer() {

    }

    public int getSpaerId() {
        return spaerId;
    }

    public String getSpaerName() {
        return spaerName;
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
