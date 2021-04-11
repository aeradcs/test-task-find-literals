import java.util.HashMap;

public class Finder {
    private HashMap<String, Pair> literalsLineNumberAmount = new HashMap<>();

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
        if (literalsLineNumberAmount.containsKey(literal)) {
           literalsLineNumberAmount.get(literal).put(lineNumber);
        } else {
           literalsLineNumberAmount.put(literal, new Pair());
           literalsLineNumberAmount.get(literal).put(lineNumber);
        }
    }

    public void printHashMap() {
        literalsLineNumberAmount.forEach((literal,pair)->{

            if(pair.getAmount() > 1){
                System.out.print("Lines with '" + literal + "': ");
                for(int i = 0; i < pair.getSetSize(); i++){
                    System.out.print(pair.getLineNumber(i));
                    if(i < pair.getSetSize() - 1){
                        System.out.print(", ");
                    }
                    else{
                        System.out.println("");
                    }
                }
            }
        });
    }


}

//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class Finder {
//    private HashMap<String, ArrayList<Integer>> literalsCount = new HashMap<>();
//
//    public void findLiteralsInString(String inputLine, int lineNumber, String quote) {
//        String literal;
//        for (int leftQuoteIndex = 0, rightQuoteIndex = 0;
//             (leftQuoteIndex = inputLine.indexOf(quote, rightQuoteIndex)) != -1; rightQuoteIndex++) {
//            rightQuoteIndex = inputLine.indexOf(quote, leftQuoteIndex + 1);
//
//            literal = inputLine.substring(leftQuoteIndex + 1, rightQuoteIndex);
//
//            putLiteralInHashMap(literal, lineNumber);
//        }
//    }
//
//    public void putLiteralInHashMap(String literal, int lineNumber) {
//        if (literalsCount.containsKey(literal)) {
//            //if (!literalsCount.get(literal).contains(lineNumber)) {
//                literalsCount.get(literal).add(lineNumber);
//            //}
//        } else {
//            literalsCount.put(literal, new ArrayList<>());
//            literalsCount.get(literal).add(lineNumber);
//        }
//    }
//
//    public void printHashMap() {
//        literalsCount.entrySet().forEach(entry -> {
//            if (entry.getValue().size() > 0) {
//                System.out.print("Lines with '" + entry.getKey() + "': ");
//                for (int i = 0; i < entry.getValue().size(); i++) {
//                    //if(i > 0 && entry.getValue().get(i - 1) != entry.getValue().get(i) || i == 0) {
//                        System.out.print(entry.getValue().get(i));
//                    //}
//                    if (i < entry.getValue().size() - 1)
//                        System.out.print(", ");
//                    else
//                        System.out.println("");
//                }
//            }
//        });
//    }
//
//    public void f(){
//        literalsCount.entrySet().forEach(entry -> {
//
//            for (int i = 0; i < entry.getValue().size(); i++) {
//                if(entry.getValue().size() == 1){
//                    entry.getValue().remove(0);
//                }
////                else if(entry.getValue().lastIndexOf(entry.getValue().get(0)) == entry.getValue().size() - 1){
////                    if(i != 0){
////                        entry.getValue().remove(i);
////                    }
////                }
//                else{
//                    if(i > 0 && entry.getValue().get(i) == entry.getValue().get(i - 1)){
//                        entry.getValue().remove(i);
//                    }
//                }
//            }
//
//        });
//    }
//}
