package dz3.dz2;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) { 
        // Создаем список 
        ArrayList<Integer> numbers = new ArrayList<>(); 
        numbers.add(10); 
        numbers.add(20); 
        numbers.add(30); 
        numbers.add(40); 
        numbers.add(50);

        // Находим минимальное значение
        int min = Collections.min(numbers);
        System.out.println("Минимальное значение: " + min);

        // Находим максимальное значение
        int max = Collections.max(numbers);
        System.out.println("Максимальное значение: " + max);

        // Вычисляем среднее арифметическое
        int sum = 0;
        for (Integer number : numbers) {
            sum += number.intValue();
        }
        double average = (double) sum / numbers.size();
        System.out.println("Среднее арифметическое: " + average);
    }
}
