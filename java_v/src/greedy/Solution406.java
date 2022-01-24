package greedy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author : LA4AM12
 * @create : 2022-01-24 14:16:14
 * @description : Queue Reconstruction by Height
 */
public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });

        LinkedList<int[]> queue = new LinkedList<>();

        // 依次插入，满足队列属性
        for (int[] person : people) {
            queue.add(person[1], person);
        }

        return queue.toArray(new int[][]{});
    }
}
