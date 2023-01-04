package idCarsServlet;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IdCarsMap {

    private static Map<String, CarCreate> mapCar = new HashMap<>();

    String id;

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

    public static CarCreate carCreateSearch(String id) {
        Map<String, CarCreate> mapCar = getMapCar();
        List<String> list1 = new ArrayList<>();
        list1.addAll(mapCar.keySet());
        boolean b = true;
        CarCreate carCreateS = new CarCreate();
        for (int i = 0; i < list1.size(); i++) {
            if ((b) && (id.equals(list1.get(i)))) {
                carCreateS = mapCar.get(list1.get(i));
                b = false;
            }

        }
        return carCreateS;
    }


    @Override
    public String toString() {
        return "to String&&&???";
    }
}
