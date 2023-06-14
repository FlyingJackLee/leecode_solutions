package easy;

public class SimilarRGB800 {
    public String similarRGB(String color) {
        StringBuffer sb = new StringBuffer("#");

        for (int i = 1; i < color.length(); i+=2) {
            int number = Integer.valueOf(color.substring(i, i + 2),16);
            String X = Integer.toHexString(Math.round((float) number/17 ));
            sb.append(X).append(X);
        }

        return sb.toString();
    }
}
