package idCarsServlet;

public class CarCreate {
    String id;
    String type;
    String color;
    String price;

    public CarCreate(String id, String type, String color, String price) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.price = price;
    }

    public CarCreate() {
    }
    public String getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public String getColor() {
        return color;
    }
    public String getPrice() {
        return price;
    }


}
