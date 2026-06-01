package easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {


        int minLength = Integer.MAX_VALUE;
        for (String str: strs) {
            minLength = Math.min(minLength, str.length());
        }

        int r = minLength;
        int l = 0;

        while (l < r) {
            int mid = l + (r - l + 1) / 2;

            boolean pass = isCommonPrefix(strs, mid);

            if (pass){
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return strs[0].substring(0, r);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            // 若当前字符串长度不足len，或前len个字符不匹配，返回false
            if (strs[i].length() < len || !strs[i].substring(0, len).equals(prefix)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LongestCommonPrefix test = new LongestCommonPrefix();
//        System.out.println(test.longestCommonPrefix(new String[]{
//                "flower","flow","flight"
//        }));
//        System.out.println(test.longestCommonPrefix(new String[]{
//                "dog","racecar","car"
//        }));
//        System.out.println(test.longestCommonPrefix(new String[]{
//                ""
//        }));

        System.out.println(test.longestCommonPrefix(new String[]{
                "flower","flower","flower","flower"
        }));

        System.out.println(test.longestCommonPrefix(new String[]{
                "flower","flow","flight"
        }));
    }
}
