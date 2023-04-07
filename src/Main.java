import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

        int index = 0;
        int population = 0;
        City [] arrayCities = cities.toArray(new City[0]);
        for (var i = 0; i < arrayCities.length; i++) {
            if (population < arrayCities[i].getPopulation()) {
                index = i;
                population = arrayCities[i].getPopulation();
            }
        }
        System.out.println("[" + index + "] = " + population);
    }
}
