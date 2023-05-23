public class Rem {
    private int remId;
    private String remName;
    private double length;
    private int price;
    private int quantity;

    public Rem(int remId, String remName, double length, int price, int quantity) {
        this.remId = remId;
        this.remName = remName;
        this.length = length;
        this.price = price;
        this.quantity = quantity;
    }

    public Rem() {

    }

    public int getRemId() {
        return remId;
    }

    public String getRemName() {
        return remName;
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
