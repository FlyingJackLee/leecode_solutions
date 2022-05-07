package DS;

import java.util.ArrayList;
import java.util.List;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/28 13:57
 * 4
 */
public class UF {
    private int[] id;
    private int count;

    public UF(int N){
        count = N;

        id = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int getCount() {
        return count;
    }

//    public boolean connected(int p, int q){
//        return
//    }

//    public int find(int p){
//
//    }

    public void union(int p, int q){

    }

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        List<Object> objList = new ArrayList<>();
        System.out.println("2");
        System.out.println("2");

    }

}
