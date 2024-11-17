package hexlet.code.schemas;

import java.util.HashMap;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema() {
        predicateMap = new HashMap<>();
    }

    public NumberSchema positive() {
        predicateMap.put("isPositive", num -> {
            if (num == null) {
                return true;
            }
            return num > 0;
        });
        return this;
    }

    public NumberSchema range(int first, int last) {
        predicateMap.put("isInRange", num -> num >= first && num <= last);
        return this;
    }



}
