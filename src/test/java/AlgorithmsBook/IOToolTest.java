package AlgorithmsBook;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class IOToolTest {
    @Test(expected = FileNotFoundException.class)
    public void test_file_not_exist_return_IOException() throws FileNotFoundException {
        IOTool ioTool = new IOTool("not_exist.file");
    }

    @Test
    public void test_read_integer() throws IOException{
        IOTool ioTool = new IOTool("tinyUF.txt");

        Assert.assertEquals(ioTool.readInt(),10);
        Assert.assertArrayEquals(ioTool.readInt(2),new int[]{
                4,3
        });
        Assert.assertArrayEquals(ioTool.readInt(2),new int[]{
                3,8
        });
        Assert.assertArrayEquals(ioTool.readInt(2),new int[]{
                6,5
        });
    }

    @Test
    public void test_read_string() throws IOException {
        IOTool ioTool = new IOTool("tinyUF.txt");

        Assert.assertEquals(ioTool.readLine(),"10");
        Assert.assertEquals(ioTool.readLine(),"4 3");
        Assert.assertEquals(ioTool.readLine(),"3 8");
    }

    @Test
    public void test_read_strings() throws IOException {
        IOTool ioTool = new IOTool("tinyUF.txt");
        String[] completed_strings = ioTool.readLines();
        Assert.assertArrayEquals(completed_strings,new String[]{
                "10",
                "4 3",
                "3 8",
                "6 5",
                "9 4",
                "2 1",
                "8 9",
                "5 0",
                "7 2",
                "6 1",
                "1 0",
                "6 7"

        });

    }

    @Test(expected = IOException.class)
    public void test_end_of_file_exception() throws IOException {
        IOTool ioTool = new IOTool("tinyUF.txt");
        ioTool.readLines();
        ioTool.readInt();
    }

}