import java.util.ArrayList;
import java.util.HashMap;

public class Finder {
    private HashMap<String, ArrayList<Integer>> literalsCount = new HashMap<>();

    public void findLiteralsInString(String inputLine, int lineNumber, String quote) {
        String literal;
        for (int leftQuoteIndex = 0, rightQuoteIndex = 0;
             (leftQuoteIndex = inputLine.indexOf(quote, rightQuoteIndex)) != -1; rightQuoteIndex++) {
            rightQuoteIndex = inputLine.indexOf(quote, leftQuoteIndex + 1);

            literal = inputLine.substring(leftQuoteIndex + 1, rightQuoteIndex);

            putLiteralInHashMap(literal, lineNumber);
        }
    }

    public void putLiteralInHashMap(String literal, int lineNumber) {
        if (literalsCount.containsKey(literal)) {
            if (!literalsCount.get(literal).contains(lineNumber)) {
                literalsCount.get(literal).add(lineNumber);
            }
        } else {
            literalsCount.put(literal, new ArrayList<>());
            literalsCount.get(literal).add(lineNumber);
        }
    }

    public void printHashMap() {
        literalsCount.entrySet().forEach(entry -> {
            if (entry.getValue().size() > 1) {
                System.out.print("Lines with '" + entry.getKey() + "': ");
                for (int i = 0; i < entry.getValue().size(); i++) {
                    System.out.print(entry.getValue().get(i));
                    if (i < entry.getValue().size() - 1)
                        System.out.print(", ");
                    else
                        System.out.println("");
                }
            }
        });
    }
}
