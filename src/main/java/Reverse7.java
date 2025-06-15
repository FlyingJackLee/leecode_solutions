public class Reverse7 {
    public static int reverse(int x) {
        int revered = 0;

        while (Math.abs(x) > 0) {
            if ( revered > Integer.MAX_VALUE/10 || revered < Integer.MIN_VALUE/10) {
                return 0;
            }

            if ((revered == Integer.MAX_VALUE/10 && x%10 > 7) || (revered == Integer.MIN_VALUE/10 && x%10 < -7)){
                return 0;
            }

            revered = revered * 10 + x % 10;
            x = x /10;
        }

        return revered;
    }
}
