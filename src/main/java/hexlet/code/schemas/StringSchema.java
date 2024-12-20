package hexlet.code.schemas;

import java.util.HashMap;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema() {
        predicatesMap = new HashMap<>();
    }

    @Override
    public StringSchema required() {
        predicatesMap.put("isRequiredOnEmptyStr", str -> !(str == null || str.isEmpty()));
        return this;
    }

    public StringSchema minLength(int length) {
        predicatesMap.put("minLength", str -> str != null && str.length() >= length);
        return this;
    }

    public StringSchema contains(String contain) {
        predicatesMap.put("contain", str -> str != null && str.contains(contain));
        return this;
    }
}
