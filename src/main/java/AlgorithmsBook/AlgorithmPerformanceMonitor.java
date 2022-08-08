package AlgorithmsBook;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Consumer;

public class AlgorithmPerformanceMonitor<T> {

    public long compareTwoConsumerAlgorithms(
            String classNameOfAlg1,String classNameOfAlg2,T paramter) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Consumer<T> alg1 = (Consumer<T>) Class.forName(classNameOfAlg1)
                .getDeclaredConstructor().newInstance();
        Consumer<T> alg2 = (Consumer<T>) Class.forName(classNameOfAlg2)
                .getDeclaredConstructor().newInstance();

        return watchConsumerAlgorithm(alg1,paramter) - watchConsumerAlgorithm(alg2,paramter);
    }

    public long watchConsumerAlgorithm(
            String classNameOfAlg, T parameter ) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Consumer<T> alg = (Consumer<T>) Class.forName(classNameOfAlg).getDeclaredConstructor().newInstance();return watchConsumerAlgorithm(alg,parameter);
    }

    private long watchConsumerAlgorithm(
            Consumer<T> alg, T parameter ){
        long startTime = System.currentTimeMillis();
        alg.accept(parameter);
        long endTime = System.currentTimeMillis();
        assert new SortTemplate().isSorted((Comparable[]) parameter);
        return endTime - startTime;
    }

}
