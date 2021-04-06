import java.util.ArrayList;
import java.util.HashMap;

public class Finder {
    private HashMap<String, ArrayList<Integer>> literals_count = new HashMap<>();

    public void printHashMap(){
        literals_count.entrySet().forEach(entry -> {
            if(entry.getValue().size() > 1){
                System.out.print("Lines with '" + entry.getKey() + "': ");
                for(int i = 0; i < entry.getValue().size(); i++) {
                    System.out.print(entry.getValue().get(i));
                    if(i < entry.getValue().size() - 1)
                        System.out.print(", ");
                    else
                        System.out.println("");
                }
            }
        });
    }
    public void findLiteralsInString(String string, int i, String quote){
        String literal;
        for(int leftQuoteIndex = 0, rightQuoteIndex = 0; leftQuoteIndex != -1
                && leftQuoteIndex < string.length()
                && rightQuoteIndex < string.length(); rightQuoteIndex++){
            leftQuoteIndex = string.indexOf(quote, rightQuoteIndex);
            rightQuoteIndex = string.indexOf(quote, leftQuoteIndex + 1);

            if(leftQuoteIndex != -1 ){
                literal = string.substring(leftQuoteIndex + 1, rightQuoteIndex);

                putLiteralInHashMap(literal, i);
            }
        }
    }
    public void putLiteralInHashMap(String literal, int i){
        if (literals_count.containsKey(literal)) {
            if(!literals_count.get(literal).contains(i)) {
                literals_count.get(literal).add(i);
            }
        } else {
            literals_count.put(literal, new ArrayList<>());
            literals_count.get(literal).add(i);
        }
    }
}
