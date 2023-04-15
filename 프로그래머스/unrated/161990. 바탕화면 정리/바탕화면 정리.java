import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int minRow, minCol;
        int maxRow, maxCol;
        
        minRow = minCol = Integer.MAX_VALUE;
        maxRow = maxCol = Integer.MIN_VALUE;
        
        int row = wallpaper.length;
        int col = wallpaper[0].length();
        
        for (int i = 0; i < row; i ++)
        {
            for (int j = 0; j < col; j ++) 
            {
                if (wallpaper[i].charAt(j) == '#') {
                    minRow = Math.min(minRow, i);
                    minCol = Math.min(minCol, j);
                    maxRow = Math.max(maxRow, i);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        
        //max 값에 + 1을 하는 이유는 드래그를 하려면 끝점을 선택해야 함
        return new int[]{minRow, minCol, maxRow + 1, maxCol + 1};
    }
}