package AlgorithmsBook;

import AlgorithmsBook.util.Tools;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Random;

import static AlgorithmsBook.util.Tools.*;

public class SortTemplateTest {
    final int PERFORMANCE_TEST_DATA_SIZE = 100000;
    final int TEST_DATA_SIZE = 100;


    Integer[] test_data = null;
    final String packagePath = "AlgorithmsBook.";
    SortTemplate sortTemplate = new SortTemplate();

    @Before
    public void set_up() throws IOException{
        this.test_data = generateRandomDataWithSpecificSize(TEST_DATA_SIZE);
    }


    @Test
    public void test_select_sort() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        AlgorithmPerformanceMonitor<Comparable[]> watch = new AlgorithmPerformanceMonitor<>();
        long consumeTime = watch.watchConsumerAlgorithm(packagePath + "SelectionSort",this.test_data);
        Assert.assertEquals(true, sortTemplate.isSorted(this.test_data));
    }

    @Test
    public void test_insert_sort() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        AlgorithmPerformanceMonitor<Comparable[]> watch = new AlgorithmPerformanceMonitor<>();
        long consumeTime = watch.watchConsumerAlgorithm(packagePath + "InsertSort",this.test_data);
        Assert.assertEquals(true, sortTemplate.isSorted(this.test_data));
    }

    @Test
    public void test_optimized_insert_sort() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        AlgorithmPerformanceMonitor<Comparable[]> watch = new AlgorithmPerformanceMonitor<>();
        long consumeTime = watch.watchConsumerAlgorithm(packagePath + "OptimizedInsertSort",this.test_data);
        Assert.assertEquals(true, sortTemplate.isSorted(this.test_data));
    }

    @Test
    public void test_shell_sort() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        AlgorithmPerformanceMonitor<Comparable[]> watch = new AlgorithmPerformanceMonitor<>();
        long consumeTime = watch.watchConsumerAlgorithm(packagePath + "ShellSort",this.test_data);
        Assert.assertEquals(true, sortTemplate.isSorted(this.test_data));
    }

    @Test
    public void test_merge_sort() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        AlgorithmPerformanceMonitor<Comparable[]> watch = new AlgorithmPerformanceMonitor<>();
        long consumeTime = watch.watchConsumerAlgorithm(packagePath + "MergeSort",this.test_data);
        Assert.assertEquals(true, sortTemplate.isSorted(this.test_data));
    }

    @Test
    public void test_merge_bottom_to_top_sort() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        AlgorithmPerformanceMonitor<Comparable[]> watch = new AlgorithmPerformanceMonitor<>();
        long consumeTime = watch.watchConsumerAlgorithm(packagePath + "MergeBottomToTopSort",this.test_data);
        Assert.assertEquals(true, sortTemplate.isSorted(this.test_data));
    }

    @Test
    public void test_optimized_merge_sort() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        AlgorithmPerformanceMonitor<Comparable[]> watch = new AlgorithmPerformanceMonitor<>();
        long consumeTime = watch.watchConsumerAlgorithm(packagePath + "OptimizedMergeSort",this.test_data);
        Assert.assertEquals(true, sortTemplate.isSorted(this.test_data));
    }

    @Test
    public void test_quick_sort() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        AlgorithmPerformanceMonitor<Comparable[]> watch = new AlgorithmPerformanceMonitor<>();
        long consumeTime = watch.watchConsumerAlgorithm(packagePath + "QuickSort",this.test_data);
        Assert.assertEquals(true, sortTemplate.isSorted(this.test_data));
    }

    @Test
    public void test_optimized_quick_sort() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        AlgorithmPerformanceMonitor<Comparable[]> watch = new AlgorithmPerformanceMonitor<>();
        long consumeTime = watch.watchConsumerAlgorithm(packagePath + "OptimizedQuickSort",this.test_data);
        Assert.assertEquals(true, sortTemplate.isSorted(this.test_data));
    }

    @Test
    public void test_heap_sort() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        AlgorithmPerformanceMonitor<Comparable[]> watch = new AlgorithmPerformanceMonitor<>();
        long consumeTime = watch.watchConsumerAlgorithm(packagePath + "HeapSort",this.test_data);
        Assert.assertEquals(true, sortTemplate.isSorted(this.test_data));
    }

    private void performance_help_method(String typeOfData, int size, Integer[] testData ) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println(typeOfData + " Array:( n = " + size + ")" );

        AlgorithmPerformanceMonitor<Comparable[]> watch = new AlgorithmPerformanceMonitor<>();
        long selectConsumeTime = watch.watchConsumerAlgorithm(packagePath + "SelectionSort", Arrays.copyOf(testData,testData.length));
        System.out.println("        Selection consume:" + selectConsumeTime + " ms.");

        long insertConsumeTime = watch.watchConsumerAlgorithm(packagePath + "InsertSort",Arrays.copyOf(testData,testData.length));
        System.out.println("        Insert consume:" + insertConsumeTime + " ms.");
        long optimizedInsertConsumeTime = watch.watchConsumerAlgorithm(packagePath + "OptimizedInsertSort",Arrays.copyOf(testData,testData.length));
        System.out.println("        OptimizedInsert consume:" + optimizedInsertConsumeTime + " ms.");

        long shellConsumeTime = watch.watchConsumerAlgorithm(packagePath + "ShellSort",Arrays.copyOf(testData,testData.length));
        System.out.println("        ShellSort consume:" + shellConsumeTime + " ms.");

        long mergeConsumeTime = watch.watchConsumerAlgorithm(packagePath + "MergeSort",Arrays.copyOf(testData,testData.length));
        System.out.println("        MergeSort consume:" + mergeConsumeTime + " ms.");
        long optimizedMergeConsumeTime = watch.watchConsumerAlgorithm(packagePath + "OptimizedMergeSort",Arrays.copyOf(testData,testData.length));
        System.out.println("        Optimized MergeSort consume:" + optimizedMergeConsumeTime + " ms.");

        long heapConsumeTime = watch.watchConsumerAlgorithm(packagePath + "HeapSort",Arrays.copyOf(testData,testData.length));
        System.out.println("        HeapSort consume:" + heapConsumeTime + " ms.");

        long optimizedQuickConsumeTime = watch.watchConsumerAlgorithm(packagePath + "OptimizedQuickSort",Arrays.copyOf(testData,testData.length));
        System.out.println("        Optimized QuickSort ConsumeTime consume:" + optimizedQuickConsumeTime + " ms.");
        long quickConsumeTime = watch.watchConsumerAlgorithm(packagePath + "QuickSort",Arrays.copyOf(testData,testData.length));
        System.out.println("        QuickSort consume:" + quickConsumeTime + " ms.");

    }

    @Test
    public void performance_test_among_select_insert_optimizedInsert_shell_in_ordered() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (int i = 100; i <= PERFORMANCE_TEST_DATA_SIZE; i*=10) {
            Integer[] testData = generateOrderedDataWithSpecificSize(i);
            performance_help_method("Ordered",i,testData);
        }
    }

    @Test
    public void performance_test_among_select_insert_optimizedInsert_shell_in_reversed() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (int i = 100; i < PERFORMANCE_TEST_DATA_SIZE; i*=10) {
            Integer[] testData = generateReversedDataWithSpecificSize(i);
            performance_help_method("Reversed",i,testData);
        }

    }

    @Test
    public void performance_test_among_select_insert_optimizedInsert_shell_in_random() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (int i = 100; i < PERFORMANCE_TEST_DATA_SIZE; i*=10) {
            Integer[] testData = generateRandomDataWithSpecificSize(i);
            performance_help_method("Random",i,testData);
        }

    }

    @Test
    public void performance_test_among_select_insert_optimizedInsert_shell_in_same() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (int i = 100; i < PERFORMANCE_TEST_DATA_SIZE; i*=10) {
            Integer[] testData = new Integer[i];
            Arrays.fill(testData,i);
            performance_help_method("Same Elements",i,testData);
        }

    }
}