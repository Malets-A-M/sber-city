import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<City> cities = new ArrayList<>();
        String[] city;
        Scanner scanner = new Scanner(new File("Задача ВС Java Сбер.csv"));
        while (scanner.hasNext()) {
            city = scanner.nextLine().split(";");
            if (city.length == 6) cities.add(new City(city[1], city[2], city[3], Integer.parseInt(city[4]), city[5]));
            else cities.add(new City(city[1], city[2], city[3], Integer.parseInt(city[4]), null));
        }


        Map<String, Integer> amountCities = new HashMap<>();
        for (var cityOfCities : cities) {
            if (!amountCities.containsKey(cityOfCities.getRegion())) {
                amountCities.put(cityOfCities.getRegion(), 1);
            } else {
                amountCities.put(cityOfCities.getRegion(), amountCities.remove(cityOfCities.getRegion()) + 1);
            }
        }
        for (var key : amountCities.keySet()) {
            System.out.println(key + " - " + amountCities.get(key));
        }
    }
}
