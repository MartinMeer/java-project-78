package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    private Predicate<String> minLength;

    public StringSchema minLength(int length) {
        minLength = str -> str.length() == length;
        return this;
    }

    @Override
    public boolean isValid(String input) {
        return minLength.test(input);
    }
}
