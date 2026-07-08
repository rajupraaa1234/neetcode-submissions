class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int row = arr.length;
        int col = arr[0].length;

        int start = 0;
        int end = col-1;
        while(start<row && end>=0){
            if(arr[start][end] > target){
                end--;
            } else if(arr[start][end] < target) {
                start++;
            } else {
                return true;
            }
        }
        return false;
    }
}
