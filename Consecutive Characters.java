class Solution {
    public int maxPower(String s) {
        int result = 0, i = 0, l = 0;
        for( ; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(l)) {
                result = Math.max(result, i - l);
                l = i;
            }
        }
        return Math.max(result, i - l);
    }
}