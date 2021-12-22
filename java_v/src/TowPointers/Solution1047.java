package TowPointers;

/**
 * @author : LA4AM12
 * @create : 2021-12-22 11:13:16
 * @description : Remove All Adjacent Duplicates In String
 */
public class Solution1047 {
	public String removeDuplicates(String s) {
		char[] ss = s.toCharArray();
		int slow = 0, fast = 0;

		while (fast < ss.length) {
			ss[slow] = ss[fast];
			if (slow > 0 && ss[slow] == ss[slow -1])
				slow--;
			else
				slow++;
			fast++;
		}

		return new String(ss,0,slow);
	}
}
