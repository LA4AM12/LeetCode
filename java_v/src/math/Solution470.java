package math;

import java.util.Random;

/**
 * @author : LA4AM12
 * @create : 2021-12-13 17:01:05
 * @description : Implement Rand10() Using Rand7()
 */
public class Solution470 {
	public int rand7(){
		return new Random().nextInt(7) + 1;
	};
	public int rand10() {
		while (true) {
			int n = (rand7() - 1) * 7 + rand7();
			if(n > 40 && (n = (n - 41) * 7 + rand7()) > 60)
				continue;
			return n % 10 + 1;
		}
	}
}
