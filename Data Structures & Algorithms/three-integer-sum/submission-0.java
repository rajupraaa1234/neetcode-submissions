class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0) break;
            int start = i + 1;
            int end = arr.length - 1;
            while(start < end) {
                int sum = arr[i] + arr[start] + arr[end];
                if(sum < 0) {
                    start++;
                }else if (sum > 0){
                    end--;
                }else{
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(arr[i]);
                    temp.add(arr[start]);
                    temp.add(arr[end]);
                    if(!res.contains(temp)){
                       res.add(temp);
                    }
                    start++;
                    end--;
                }
            }
        }
        return res;
    }
}
