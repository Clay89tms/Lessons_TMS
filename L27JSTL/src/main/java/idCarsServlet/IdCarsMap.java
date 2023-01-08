package idCarsServlet;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IdCarsMap {

    private static Map<String, CarCreate> mapCar = new HashMap<>();

    private String id;

    public IdCarsMap() {
    }

    public IdCarsMap(String id) {
        this.id = id;
    }

    public static Map<String, CarCreate> getMapCar() {
        return mapCar;
    }

    public static void setMapCar(String id, CarCreate carCreate) {
        mapCar.put(id, carCreate);
    }

    public static void deleteCarMap(String id) {
        mapCar.remove(id);
    }


    public static String carCreateSearch(CarCreate carCreateS) {
        return "id = " + carCreateS.getId() + ";  type = "
                + carCreateS.getType() + ";  color = "
                + carCreateS.getColor() + ";  price = "
                + carCreateS.getPrice();
    }
}
