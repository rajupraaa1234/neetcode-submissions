class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int max = 0;
        for(int i=0;i<nums.length;i++){
            int start = nums[i];
            int length = 0;
            while(set.contains(start++)){
                length++;
                max = Math.max(max,length);
            }
        }

        return max;
    }
}
