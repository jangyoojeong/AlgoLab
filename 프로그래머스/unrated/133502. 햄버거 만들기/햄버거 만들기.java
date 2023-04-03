import java.util.ArrayList;

class Solution {
    public int solution(int[] ingredient) {
        int result = 0;

        ArrayList<Integer> arrList = new ArrayList<Integer>();
        
        for (int i : ingredient) 
        {
            arrList.add(i);
            
            if (arrList.size() >= 4) 
            {
                // 1, 2, 3, 1
                if (arrList.get(arrList.size() - 4) == 1
                 && arrList.get(arrList.size() - 3) == 2
                 && arrList.get(arrList.size() - 2) == 3
                 && arrList.get(arrList.size() - 1) == 1) 
                {
                    result ++;
                    arrList.remove(arrList.size() - 1);
                    arrList.remove(arrList.size() - 1);
                    arrList.remove(arrList.size() - 1);
                    arrList.remove(arrList.size() - 1);
                }
            }   
        }
        return result;
    }
}