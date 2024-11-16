package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class StringSchema /*extends BaseSchema*/ {

    private Predicate<String> isRequired;
    private Predicate<String> isMinLength;
    private Predicate<String> isContains;
    private Map<String, Predicate<String>> predicateMap;

    public StringSchema() {
        predicateMap = new HashMap<>();
        isRequired = String::isEmpty;
    }

    public StringSchema required() {
        isRequired = str -> !str.isEmpty();
        predicateMap.put("required", isRequired);
        return this;
    }

    public StringSchema minLength(int length) {
        isMinLength = str -> str.length() >= length;
        predicateMap.put("minLength", isMinLength);
        return this;
    }

    public StringSchema contains(String contain) {
        isContains = str -> str.contains(contain);
        predicateMap.put("contain", isContains);
        return this;
    }

    public boolean isValid(String input) {
        return predicateMap.values()
                .stream()
                .allMatch(e -> e.test(input));
    }
}
