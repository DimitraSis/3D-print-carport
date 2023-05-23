public class Tag {
    private int tagId;
    private String tagName;
    private double length;
    private int price;
    private int quantity;

    public Tag(int tagId, String tagName, double length, int price, int quantity) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.length = length;
        this.price = price;
        this.quantity = quantity;
    }

    public Tag() {

    }

    public int getTagId() {
        return tagId;
    }

    public String getTagName() {
        return tagName;
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
