package leetcode.array;

import java.util.*;

public class LC_332_ReconstructItinerary {


    public static List<String> findItinerary(String[][] tickets) {
        List<String> res = new LinkedList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], v -> new PriorityQueue()).add(ticket[1]);
        }
        Stack<String> stack = new Stack<String>();
        stack.push("JFK");
        while(!stack.isEmpty()) {
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty())
                stack.push(map.get(stack.peek()).poll());
            res.add(0, stack.pop());
        }
        return res;
    }

    public static void main(String[] args) {
        String[][] tickets = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}, {"JFK", "ATL"}};
        List<String> list = findItinerary(tickets);
        list.forEach(s-> {
            System.out.println(s);
        });
    }
}
