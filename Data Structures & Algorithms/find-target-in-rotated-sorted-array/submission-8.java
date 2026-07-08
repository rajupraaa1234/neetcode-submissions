class Solution {
    // public int binarySearch(int start,int end,int target,int arr[]){
    //     while(start<end){
    //         int mid = (start + end)/2;
    //         if(arr[mid] == target) return mid;
    //         if(arr[mid] > target){
    //             end = mid - 1;
    //         }else{
    //             start = mid + 1;
    //         }
    //     }
    //     return -1;
    // }

    public static int binarySearch(int start,int last,int k,int arr[])
    {
        if(start>last)
            return -1;
        int mid=(start+last)/2;
        if(arr[mid]>k)
            return binarySearch(start,mid-1,k,arr);
        else if(arr[mid]<k)
            return binarySearch(mid+1,last,k,arr);
        return mid;
            
    }
    public int search(int[] arr, int target) {
        int n = arr.length;
        int start = 0;
        int end = n-1;
        // while(start < end) {
        //     int mid = (start + end)/2;
        //     if(arr[mid]>arr[end]){
        //         start = mid + 1;
        //     }else{
        //         end = mid;
        //     }
        // }

         while(start<=end){
            int mid = (start + end)/2;
            if(arr[mid]>=arr[0]){
                start = mid+1;
            }else{
                end = mid - 1;
            }
        }
        int pivote = start;
        // if(arr[pivote] == target) return pivote;
        // System.out.println(pivote);
        // int firstSearch = binarySearch(0,pivote,target,arr);
        // int secondSerch = binarySearch(pivote,n,target,arr);
        // if(firstSearch != -1){
        //     return firstSearch;
        // }
        // if(secondSerch != -1){
        //     return secondSerch;
        // }

        int first = binarySearch(0,pivote-1,target,arr);
        int second = binarySearch(pivote,arr.length-1,target,arr);
        if(first == -1 && second == -1) return -1;
        if(first != -1) return first;
        return second;
        //return -1;
    }
}
