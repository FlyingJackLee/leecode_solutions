package AlgorithmsBook;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/5/7 14:22
 * 4
 */
public class Chapter1Test {
    @Test
    public void test_Dijkstra_calculate(){
        String op1 = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        Assert.assertEquals(101.0,Chapter1.Dijkstra(op1),2);
    }
}