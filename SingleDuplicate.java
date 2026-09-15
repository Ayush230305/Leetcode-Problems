public class SingleDuplicate {

    public int findDuplicate(int[] nums) {

        int i = 0;

        while (i < nums.length) {

            if (nums[i] == i + 1) {
                i++;
            } else {

                int idx = nums[i] - 1;

                if (nums[i] == nums[idx]) {
                    i++;
                } else {

                    int temp = nums[i];
                    nums[i] = nums[idx];
                    nums[idx] = temp;
                }
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return nums[i];
            }
        }

        return -1;
    }
}