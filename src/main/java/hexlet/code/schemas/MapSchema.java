package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    public void sizeof(int i) {
    }

    public void shape(Map<String, BaseSchema<String>> schemas) {
    }

    @Override
    public boolean isValid(String input) {
        return false;
    }
}
