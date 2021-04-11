import java.util.HashMap;

public class Finder {
    private HashMap<String, Pair> literalsLineNumbersAmounts = new HashMap<>();

    public void findLiteralsInString(String inputLine, int lineNumber, String quote) {
        String literal;
        for (int leftQuoteIndex = 0, rightQuoteIndex = 0;
             (leftQuoteIndex = inputLine.indexOf(quote, rightQuoteIndex)) != -1; rightQuoteIndex++) {
            rightQuoteIndex = inputLine.indexOf(quote, leftQuoteIndex + 1);

            literal = inputLine.substring(leftQuoteIndex + 1, rightQuoteIndex);

            putLiteralLineNumberInHashMap(literal, lineNumber);
        }
    }

    public void putLiteralLineNumberInHashMap(String literal, int lineNumber) {
        if (!literalsLineNumbersAmounts.containsKey(literal)) {
            literalsLineNumbersAmounts.put(literal, new Pair());
        }
        literalsLineNumbersAmounts.get(literal).put(lineNumber);
    }

    public void printHashMap() {
        literalsLineNumbersAmounts.forEach((literal, pair) -> {
            if (pair.getLiteralOccurrencesAmount() > 1) {
                System.out.print("Lines with '" + literal + "': ");
                for (int i = 0; i < pair.getSetSize(); i++) {
                    System.out.print(pair.getLineNumber(i));
                    if (i < pair.getSetSize() - 1) {
                        System.out.print(", ");
                    } else {
                        System.out.println("");
                    }
                }
            }
        });
    }
}
