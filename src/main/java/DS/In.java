package DS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/25 18:56
 * 4
 */
public class In {
    private Scanner scanner;

    public In(String path){
        try {
            FileInputStream fin = new FileInputStream(path);
            InputStreamReader reader = new InputStreamReader(fin);
            this.scanner =  new Scanner( new BufferedReader(reader));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public int nextInt(){
        return this.scanner.nextInt();
    }

    public boolean hasNext(){
        return scanner.hasNext();
    }

}
