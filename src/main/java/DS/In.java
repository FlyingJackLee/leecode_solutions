package DS;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/25 18:56
 * 4
 */
public class In {
    private Scanner scanner;

    public In(String path){
        InputStream is = getClass().getClassLoader().getResourceAsStream(path);
        InputStreamReader reader = new InputStreamReader(is);
        this.scanner =  new Scanner( new BufferedReader(reader));
    }

    public int nextInt(){
        return this.scanner.nextInt();
    }

    public boolean hasNext(){
        return scanner.hasNext();
    }

}
