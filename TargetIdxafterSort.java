import java.util.ArrayList;
import java.util.List;

public class TargetIdxafterSort {
    public List<Integer> targetIndices(int[] nums, int target) {
        int low = 0;
        int equal = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == target) equal++;
            if(nums[i] < target) low++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < equal; i++) {
            res.add(low + i);
        }
        return res;
    }
}
