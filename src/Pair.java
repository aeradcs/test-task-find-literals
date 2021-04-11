import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Pair {
    private Set<Integer> lineNumbers;
    private Integer amount;

    public Pair() {
        lineNumbers = new LinkedHashSet<>();
        amount = 0;
    }

    public void put(Integer value) {
        lineNumbers.add(value);
        amount++;
    }

    public Integer getLineNumber(int i) {
        Iterator<Integer> iter = lineNumbers.iterator();
        Integer current = null;
        for (int k = 0; iter.hasNext(); k++) {
            current = iter.next();
            if (k == i) {
                break;
            }
        }
        return current;

    }

    public Integer getAmount() {
        return amount;
    }

    public int getSetSize() {
        return lineNumbers.size();
    }
}
