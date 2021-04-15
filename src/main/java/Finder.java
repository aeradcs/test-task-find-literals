import java.util.HashMap;

public class Finder {
    private HashMap<String, Pair> literalsLineNumbersAmounts = new HashMap<>();

    public void findLiteralsInString(String inputLine, int lineNumber){
        String literal;
        int findQuote = 0, findBackSlash = 0, leftQuoteIndex = -1, rightQuoteIndex = -1;
        for(int i = 0; i < inputLine.length(); i++){
            if(findQuote == 0 && (inputLine.charAt(i) == '\'' || inputLine.charAt(i) == '\"')){//search for left quote
                findQuote = 1;
                leftQuoteIndex = i;
            }
            else if(findQuote == 1 && findBackSlash == 0 && (inputLine.charAt(i) == '\'' || inputLine.charAt(i) == '\"')){//search for right quote
                findQuote = 0;
                rightQuoteIndex = i;

                literal = inputLine.substring(leftQuoteIndex + 1, rightQuoteIndex);
                putLiteralLineNumberInHashMap(literal, lineNumber);
            }
            else if(findQuote == 1){//search for back-slashes to detect special character
                if(findBackSlash == 0 && (inputLine.charAt(i) == '\\')){
                    findBackSlash = 1;
                }
                else if(findBackSlash == 1){
                    findBackSlash = 0;
                }
            }
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
