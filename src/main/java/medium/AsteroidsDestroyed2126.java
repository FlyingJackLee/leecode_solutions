package medium;

import java.util.Arrays;

public class AsteroidsDestroyed2126 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long prefix = mass;

        for (int asteroid : asteroids) {
            if (prefix >= asteroid) {
                prefix = prefix + asteroid;
            } else {
                return false;
            }
        }

        return true;
    }
}
