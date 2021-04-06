import java.util.HashMap;

public class Finder {
    private HashMap<String, Integer> literals_count = new HashMap<>();

    public void printHashMap(){
        literals_count.entrySet().forEach(entry -> {
            if(entry.getValue() > 1){
            System.out.println(entry.getKey() + " " + entry.getValue());
            }
        });
    }
    public void findSingleQuoteLiteral(String string){
        int j = 0, k = 0;
        String substring;
        while(j != -1 && j < string.length() && k < string.length()){
            j = string.indexOf("'", k);
            k = string.indexOf("'", j + 1);

            if(j != -1 ){
                substring = string.substring(j + 1,k);
                if(literals_count.containsKey(substring)){
                    literals_count.put(substring, literals_count.get(substring) + 1);
                }
                else{
                    literals_count.put(substring, 1);
                }

            }
            k++;
        }
    }
    public void findDoubleQuoteLiteral(String string){
        int j = 0, k = 0;
        String substring;
        while(j != -1 && j < string.length() && k < string.length()){
            j = string.indexOf("\"", k);
            k = string.indexOf("\"", j + 1);

            if(j != -1 ){
                substring = string.substring(j + 1,k);
                if(literals_count.containsKey(substring)){
                    literals_count.put(substring, literals_count.get(substring) + 1);
                }
                else{
                    literals_count.put(substring, 1);
                }

            }
            k++;
        }
    }
}
