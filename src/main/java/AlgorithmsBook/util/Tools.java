package AlgorithmsBook.util;

import java.util.Random;

public class Tools {

    public static Integer[] generateOrderedDataWithSpecificSize(int size){
        Integer[] integers = new Integer[size];

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            integers[i] = i * 2;
        }
        return integers;

    }

    public static Integer[] generateRandomDataWithSpecificSize(int size){
        Integer[] integers = new Integer[size];

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            integers[i] = random.nextInt(size * 3);
        }
        return integers;

    }

    public static Integer[] generateReversedDataWithSpecificSize(int size){
        Integer[] integers = new Integer[size];

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            integers[i] = (size - i) * 2;

        }
        return integers;

    }
}
