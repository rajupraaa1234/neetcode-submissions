class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double arr[][]=new double[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = position[i];
            arr[i][1] = (double)(target-position[i])/speed[i];
        }

        Arrays.sort(arr, (a, b) -> Double.compare(b[0], a[0]));
        int count = 0;
        double prevTime = 0;
        for(double cars[] : arr){
            if(cars[1] > prevTime){
                count++;
                prevTime = cars[1];
            }
        }
        return count;
    }
}
