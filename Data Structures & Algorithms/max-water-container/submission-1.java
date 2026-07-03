class Solution {
    public int maxArea(int[] arr) {
        int n = arr.length;
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int area = (j-i) * Math.min(arr[j],arr[i]);
                max = Math.max(max,area);
            }
        }
        return max;
    }
}
