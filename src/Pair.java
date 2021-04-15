import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Pair {
    private Set<Integer> lineNumbers;
    private Integer literalOccurrencesAmount;

    public Pair() {
        lineNumbers = new LinkedHashSet<>();
        literalOccurrencesAmount = 0;
    }

    public void put(Integer value) {
        lineNumbers.add(value);
        literalOccurrencesAmount++;
    }

    public Integer getLineNumber(int index) {
        Iterator<Integer> iter = lineNumbers.iterator();
        Integer current = null;
        for (int i = 0; iter.hasNext(); i++) {
            current = iter.next();
            if (i == index) {
                break;
            }
        }
        return current;
    }

    public Integer getLiteralOccurrencesAmount() {
        return literalOccurrencesAmount;
    }

    public int getSetSize() {
        return lineNumbers.size();
    }
}
