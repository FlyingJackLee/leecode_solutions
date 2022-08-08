package AlgorithmsBook;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class UF {
    public int[] id;
    public int[] sz; //每个分节点对应的分量大小
    public int count;

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }

        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    public int count(){
        return count;
    }

    public boolean connected(int p,int q){
        return  find(p) == find(q);
    }

    //找到p的根节点
    public int find(int p){
        //如果p不是根节点（因为只有根节点是节点名称和节点值相同的！！！）
        while (p != id[p]){
            //将原来的长路径进行压缩
            id[p] = id[id[p]];

            //将p转化为p的下一个值
            p = id[p];
        }

        return p;
    }


    public void union(int p, int q){
        int i = find(p);
        int j = find(q);

        if (i == j){
            return;
        }

        //如果p节点的树更小
        if (sz[i] > sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
        }

        count--;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            IOTool ioTool = new IOTool(scanner.nextLine());

            try {
                int N = ioTool.readInt();
                UF uf = new UF(N);
                while (ioTool.hasNext()) {
                    int p = ioTool.readInt();
                    int q = ioTool.readInt();

                    if (uf.connected(p, q)) {
                        continue;
                    }

                    uf.union(p, q);
                    System.out.println(p + " " + q);
                }
                System.out.println(uf.count() + " components");

            }catch (IOException e){
                e.printStackTrace();
            }
            finally {
                try {
                    ioTool.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }



        }
        catch (FileNotFoundException e){
            System.out.println("Check the file name!");
        }

        scanner.close();



    }




}
