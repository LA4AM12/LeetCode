package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : LA4AM12
 * @create : 2022-01-24 15:19:57
 * @description : Minimum Number of Arrows to Burst Balloons
 */
public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int shoot = 1;
        int x = points[0][1];   // shoot point

        for (int i = 1; i < points.length; i++) {
            if (x < points[i][0]) {
                x = points[i][1];
                shoot++;
            }
        }

        return shoot;
    }
}
