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
        System.out.println(multiset.size());                                                                            // print 10
    }
}
