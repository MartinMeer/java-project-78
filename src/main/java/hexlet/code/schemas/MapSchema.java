package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema<Map> {

    public MapSchema() {
        predicateMap = new HashMap<>();
    }

    public MapSchema sizeof(int size) {
        predicateMap.put("isSize", map -> map.size() == size);
        return this;
    }

    public void shape(Map<String, BaseSchema<String>> schemas) {

    }
}
