class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int res[] = new int[n+m];
        int p1 = 0;
        int p2 = 0;
        int k =0;
        while(p1 < n && p2 < m){
            if(nums1[p1] < nums2[p2]){
                res[k++] = nums1[p1++];
            }else{
                res[k++] = nums2[p2++];
            }
        }
        while(p1<n){
            res[k++] = nums1[p1++];
        }
         while(p2<m){
            res[k++] = nums2[p2++];
        }
        if(res.length%2  == 0){
            int len = res.length;
            return (double)(res[len/2] + res[len/2-1])/2;
        }else{
            return (double)res[res.length/2];
        }
    }
}
