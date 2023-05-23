public class Carport {

    private int carportId;
    private double width;
    private double length;
    private double height;
    private boolean shed;
    private Spaer spaer;
    private  Rem rem;
    private Stolpe stolpe;
    private Tag tag;

    public Carport(int carportId, double width, double length, double height, boolean shed,
                   Spaer spaer, Rem rem, Stolpe stolpe, Tag tag) {
        this.carportId = carportId;
        this.width = width;
        this.length = length;
        this.height = height;
        this.shed = shed;
        this.spaer = spaer;
        this.rem = rem;
        this.stolpe = stolpe;
        this.tag = tag;
    }

    public Carport( double width, double length, double height, boolean shed,
                    Spaer spaer, Rem rem, Stolpe stolpe, Tag tag) {

        this.width = width;
        this.length = length;
        this.height = height;
        this.shed = shed;
        this.spaer = spaer;
        this.rem = rem;
        this.stolpe = stolpe;
        this.tag = tag;
    }

    public Carport() {

    }

    public int getCarportId() {
        return carportId;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    public boolean isShed() {
        return shed;
    }

    public Spaer getSpaer() {
        return spaer;
    }

    public Rem getRem() {
        return rem;
    }

    public Stolpe getStolpe() {
        return stolpe;
    }

    public Tag getTag() {
        return tag;
    }
}
