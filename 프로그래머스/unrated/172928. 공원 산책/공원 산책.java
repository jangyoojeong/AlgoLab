class Solution {
    public int[] solution(String[] park, String[] routes) {
        
        int x = 0, y = 0; 
        
        int row = park.length;
        int col = park[0].length();
        
        char[][] xy = new char[row][col];
            
        for (int i = 0; i < row; i ++) 
        {
            for (int j = 0; j < col; j ++) 
            {
                xy[i][j] = park[i].charAt(j);
                
                if (xy[i][j] == 'S') 
                {
                    x = j;
                    y = i;
                }
            }
        }
        
        String direction = "";
        int distance = 0;
        
        for (int i = 0; i < routes.length; i ++) 
        {
            direction = routes[i].split(" ")[0];
            distance = Integer.parseInt(routes[i].split(" ")[1]);
            
            switch (direction) 
            {
                case "E" :
                    if (x + distance < col) 
                    {
                        x = moveToX(direction, x, y, distance, xy);
                    }
                    break;
                case "W" :
                    if (x - distance >= 0) 
                    {
                        x = moveToX(direction, x, y, distance, xy);
                    }
                    break;
                case "S" :
                    if (y + distance < row) 
                    {
                        y = moveToY(direction, x, y, distance, xy);
                    }
                    break;
                case "N" :
                    if (y - distance >= 0) 
                    {
                        y = moveToY(direction, x, y, distance, xy);
                    }
                    break;
            }
        }
        
        int[] result = {y, x};
        
        return result;
    }
    
    public int moveToX (String direction, int x, int y, int distance, char[][] xy) 
    {
        int move = x;
        
        if (direction.equals("E")) 
        {
            for (int i = 0; i < distance; i ++) 
            {
                x ++;
                if (xy[y][x] == 'X') 
                {
                    x = move;
                    break;
                }
            }
        }
        else
        {
            for (int i = 0; i < distance; i ++) 
            {
                x --;
                if (xy[y][x] == 'X') 
                {
                    x = move;
                    break;
                }
            }
        }
        return x;
    }
    
    public int moveToY (String direction, int x, int y, int distance, char[][] xy) 
    {
        int move = y;
        
        if (direction.equals("S")) 
        {
            for (int i = 0; i < distance; i ++) 
            {
                y ++;
                if (xy[y][x] == 'X') 
                {
                    y = move;
                    break;
                }
            }
        }
        else
        {
            for (int i = 0; i < distance; i ++) 
            {
                y --;
                if (xy[y][x] == 'X') 
                {
                    y = move;
                    break;
                }
            }
        }
        return y;
    }
}