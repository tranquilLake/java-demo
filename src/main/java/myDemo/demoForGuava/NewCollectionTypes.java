package myDemo.demoForGuava;

import com.google.common.collect.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.*;

/**
 * New collection type added by guava library.
 * guava newlly added collection work good together with jdk collection abstractions.
 */
public class NewCollectionTypes {
    public static void main(String[] args) {
        // Multiset

        // The traditional java idiom for word counting is something like
        String[] words = new String[]{"a", "b", "c", "d", "b", "c", "d", "c", "d", "d"};
        Map<String, Integer> countsByMap = new HashMap<>();

        for (String word : words) {
            if (word == null) {
                continue;
            } else if (countsByMap.get(word) == null) {
                countsByMap.put(word, 1);
            } else {
                int added = countsByMap.get(word) + 1;
                countsByMap.put(word, added);
            }
        }

        // This is awkward, prone to mistake.

        // Guava provides a new collection type: Multiset
        // In mathematics, as "a generalization of the notion of set in which members are allowed to appear more than once"
        // In multisets, the order of elements is irrelevant. So the multisets {a, a, b} and {a, b, a} are equal

        Multiset<String> multiset = HashMultiset.create();

        // Multisets just like:
        // ArrayList without an ordering constraint
        // Maps with elements and counts

        // add(E)
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("d");
        multiset.add("b");
        multiset.add("c");
        multiset.add("d");
        multiset.add("c");
        multiset.add("d");
        multiset.add("d");

        // iterator()
        for (String s : multiset) {
            System.out.print(s + " ");                                                                                  // print a b b c c c d d d d
        }
        System.out.println();

        // size()
        int size = multiset.size();
        System.out.println(size);                                                                                       // print 10

        // count(E)
        int count = multiset.count("d");
        System.out.println(count);                                                                                      // print 4

        // entrySet()
        for (Multiset.Entry<String> e : multiset.entrySet()) {                                                          // print:
            System.out.println(e);
        }
        // above oparation print:
        // a
        // b x 2
        // c x 3
        // d x 4

        // elementSet()
        for (String s : multiset.elementSet()) {
            System.out.println(s);
        }
        // above operation print:
        // a
        // b
        // c
        // d

        // remove(E, int)
        multiset.remove("d");
        System.out.println(multiset.count("d"));                                                                        // print 3
        multiset.remove("d", 2);
        System.out.println(multiset.count("d"));                                                                        // print 1

        // setCount(E, int)
        multiset.setCount("d", 4);
        System.out.println(multiset.count("d"));                                                                        // print 4
    }
}
