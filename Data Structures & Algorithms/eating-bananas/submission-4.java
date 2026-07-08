class Solution {
    public boolean isValid(int arr[],long k,int h){
        long count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=k){
                count++;
            }else{
                long rem = arr[i]%k;
                if(rem > 0) {
                    count++;
                }
                count = count + arr[i]/k;
            }
        }
        return count <=h;
    }
    public int minEatingSpeed(int[] arr, int h) {
        Arrays.sort(arr);
        int n=arr.length;
        long start = 1;
        long end = arr[n-1];
        long ans = end;
        while(start<=end){
            long mid = start + (end - start)/2;
            if(isValid(arr,mid,h)){
                ans = Math.min(ans,mid);
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return (int)ans;
    }
}
