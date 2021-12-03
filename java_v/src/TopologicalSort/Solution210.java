package TopologicalSort;

import java.util.*;

/**
 * @author : LA4AM12
 * @create : 2021-12-02 11:06:29
 * @description : Course Schedule II
 */
public class Solution210 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> adjacency = new HashMap<>();
		int[] indegree = new int[numCourses];

		for (int[] prerequisite : prerequisites) {
			int src = prerequisite[1];
			int dist = prerequisite[0];

			// Record in-degree of each vertex
			indegree[dist]++;

			// Create the adjacency list representation of the graph
			adjacency.putIfAbsent(src, new ArrayList<>());
			adjacency.get(src).add(dist);
		}

		Queue<Integer> queue = new LinkedList<>();
		int[] order = new int[numCourses];

		// Add all vertices with 0 in-degree to the queue
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0)
				queue.offer(i);
		}

		int n = 0;
		// Process until the Q becomes empty
		while (!queue.isEmpty()) {
			int node = queue.poll();
			order[n++] = node;
			// Reduce the in-degree of each neighbor by 1
			if (adjacency.containsKey(node)) {
				for (Integer i : adjacency.get(node)) {
					// If in-degree of a neighbor becomes 0, add it to the Q
					if (--indegree[i] == 0)
						queue.offer(i);
				}
			}
		}

		// Check to see if topological sort is possible or not.
		if (n == numCourses) return order;
		return new int[0];
	}
}
