package hexlet.code.schemas;

import java.util.HashMap;

public class StringSchema extends BaseSchema<String>{

    public StringSchema() {
        predicateMap = new HashMap<>();
    }

    @Override
    public StringSchema required() {
        predicateMap.put("isRequiredOnEmptyStr", str -> !(str == null || str.isEmpty()));
        return this;
    }

    public StringSchema minLength(int length) {
        predicateMap.put("minLength", str -> str.length() >= length);
        return this;
    }

    public StringSchema contains(String contain) {
        predicateMap.put("contain", str -> str.contains(contain));
        return this;
    }






}
