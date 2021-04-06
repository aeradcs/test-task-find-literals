import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Finder finder = new Finder();
        File in = new File(args[0]);
        Scanner scanner = new Scanner(in);
        String inputLine;

        for(int i = 0; scanner.hasNextLine(); i++) {
            inputLine = scanner.nextLine();

            finder.findLiteralsInString(inputLine, i, "'");
            finder.findLiteralsInString(inputLine, i, "\"");
        }
        finder.printHashMap();

        scanner.close();
    }
}
