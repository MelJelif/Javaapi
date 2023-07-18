package dz5.dz1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            Set<String> numbers = phoneBook.get(name);
            numbers.add(phoneNumber);
        } else {
            Set<String> numbers = new HashSet<>();
            numbers.add(phoneNumber);
            phoneBook.put(name, numbers);
        }
    }

    public Set<String> getPhoneNumbers(String name) {
        return phoneBook.getOrDefault(name, new HashSet<>());
    }

    public void printPhoneBook() {
        for (String name : phoneBook.keySet()) {
            Set<String> numbers = phoneBook.get(name);
            System.out.println(name + ": " + numbers);
        }
    }
}
