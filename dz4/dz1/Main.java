package dz4.dz1;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        
        LinkedList<Integer> reversedLinkedList = reverseLinkedList(linkedList);
        System.out.println(reversedLinkedList);
    }

    public static <T> LinkedList<T> reverseLinkedList(LinkedList<T> linkedList) {
        LinkedList<T> reversedList = new LinkedList<>();
        for (T item : linkedList) {
            reversedList.addFirst(item);
        }
        return reversedList;
    }
}
