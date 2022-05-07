package DS;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ConnectionBuilder;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/4/9 12:35
 * 4
 */
public class Parent {
    static int first=  1;

    static {
        System.out.println("parent" + first);
        first++;
    }

    static {
        System.out.println("parent" + first);
        first++;
    }

    int second = 1;

    public Parent(){
        System.out.println("construtor parent" + first +  " " + second);
        first++;
        second++;
    }

    public void display(){
        System.out.println("oarent:"+ first + " " + second);
        second++;
        first++;
    }

    public static void test(){
        System.out.println(" static oarent:"+ first );
        first++;
    }
}

class Child extends Parent{
    static int first=  1;

    static {
        System.out.println("child" + first);
        first++;
    }

    static {
        System.out.println("child" + first);
        first++;
    }

    int second = 1;

    public Child(){

        super();

        System.out.println("construtor child" + first +  " " + second);
        first++;
        second++;
    }

    public static void aTest(){
        System.out.println(" static child:"+ first );
        first++;
    }

    public void adisplay(){
        System.out.println("child:"+ first + " " + second);
        first++;
    }

    static AtomicInteger a = new AtomicInteger(1);





    public static void main(String[] args) {
//        try {
//            String str = "ABCDE";
//            byte[] bs = str.getBytes(StandardCharsets.UTF_8);
//            FileOutputStream file = new FileOutputStream("test.txt",true);
//            file.write(bs);
//            file.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        HashSet<Integer> hashSet = new HashSet();
        hashSet.add(30);
        hashSet.add(48);
        hashSet.add(66);
        hashSet.add(18);
        hashSet.add(74);
        hashSet.add(96);
        System.out.println();
    }


}

class Fruit{}
class Apple extends Fruit{}
class  Jona extends Apple{}

class ORan extends Fruit{}
