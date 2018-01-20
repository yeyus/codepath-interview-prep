/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        ArrayList<Interval> result = new ArrayList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval i: intervals) {
            if (i.start <= end) {
                end = Math.max(end, i.end);
            } else {
                result.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
        }

        result.add(new Interval(start, end));
        return result;
    }
}
