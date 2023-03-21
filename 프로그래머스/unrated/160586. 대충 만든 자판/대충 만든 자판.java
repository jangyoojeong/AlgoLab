import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        // targets 배열 길이만큼 생성
        int[] result = new int[targets.length];
        
        for (int i = 0; i < targets.length; i ++)
        {
            // targets 문자 완성 여부
            boolean flag = true; 
            
            for (int j = 0; j < targets[i].length(); j ++) 
            {
                ArrayList<Integer> tempList = new ArrayList<Integer>();

                for (int k = 0; k < keymap.length; k ++) 
                {
                    // 해당 문자 없으면 -1 반환 => 문자를 찾은 경우에만 배열 추가
                    char target = targets[i].charAt(j);
                    int idx     = keymap[k].indexOf(target);
                    
                    if (idx > -1) 
                    {
                        tempList.add(idx);
                    }
                }
                
                if (tempList.size() > 0) 
                {
                    // 배열 정렬 (최소값 찾기 위함)
                    Collections.sort(tempList);
                    result[i] += tempList.get(0) + 1;
                }
                else
                {
                    // targets 문자 완성 실패
                    flag = false;
                }
                
            }
            
            if (!flag) 
            {
                // targets 문자 완성 실패시 -1
                result[i] = -1;
            }

        }
        
        return result;
    }
}