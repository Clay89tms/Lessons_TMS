package idCarsServlet;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IdCarsMap {

    private static Map<String, CarCreate> mapCar = new HashMap<>();
    private static List<CarCreate> carCreateList = new ArrayList<>();

    public static List<CarCreate> takeCarList() {
        return carCreateList;
    }

    public static void add(CarCreate carCreate) {
        carCreateList.add(carCreate);
    }

    public IdCarsMap() {
    }

    public static Map<String, CarCreate> takeAllCar() {
        return mapCar;
    }

    public static void putNewCar(String id, CarCreate carCreate) {
        mapCar.put(id, carCreate);
    }

    public static void deleteCarById(String id) {
        mapCar.remove(id);
    }


    public static String carCreateToString(CarCreate carCreateS) {
        return "id = " + carCreateS.getId() + ";  type = "
                + carCreateS.getType() + ";  color = "
                + carCreateS.getColor() + ";  price = "
                + carCreateS.getPrice();
    }
}
