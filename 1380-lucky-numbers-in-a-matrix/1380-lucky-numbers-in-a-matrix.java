import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        int maxOfRowMins = Integer.MIN_VALUE;
        int targetColIdx = -1;
    
        for (int i = 0; i < matrix.length; i++) {
            int rowMin = Integer.MAX_VALUE;
            int colIdx = -1;
            
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < rowMin) {
                    rowMin = matrix[i][j];
                    colIdx = j;
                }
            }
            
            if (rowMin > maxOfRowMins) {
                maxOfRowMins = rowMin;
                targetColIdx = colIdx;
            }
        }
        

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][targetColIdx] > maxOfRowMins) {
                return result; 
            }
        }
        
        result.add(maxOfRowMins);
        return result;
    }
}
