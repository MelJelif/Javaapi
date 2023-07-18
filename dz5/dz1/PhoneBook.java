package dz5.dz1;

import java.util.*;

public class PhoneBook { private Map<String, List> phoneBook;

public PhoneBook() {
    phoneBook = new HashMap<>();
}

public void addContact(String name, String phone) {
    List<String> phones = phoneBook.getOrDefault(name, new ArrayList<>());
    phones.add(phone);
    phoneBook.put(name, phones);
}

public void printDuplicates() {
    Map<String, Integer> counts = new HashMap<>();

    for (List<String> phones : phoneBook.values()) {
        for (String phone : phones) {
            counts.put(phone, counts.getOrDefault(phone, 0) + 1);
        }
    }

    TreeMap<Integer, List<String>> sortedCounts = new TreeMap<>(Collections.reverseOrder());

    for (Map.Entry<String, Integer> entry : counts.entrySet()) {
        int count = entry.getValue();
        String phone = entry.getKey();

        List<String> phonesWithCount = sortedCounts.getOrDefault(count, new ArrayList<>());
        phonesWithCount.add(phone);
        sortedCounts.put(count, phonesWithCount);
    }

    for (Map.Entry<Integer, List<String>> entry : sortedCounts.entrySet()) {
        int count = entry.getKey();
        List<String> phones = entry.getValue();

        if (count > 1) {
            System.out.println("Duplicate phones (count: " + count + "): " + phones);
        }
    }
}

public static void main(String[] args) {
    PhoneBook phoneBook = new PhoneBook();
    phoneBook.addContact("Иван Иванов", "111-111-111");
    phoneBook.addContact("Светлана Петрова", "222-222-222");
    phoneBook.addContact("Кристина Белова", "333-333-333");
    phoneBook.addContact("Анна Мусина", "444-444-444");
    phoneBook.addContact("Анна Крутова", "555-555-555");
    phoneBook.addContact("Иван Юрин", "111-111-111");
    phoneBook.addContact("Петр Лыков", "222-222-222");
    phoneBook.addContact("Павел Чернов", "333-333-333");
    phoneBook.addContact("Петр Чернышов", "444-444-444");
    phoneBook.addContact("Мария Федорова", "555-555-555");
    phoneBook.addContact("Марина Светлова", "111-111-111");
    phoneBook.addContact("Мария Савина", "222-222-222");
    phoneBook.addContact("Мария Рыкова", "333-333-333");
    phoneBook.addContact("Марина Лугова", "444-444-444");
    phoneBook.addContact("Анна Владимирова", "555-555-555");
    phoneBook.addContact("Иван Мечников", "111-111-111");
    phoneBook.addContact("Петр Петин", "222-222-222");
    phoneBook.addContact("Иван Ежов", "333-333-333");

    phoneBook.printDuplicates();
}


}