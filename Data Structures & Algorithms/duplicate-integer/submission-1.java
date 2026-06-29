class Solution {
    public boolean hasDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i])) return true;
            set.add(arr[i]);
        }
        return false;
     }
}