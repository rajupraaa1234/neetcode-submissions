class Solution {
    public int[] twoSum(int[] nums, int target) {
        int currentSum = target;
        int start = -1;
        int end = -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
           map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int rest = target-nums[i];
            if(map.containsKey(rest) && i!=map.get(rest) ){
                return new int[]{i,map.get(rest)};
            }
        }
        return new int[]{-1,-1};
    }
}
