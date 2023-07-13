package dz3.dz3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Создаем список планет
        List<String> planets = new ArrayList<>();
        planets.add("Меркурий");
        planets.add("Венера");
        planets.add("Земля");
        planets.add("Марс");
        planets.add("Юпитер");
        planets.add("Сатурн");
        planets.add("Уран");
        planets.add("Нептун");
        planets.add("Марс"); // Пример повторения
        planets.add("Меркурий");
        planets.add("Венера");
        planets.add("Земля");
        planets.add("Юпитер");
        planets.add("Юпитер");
        planets.add("Юпитер");

        // Создаем Map для хранения количества повторений каждой планеты
        Map<String, Integer> planetFrequencyMap = new HashMap<>();

        // Считаем количество повторений для каждой планеты
        for (String planet : planets) {
            int frequency = Collections.frequency(planets, planet);
            planetFrequencyMap.put(planet, frequency);
        }

        // Выводим название планеты и количество ее повторений в списке
        for (Map.Entry<String, Integer> entry : planetFrequencyMap.entrySet()) {
            String planet = entry.getKey();
            int frequency = entry.getValue();
            System.out.println("Планета: " + planet + ", Количество повторений: " + frequency);
        }
    }
}
