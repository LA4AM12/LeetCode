package TowPointers;

/**
 * @author : LA4AM12
 * @create : 2021-11-23 10:55:29
 * @description : Trapping Rain Water
 */
public class Solution42 {
	public int trap(int[] height) {
		int ans = 0;
		int leftMax = 0, rightMax = 0;
		int l = 0, r = height.length - 1;

		while (l < r) {
			leftMax = Math.max(leftMax, height[l]);
			rightMax = Math.max(rightMax, height[r]);

			// we can say that if there is a larger bar at one end (say right),
			// we are assured that the water trapped would be dependent on smaller one (leftMax).
			if (leftMax < rightMax)
				ans += leftMax - height[l++];
			else
				ans += rightMax - height[r--];
		}

		return ans;
	}
}
