package char13.treeSet;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 10:59.
 */
public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster",1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem", 99112));
        System.out.println(parts);

        SortedSet<Item> sortByDescripton = new TreeSet<>(new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                String descrA = a.getDescription();
                String descrB = b.getDescription();
                return descrA.compareTo(descrB);
            }
        });

        sortByDescripton.addAll(parts);
        System.out.println(sortByDescripton);
    }
}
