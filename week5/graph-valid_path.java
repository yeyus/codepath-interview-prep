public class Solution {
    class Point {
        public int x;
        public int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public String solve(int x, int y, int N, int R, ArrayList<Integer> XC, ArrayList<Integer> YC) {
        int cover[][] = new int[x+1][y+1];
        for (int[] row: cover)
            Arrays.fill(row, -1);
            
        cover[0][0] = 1;
        
        LinkedList<Point> queue = new LinkedList();
        queue.add(new Point(0,0));
        
        int moveX[] = {1, 1, 1, 0, -1, -1, -1, 0};
        int moveY[] = {-1, 0, 1, 1, 1, 0, -1, -1};
        
        while(!queue.isEmpty()) {
            Point t = queue.poll();
            
            if (withinBounds(x, y, t) && cover[t.x][t.y] == -1) {
                cover[t.x][t.y] = isValidPoint(XC, YC, R, t) ? 1 : 0;
                
                for (int i = 0; i < moveX.length; i++) {
                    Point movePoint = new Point(t.x + moveX[i], t.y + moveY[i]);
                    if (withinBounds(x, y, movePoint)) queue.add(movePoint);
                }
            }
        }
        
        if (cover[x][y] == 1) return "YES";
        
        return "NO";
    }
    
    public boolean withinBounds(int x, int y, Point p) {
        if (p.x < 0 || p.y < 0 || p.x > x || p.y > y) return false;
        
        return true;
    }
    
    public boolean isValidPoint(ArrayList<Integer> XC, ArrayList<Integer> YC, int R, Point p) {
        // check if in circle
        for (int i = 0; i < XC.size(); i++) {
            int cx = XC.get(i);
            int cy = YC.get(i);
            
            if (p.x == cx && p.y == cy) return false;
            
            int n = ((cx - p.x) * (cx - p.x)) + ((cy - p.y) * (cy - p.y));
            
            if (n <= R*R) {
                return false;
            }
        }
        
        return true;
    }
}
