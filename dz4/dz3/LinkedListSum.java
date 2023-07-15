package dz4.dz3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListSum {
    private LinkedList<Integer> list;

    public LinkedListSum() {
        list = new LinkedList<>();
    }

    public void addElement(int element) {
        list.add(element);
    }

    public int calculateSum() {
        int sum = 0;
        List<Integer> tempList = new LinkedList<>(list);
        Iterator<Integer> iterator = tempList.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        return sum;
    }
}
