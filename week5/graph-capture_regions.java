public class Solution {
    class Point {
        public int row;
        public int column;
        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
    
	public void solve(ArrayList<ArrayList<Character>> a) {
	    if (a == null || a.size() == 0) {
	        return;
	    }
	    
	    int rows = a.size();
	    int columns = a.get(0).size();
	    
	    // check sides
	    for (int i = 0; i < rows; i++) {
	        // left
	        if (a.get(i).get(0) == 'O') {
	            bfs(a, i, 0);
	        }
	        // right
	        if (a.get(i).get(columns -1) == 'O') {
	            bfs(a, i, columns - 1);
	        }
	    }
	    
	    for (int j = 0; j < columns; j++) {
	        // upper
	        if (a.get(0).get(j) == 'O') {
	            bfs(a, 0, j);
	        }
	        // lower
	        if (a.get(rows-1).get(j) == 'O') {
	            bfs(a, rows-1, j);
	        }
	    }
	    
	    //System.out.print(a);
	    
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < columns; j++) {
	            if (a.get(i).get(j) == 'O') {
	                a.get(i).set(j, 'X');
	            }
	            if (a.get(i).get(j) == '-') {
	                a.get(i).set(j, 'O');
	            }
	        }
	    }
	    
	    //System.out.print(a);
	    
	}
	
	public void bfs(ArrayList<ArrayList<Character>> a, int row, int column) {
	    //System.out.printf("row: %d column: %d", row, column);
	    int rows = a.size();
	    int columns = a.get(0).size();
	    
	    int moveX[] = {1, -1, 0, 0};
	    int moveY[] = {0, 0, 1, -1};
	    
	    LinkedList<Point> queue = new LinkedList();
	    queue.add(new Point(row, column));
	    a.get(row).set(column, '-');
	    
	    while(!queue.isEmpty()) {
	        Point p = queue.poll();
	        for (int i = 0; i < moveX.length; i++) {
	            Point newPoint = new Point(p.row + moveX[i], p.column + moveY[i]);
	            if (isValid(newPoint, rows, columns) && 
	                a.get(newPoint.row).get(newPoint.column) == 'O') {
                    a.get(newPoint.row).set(newPoint.column, '-');
                    queue.add(newPoint);
	            }
	        }
	    }
	}
	
	public boolean isValid(Point p, int rows, int columns) {
	    return p.row > 0 && p.row < rows -1 && p.column > 0 && p.column < columns -1;
	}
}
public class Solution {
    class Point {
        public int row;
        public int column;
        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
    
	public void solve(ArrayList<ArrayList<Character>> a) {
	    if (a == null || a.size() == 0) {
	        return;
	    }
	    
	    int rows = a.size();
	    int columns = a.get(0).size();
	    
	    // check sides
	    for (int i = 0; i < rows; i++) {
	        // left
	        if (a.get(i).get(0) == 'O') {
	            bfs(a, i, 0);
	        }
	        // right
	        if (a.get(i).get(columns -1) == 'O') {
	            bfs(a, i, columns - 1);
	        }
	    }
	    
	    for (int j = 0; j < columns; j++) {
	        // upper
	        if (a.get(0).get(j) == 'O') {
	            bfs(a, 0, j);
	        }
	        // lower
	        if (a.get(rows-1).get(j) == 'O') {
	            bfs(a, rows-1, j);
	        }
	    }
	    
	    //System.out.print(a);
	    
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < columns; j++) {
	            if (a.get(i).get(j) == 'O') {
	                a.get(i).set(j, 'X');
	            }
	            if (a.get(i).get(j) == '-') {
	                a.get(i).set(j, 'O');
	            }
	        }
	    }
	    
	    //System.out.print(a);
	    
	}
	
	public void bfs(ArrayList<ArrayList<Character>> a, int row, int column) {
	    //System.out.printf("row: %d column: %d", row, column);
	    int rows = a.size();
	    int columns = a.get(0).size();
	    
	    int moveX[] = {1, -1, 0, 0};
	    int moveY[] = {0, 0, 1, -1};
	    
	    LinkedList<Point> queue = new LinkedList();
	    queue.add(new Point(row, column));
	    a.get(row).set(column, '-');
	    
	    while(!queue.isEmpty()) {
	        Point p = queue.poll();
	        for (int i = 0; i < moveX.length; i++) {
	            Point newPoint = new Point(p.row + moveX[i], p.column + moveY[i]);
	            if (isValid(newPoint, rows, columns) && 
	                a.get(newPoint.row).get(newPoint.column) == 'O') {
                    a.get(newPoint.row).set(newPoint.column, '-');
                    queue.add(newPoint);
	            }
	        }
	    }
	}
	
	public boolean isValid(Point p, int rows, int columns) {
	    return p.row > 0 && p.row < rows -1 && p.column > 0 && p.column < columns -1;
	}
}
