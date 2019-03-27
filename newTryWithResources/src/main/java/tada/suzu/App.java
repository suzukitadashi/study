package tada.suzu;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        String path = "C:/windows-version.txt";

        String val = "-------";
        try {
            FileReaderEx fr = new FileReaderEx(path);
            System.out.println("firstLineOfFile call start");
            val = firstLineOfFile(fr, val);
            System.out.println("firstLineOfFile call end");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("----------------");
        System.out.println(val);
    }

    static String firstLineOfFile(FileReader fr, String defaultVal) {
        System.out.println("firstLineOfFile start");
        BufferedReaderEx br = new BufferedReaderEx(fr);
        String val = defaultVal;
        try (br) {
            val =  br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("firstLineOfFile end");
        return val;
    }
}
