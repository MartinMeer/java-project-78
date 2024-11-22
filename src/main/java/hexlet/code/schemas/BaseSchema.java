package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema <T> {

    protected Map<String, Predicate<T>> predicatesMap;

    public BaseSchema() {
        predicatesMap = new HashMap<>();
    }

    public BaseSchema<T> required() {
        predicatesMap.put("required", Objects::nonNull);
        return this;
    }


    private Predicate validate;
    private Predicate val(T input) {
        return e -> validate.test(input);
    }


    public boolean isValid(T input) {
        return predicatesMap.values()
                .stream()
                .allMatch(validate);
    }
}
