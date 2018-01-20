public class Solution {
    public ArrayList<String> prettyJSON(String A) {
        StringBuffer sb = new StringBuffer();
        ArrayList<String> result = new ArrayList<String>();

        int numTabs = 0;
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (ch == '[' || ch == '{') {
                charNTimes(sb, '\t', numTabs);
                sb.append(ch);
                result.add(sb.toString());
                sb.delete(0, sb.length());
                numTabs++;
            } else if (ch == ':' && (A.charAt(i+1) == '{' || A.charAt(i+1) == '[')) {
                sb.append(ch);
                result.add(sb.toString());
                sb.delete(0, sb.length());
            } else if (ch == ',') {
                sb.append(ch);
                result.add(sb.toString());
                sb.delete(0, sb.length());
            } else if (ch == ']' || ch == '}') {
                result.add(sb.toString());
                sb.delete(0, sb.length());
                numTabs--;
                charNTimes(sb, '\t', numTabs);
                sb.append(ch);
//                result.add(sb.toString());
//                sb.delete(0, sb.length());
            } else {
                charNTimes(sb, '\t', numTabs);
                sb.append(ch);
            }
        }

        if (sb.length() != 0) {
            result.add(sb.toString());
            sb.delete(0, sb.length());
        }

        return result;
    }

    public StringBuffer charNTimes(StringBuffer sb, char ch, int times) {
        if (sb.length() == 0) {
            for (int t = 0; t < times; t++) {
               sb.append(ch);
            }
        }

        return sb;
    }
}
