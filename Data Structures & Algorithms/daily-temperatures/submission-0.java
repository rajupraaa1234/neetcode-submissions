class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            int count = 0;
            boolean warmer = false;
            for(int j=i+1;j<n;j++){
                if(arr[i]<arr[j]){
                    count++;
                    warmer = true;
                    break;
                }
                 count++;
            }
            if(warmer)
              ans[i] = count;
        }
        return ans;
    }
}
