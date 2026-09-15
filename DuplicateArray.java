import java.util.ArrayList;
import java.util.List;

public class DuplicateArray {
        public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while (i < nums.length) { 
        if (nums[i] == i + 1) { 
            i++; 
        } else { 
            int idx = nums[i] - 1; 
            if (nums[i] == nums[idx]) {
            i++;
        }else{
            int temp = nums[i]; 
            nums[i] = nums[idx]; 
            nums[idx] = temp; 
            }
        } 
    }
    for (i = 0; i < nums.length; i++) {
        if (nums[i] != i + 1) {
            ans.add(nums[i]);
        }
    }
    return ans;
    }
}
