import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        Finder finder = new Finder();
        File in = new File(args[0]);
        Scanner scanner = new Scanner(in);
        String string;

        while (scanner.hasNextLine()) {
            string = scanner.nextLine();

            finder.findSingleQuoteLiteral(string);
            finder.findDoubleQuoteLiteral(string);

        }

        finder.printHashMap();
        scanner.close();
    }

}
