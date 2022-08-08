package AlgorithmsBook;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOTool {
    private InputStream readFileStream;
    private final Scanner scanner;

    public IOTool(String fileName) throws FileNotFoundException {
        String resourcesPath = this.getClass().getClassLoader().getResource("data/").getPath();

        this.readFileStream = new FileInputStream(resourcesPath + fileName);

        scanner = new Scanner(this.readFileStream, StandardCharsets.UTF_8);
    }

    public int readInt() throws IOException {
        if (scanner.hasNext()){
            return scanner.nextInt();
        }
        else {
            throw new IOException("End of File");
        }
    }
    public int[] readInt(int numberOfParameters) throws IOException {
        int[] parameters = new int[numberOfParameters];
        for (int i = 0; i < numberOfParameters; i++) {
            parameters[i] = readInt();
        }
        return parameters;
    }

    public String readLine() throws IOException {
        if (scanner.hasNext()){
            return scanner.nextLine();
        }
        else {
            throw new IOException("End of File");
        }
    }

    public String[] readLines() throws IOException {
        List<String> results = new ArrayList<>();

        while (hasNext()){
            results.add(this.readLine());
        }

        return results.stream().toArray(String[]::new);

    }
    

    public boolean hasNext(){
        return scanner.hasNext();
    }

    public void close() throws IOException {
        if (readFileStream != null){
            readFileStream.close();
        }
        if (scanner != null){
            scanner.close();
        }
    }


}
