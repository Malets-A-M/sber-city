import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List <City> cities = new ArrayList<>();
        String [] city;
        Scanner scanner = new Scanner(new File("Задача ВС Java Сбер.csv"));
        while (scanner.hasNext()) {
            city = scanner.nextLine().split(";");
            if (city.length == 6) cities.add(new City(city[1], city[2], city[3], Integer.parseInt(city[4]), city[5]));
            else cities.add(new City(city[1], city[2], city[3], Integer.parseInt(city[4]), null));
        }

        cities.sort(Comparator.comparing(City::getName));
        System.out.println("\n----------< Сортировка списка городов по наименованию >----------\n" +
                cities + "\n=================================================================\n");

        cities.sort((o1, o2) -> {
            if (o1.getDistrict().equals(o2.getDistrict())) {
                return o1.getName().compareTo(o2.getName());
            } else {
                return o1.getDistrict().compareTo(o2.getDistrict());
            }
        });

        System.out.println("\n----------< Сортировка списка городов по федеральному округу и наименованию города внутри каждого федерального округа >----------\n" +
                cities + "\n=================================================================\n");
    }
}
