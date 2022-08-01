import java.util.HashMap;

/**
 * @BelongsProject: thoughtful-code
 * @BelongsPackage: PACKAGE_NAME
 * @Author: msJava
 * @CreateTime: 2022-05-23  22:46
 * @Description: 剑指 Offer 03. 数组中重复的数字
 * @Version: 1.0
 */
public class Solution03 {

    public static int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return  nums[i];
            }
            map.put(nums[i],0);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,7,9,5,3};
        System.out.println(findRepeatNumber(nums));
    }


}
