package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    protected T schema;
    protected Map<String, Predicate<T>> predicateMap;

    protected Predicate<String> contains;
    protected Predicate<String> length;
    Predicate<Integer> positive;
    Predicate<Integer> range;
    Predicate<Map> sizeof;



    public BaseSchema<String> required() {
        schema = (T) new Object();
        return null;
    }

    public abstract boolean isValid(String input);
}
