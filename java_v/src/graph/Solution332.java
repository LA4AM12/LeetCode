package graph;

import java.util.*;

/**
 * @author : LA4AM12
 * @create : 2022-01-11 21:53:54
 * @description : Reconstruct Itinerary
 */

// Eulerian Circuit
public class Solution332 {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> ans = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dest = ticket.get(1);
            graph.putIfAbsent(src, new PriorityQueue<>());
            graph.get(src).offer(dest);
        }
        dfs("JFK");
        Collections.reverse(ans);
        return ans;
    }

    private void dfs(String departure) {
        while (!graph.containsKey(departure) || !graph.get(departure).isEmpty()) {
            // remove the edge
            dfs(graph.get(departure).poll());
        }
        ans.add(departure);
    }
}
