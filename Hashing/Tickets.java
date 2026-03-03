/*
Problem:
Given a set of airline tickets represented as a HashMap where
key = source city and value = destination city,
each city appears exactly once as a source except the final destination.

We need to print the complete journey in order.

Core Idea:
The journey forms a linear chain (like a linked list).
One city will never appear as a destination — that city is the starting point.

Approach:
1. Create a reverse map (destination -> source).
2. The start city is the one that does NOT appear in the reverse map.
3. From the start city, keep following the original map to print the route.

Time Complexity: O(n)
Space Complexity: O(n)

Concepts Used:
- HashMap
- Graph (implicit directed path)
- Reverse mapping technique
*/

import java.util.*;

public class Tickets { // O(n)
    public static String getStart(HashMap<String, String> tic) {
        HashMap<String, String> revMap = new HashMap<>();
        for (String key : tic.keySet()) {
            revMap.put(tic.get(key), key);
        }
        for (String key : tic.keySet()) {
            if (!revMap.containsKey(key))
                return key;
        }

        return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> tic = new HashMap<>();
        tic.put("Chennai", "Bengaluru");
        tic.put("Mumbai", "Delhi");
        tic.put("Goa", "Chennai");
        tic.put("Delhi", "Goa");

        String start = getStart(tic);
        System.out.print(start);
        for (String key : tic.keySet()) {
            System.out.print("-> " + tic.get(start));
            start = tic.get(start);
        }

    }
}
