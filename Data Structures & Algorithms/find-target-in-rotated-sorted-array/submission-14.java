class Solution {
    public int binarySearch(int start,int end,int target,int arr[]){
        while(start<=end){
            int mid = (start + end)/2;
            if(arr[mid] == target) return mid;
            if(arr[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }

    public int search(int[] arr, int target) {
        int n = arr.length;
        int start = 0;
        int end = n-1;
        while(start < end) {
            int mid = (start + end)/2;
            if(arr[mid]>arr[end]){
                start = mid + 1;
            }else{
                end = mid;
            }
        }

        int pivote = start;
        int first = binarySearch(0,pivote-1,target,arr);
        int second = binarySearch(pivote,arr.length-1,target,arr);
        if(first == -1 && second == -1) return -1;
        if(first != -1) return first;
        return second;
    }
}
