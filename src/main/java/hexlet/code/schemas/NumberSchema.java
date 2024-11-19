package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Objects;
import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema() {
        predicateMap = new HashMap<>();
    }

    public NumberSchema positive() {
        Predicate<Integer> isNull = Objects::isNull;
        Predicate<Integer> isPositive = num -> num > 0;
        predicateMap.put("isPositive", isNull.or(isPositive));
        return this;
    }

    public NumberSchema range(int first, int last) {
        predicateMap.put("isInRange", num -> num >= first && num <= last);
        return this;
    }



}
