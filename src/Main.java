import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Finder finder = new Finder();
        File in = new File(args[0]);
        Scanner scanner = new Scanner(in);
        String inputLine;

        for (int lineNumber = 0; scanner.hasNextLine(); lineNumber++) {
            inputLine = scanner.nextLine();

            finder.findLiteralsInString(inputLine, lineNumber, "'");
            finder.findLiteralsInString(inputLine, lineNumber, "\"");
        }
        finder.printHashMap();

        scanner.close();
    }
}
