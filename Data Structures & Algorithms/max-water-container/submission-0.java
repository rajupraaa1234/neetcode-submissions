class Solution {
    public int maxArea(int[] arr) {
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = 0;
        int max = 0;
        for(int i=1;i<n;i++){
            left[i] = arr[left[i-1]] >= arr[i] ? left[i-1] : i;
        }
        right[n-1] = n-1;
        for(int i=n-2;i>=0;i--){
            right[i] = arr[right[i+1]] >= arr[i] ? right[i+1] : i;
        }
        for(int i=0;i<n;i++){
            int area = Math.abs(right[i]-left[i]) * Math.min(arr[left[i]],arr[right[i]]);
            max = Math.max(max,area);
        }
        return max;
    }
}
