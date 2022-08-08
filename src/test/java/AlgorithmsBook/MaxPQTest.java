package AlgorithmsBook;

import AlgorithmsBook.util.Tools;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class MaxPQTest {
    Integer[] data;
    
    @Before
    public void setUp(){
        this.data = Tools.generateRandomDataWithSpecificSize(20);
    }

    
    @Test
    public void test_orderedArrayMaxPQ(){
        OrderedMaxPQ orderedArrayMaxPQ = new OrderedMaxPQ(50);

        for (int i = 0; i < data.length; i++) {
            orderedArrayMaxPQ.insert(data[i]);
        }

        Arrays.sort(data);

        for (int i = data.length -1; i >0 ; i--) {
            Assert.assertEquals(data[i],orderedArrayMaxPQ.delMax());
        }

    }
    @Test
    public void test_binaryHeap(){
        MaxPQ orderedArrayMaxPQ = new BinaryHeap(50);

        for (int i = 0; i < data.length; i++) {
            orderedArrayMaxPQ.insert(data[i]);
        }

        Arrays.sort(data);

        for (int i = data.length -1; i >0 ; i--) {
            Assert.assertEquals(data[i],orderedArrayMaxPQ.delMax());
        }

    }

    @Test
    public void test_unorderedArrayMaxPQ(){
        UnorderedMaxPQ unOrderedArrayMaxPQ = new UnorderedMaxPQ(50);

        for (int i = 0; i < data.length; i++) {
            unOrderedArrayMaxPQ.insert(data[i]);
        }

        Arrays.sort(data);
        for (int i = data.length -1; i >0 ; i--) {
            Assert.assertEquals(data[i],unOrderedArrayMaxPQ.delMax());
        }

    }
}