package dz6.dz;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Lenovo", 8, 500, "Windows", "Black"));
        laptops.add(new Laptop("HP", 16, 1000, "Windows", "Silver"));
        laptops.add(new Laptop("Dell", 8, 1000, "Linux", "Black"));
        laptops.add(new Laptop("Apple", 16, 500, "macOS", "Silver"));

        Map<Integer, Object> filters = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Введите минимальное значение ОЗУ:");
                int minRam = scanner.nextInt();
                scanner.nextLine();
                filters.put(1, minRam);
                break;
            case 2:
                System.out.println("Введите минимальный объем ЖД:");
                int minStorageSize = scanner.nextInt();
                scanner.nextLine();
                filters.put(2, minStorageSize);
                break;
            case 3:
                System.out.println("Введите операционную систему:");
                String os = scanner.nextLine();
                filters.put(3, os);
                break;
            case 4:
                System.out.println("Введите цвет:");
                String color = scanner.nextLine();
                filters.put(4, color);
                break;
            default:
                System.out.println("Некорректный выбор.");
                return;
        }

        Set<Laptop> filteredLaptops = filterLaptops(laptops, filters);

        if (filteredLaptops.isEmpty()) {
            System.out.println("Ноутбуки по заданным критериям не найдены.");
        } else {
            System.out.println("Найденные ноутбуки:");
            for (Laptop laptop : filteredLaptops) {
                System.out.println("Бренд: " + laptop.getBrand());
                System.out.println("ОЗУ: " + laptop.getRam() + " ГБ");
                System.out.println("Объем ЖД: " + laptop.getStorageSize() + " ГБ");
                System.out.println("Операционная система: " + laptop.getOs());
                System.out.println("Цвет: " + laptop.getColor());
                System.out.println();
            }
        }
    }

    public static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<Integer, Object> filters) {
    Set<Laptop> filteredLaptops = new HashSet<>();

    for (Laptop laptop : laptops) {
        boolean meetsCriteria = true;

        for (Map.Entry<Integer, Object> entry : filters.entrySet()) {
            int key = entry.getKey();
            Object value = entry.getValue();

            switch (key) {
                case 1:
                    int minRam = (int) value;
                    if (laptop.getRam() < minRam) {
                        meetsCriteria = false;
                    }
                    break;
                case 2:
                    int minStorageSize = (int) value;
                    if (laptop.getStorageSize() < minStorageSize) {
                        meetsCriteria = false;
                    }
                    break;
                case 3:
                    String os = (String) value;
                    if (!laptop.getOs().equalsIgnoreCase(os)) {
                        meetsCriteria = false;
                    }
                    break;
                // Add more cases for other filter keys if needed

                default:
                    break;
            }
        }

        if (meetsCriteria) {
            filteredLaptops.add(laptop);
        }
    }

    return filteredLaptops;
}
}
