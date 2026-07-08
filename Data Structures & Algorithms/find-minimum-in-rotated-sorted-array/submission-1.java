class Solution {
    public int findMin(int[] arr) {
        int min = arr[0];
        int start = 0;
        int end = arr.length-1;
        while(start <= end) {
            int mid = (start + end)/2;
            if(arr[start] < arr[end]){
                min = Math.min(min,arr[start]);
                break;
            }
            min = Math.min(min,arr[mid]);
            if(arr[mid]>=arr[start]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return min;
    }
}
