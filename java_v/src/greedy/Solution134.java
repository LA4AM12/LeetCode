package greedy;

/**
 * @author : LA4AM12
 * @create : 2021-10-09 12:39:23
 * @description : 134_Gas Station
 */
public class Solution134 {
	public int canCompleteCircuit1(int[] gas, int[] cost) {
		int n = gas.length;
		int sum = 0;
		int tank = 0,start = 0;
		for (int i = 0; i < n; i++) {
			sum += gas[i] - cost[i];
			tank += gas[i] - cost[i];

			//tank < 0 denotes [start,i] must not be the first
			if (tank < 0){
				tank = 0;
				start = i + 1;
			}
		}
		return sum < 0 ? -1 : start;
	}
}
