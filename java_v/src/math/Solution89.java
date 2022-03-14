package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LA4AM12
 * @create : 2022-03-14 10:59:57
 * @description : Gray Code
 */
public class Solution89 {
	public List<Integer> grayCode(int n) {
		List<Integer> list = new ArrayList<>() {{add(0);}};
		int head = 1;
		for (int i = 0; i < n; i++) {
			for (int j = list.size()-1; j >= 0; j--)
				list.add(head + list.get(j));
			head <<= 1;
		}
		return list;
	}
}
