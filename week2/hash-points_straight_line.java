public class Solution {
	public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        int n = a.size(), result = 0;
        if(n <= 2) return n;

        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.clear();
            int overlap = 0, max = 0;
            for (int j = i + 1 ; j < n ; j++) {
                int x=a.get(j)-a.get(i);
        	    int y=b.get(j)-b.get(i);
        	    if (x==0 && y==0){
        	        overlap++;
                    continue;
        	    }
       		    int gcd = gcd(x,y); // gcd will never be zero.
    		    x/=gcd;
  		        y/=gcd;
    		    String key = x + ":" + y;
    		    if (map.containsKey(key)) 
                    map.put(key,map.get(key) + 1);
    		    else 
                    map.put(key, 1);
                max = Math.max(max, map.get(key));
            }
            result = Math.max(result, max+overlap+1);
        }
        return result;
	}

	public int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }
}
