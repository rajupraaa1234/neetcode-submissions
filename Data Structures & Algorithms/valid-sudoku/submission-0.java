class Solution {
    public boolean isSmallValide(int row,int col,char[][] arr){
       Set<Character> set = new HashSet<>();
       for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(arr[i][j] == '.') continue;
                else{
                    if(set.contains(arr[i][j])) return false;
                    set.add(arr[i][j]);
                }

            }
       }
       return true;
    }
    public boolean isCurrentRowOrColValid(int row,int col,char[][] arr){
         Set<Character> rowSet = new HashSet<>();
         Set<Character> colSet = new HashSet<>();

         for(int i=0;i<9;i++){
            if(arr[row][i] == '.') continue;
            else{
                if(rowSet.contains(arr[row][i])) return false;
                rowSet.add(arr[row][i]);
            }
         }

         for(int i=0;i<9;i++){
            if(arr[i][col] == '.') continue;
            else{
                if(colSet.contains(arr[i][col])) return false;
                colSet.add(arr[i][col]);
            }
         }
        return true;
    }
    public boolean isWholeSudokuValid(char arr[][]){
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(isCurrentRowOrColValid(i,j,arr) == false) return false; 
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int currRow = 0;

        System.out.println(isWholeSudokuValid(arr));
        if(isWholeSudokuValid(arr)==false) return false;
        while(currRow < 9){
            int currCol = 0;
            while(currCol < 9){
                if(isSmallValide(currRow,currCol,arr) == false) return false;
                currCol+=3;
            }
            currRow+=3;
        }
        return true;
    }
}
